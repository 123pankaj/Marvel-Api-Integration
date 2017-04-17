package com.marvel.sample.mvp;

import com.marvel.sample.fragments.models.ComicsResponse;

/**
 * Created by pankaj on 4/16/2017.
 */

public interface IComicsView {
    void setData(ComicsResponse response);
    void setError(Throwable error);
}
