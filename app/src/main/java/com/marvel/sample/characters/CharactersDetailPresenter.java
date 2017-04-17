package com.marvel.sample.characters;

import android.util.Log;

import com.google.gson.JsonObject;
import com.marvel.sample.R;
import com.marvel.sample.comics.IComicDetailView;
import com.marvel.sample.controller.MarvelAppController;
import com.marvel.sample.mvp.ICharactersPresenter;
import com.marvel.sample.mvp.ICharactersView;
import com.marvel.sample.retroRx.NetworkRequestsService;
import com.marvel.sample.utils.MarvelUtils;

import java.util.Date;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pankaj on 4/17/2017.
 */

public class CharactersDetailPresenter implements ICharactersDetailPresenter{

    private ICharactersDetailView view;
    private CompositeDisposable mCompositeDisposable;
    private static final String TAG = "CharactersDPresenter";


    public CharactersDetailPresenter(ICharactersDetailView v){
        this.view=v;
        mCompositeDisposable = new CompositeDisposable();
    }
    @Override
    public void getCharacterDetail(int characterId) {
        String ts = String.valueOf(new Date().getTime());
        String hashKey = ts +
                MarvelAppController.getMarvelContext().getString(R.string.marvel_private_key)
                + MarvelAppController.getMarvelContext().getString(R.string.marvel_public_key);

        mCompositeDisposable.add(NetworkRequestsService.getInstance().getCharacterDetail(characterId, MarvelAppController.getMarvelContext().getString(R.string.marvel_public_key), MarvelUtils.md5(hashKey), ts)
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
