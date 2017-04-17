package com.marvel.sample.mvp;

import android.util.Log;

import com.marvel.sample.R;
import com.marvel.sample.controller.MarvelAppController;
import com.marvel.sample.fragments.models.ComicsResponse;
import com.marvel.sample.retroRx.NetworkRequestsService;
import com.marvel.sample.utils.MarvelUtils;

import java.util.Date;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pankaj on 4/16/2017.
 */

public class ComicsPresenter implements IComicsPresenter {
    private CompositeDisposable mCompositeDisposable;
    private Integer offset = 0;
    private IComicsView iComicsView;
    private static final String TAG = "ComicsPresenter==>";

    public ComicsPresenter(IComicsView view) {
        this.iComicsView = view;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getComicsListFromMarvelServers() {
        String ts = String.valueOf(new Date().getTime());
        String hashKey = ts +
                MarvelAppController.getMarvelContext().getString(R.string.marvel_private_key)
                + MarvelAppController.getMarvelContext().getString(R.string.marvel_public_key);

        mCompositeDisposable.add(NetworkRequestsService.getInstance().getComicsList(offset, 15, MarvelAppController.getMarvelContext().getString(R.string.marvel_public_key), MarvelUtils.md5(hashKey), ts)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::comicsResponse, this::comicsError));
    }

    private void comicsResponse(ComicsResponse object) {
        if (object.getCode() == 200) {
            offset = offset + 15;
            iComicsView.setData(object);
            Log.e(TAG, "SUCCESS");
        }
    }

    private void comicsError(Throwable error) {
        iComicsView.setError(error);
        Log.e(TAG, "I AM HERE IN ERROR");

    }

}

