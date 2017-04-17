package com.marvel.sample.comics;

import android.nfc.Tag;
import android.util.Log;

import com.google.gson.JsonObject;
import com.marvel.sample.R;
import com.marvel.sample.controller.MarvelAppController;
import com.marvel.sample.retroRx.NetworkRequestsService;
import com.marvel.sample.utils.MarvelUtils;

import java.util.Date;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pankaj on 4/17/2017.
 */

public class ComicsDetailPresenter implements IComicsDetailPresenter {
    private IComicDetailView view;
    private CompositeDisposable mCompositeDisposable;
    private static final String TAG = "ComicsDetailPresenter";


    public ComicsDetailPresenter(IComicDetailView v){
        this.view=v;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getComicsDetail(int comicsId) {
        String ts = String.valueOf(new Date().getTime());
        String hashKey = ts +
                MarvelAppController.getMarvelContext().getString(R.string.marvel_private_key)
                + MarvelAppController.getMarvelContext().getString(R.string.marvel_public_key);

        mCompositeDisposable.add(NetworkRequestsService.getInstance().getComicsDetails(comicsId, MarvelAppController.getMarvelContext().getString(R.string.marvel_public_key),MarvelUtils.md5(hashKey), ts)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::comicsResponse, this::comicsError));
    }

    private void comicsResponse(JsonObject object) {
        Log.i(TAG, object.toString());
    }

    private void comicsError(Throwable error){
        Log.i(TAG, error.getMessage());
    }
}
