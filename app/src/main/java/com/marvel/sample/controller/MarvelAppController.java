package com.marvel.sample.controller;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by pankaj on 4/16/2017.
 */

public class MarvelAppController extends MultiDexApplication {
    private static MarvelAppController marvelAppAppInstance;
    private static final String TAG = "MarvelAppController";


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Application started");

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        MultiDex.install(this);
        marvelAppAppInstance = this;
    }

    public static MarvelAppController getMarvelContext() {
        return marvelAppAppInstance;
    }

}
