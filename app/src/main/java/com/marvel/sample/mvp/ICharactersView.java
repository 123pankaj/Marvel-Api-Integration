package com.marvel.sample.mvp;

import com.marvel.sample.fragments.models.CharactersResponse;

/**
 * Created by pankaj on 4/16/2017.
 */

public interface ICharactersView {

    void setData(CharactersResponse response);
    void setError(Throwable error);

}
