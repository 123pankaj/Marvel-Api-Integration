package com.marvel.sample.mvp;

import com.marvel.sample.R;
import com.marvel.sample.controller.MarvelAppController;
import com.marvel.sample.fragments.models.CharactersResponse;
import com.marvel.sample.retroRx.NetworkRequestsService;
import com.marvel.sample.utils.MarvelUtils;

import java.util.Date;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by pankaj on 4/16/2017.
 */

public class CharactersPresenter implements ICharactersPresenter {
    private CompositeDisposable mCompositeDisposable;
    private Integer offset=0;

    private ICharactersView iCharactersView;

    public CharactersPresenter(ICharactersView view){
        this.iCharactersView=view;
        mCompositeDisposable = new CompositeDisposable();
    }


    @Override
    public void getCharactersListFromMarvelServers() {
        String ts = String.valueOf(new Date().getTime());
        String hashKey = ts +
                MarvelAppController.getMarvelContext().getString(R.string.marvel_private_key)
                + MarvelAppController.getMarvelContext().getString(R.string.marvel_public_key);

        mCompositeDisposable.add(NetworkRequestsService.getInstance().getCharactersList(offset, 15, MarvelAppController.getMarvelContext().getString(R.string.marvel_public_key), MarvelUtils.md5(hashKey),ts)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::comicsResponse, this::comicsError));
    }

    private void comicsResponse(CharactersResponse object){
        System.out.println("****** " + object.toString());
        if (object.getCode()==200){
            offset=offset+15;
            iCharactersView.setData(object);
        }
    }

    private void comicsError(Throwable error){
        iCharactersView.setError(error);
    }

}
