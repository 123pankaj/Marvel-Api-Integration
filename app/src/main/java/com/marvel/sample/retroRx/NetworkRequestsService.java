package com.marvel.sample.retroRx;

import android.support.annotation.NonNull;

import com.google.gson.JsonObject;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.marvel.sample.constants.MarvelConstants;
import com.marvel.sample.fragments.models.CharactersResponse;
import com.marvel.sample.fragments.models.ComicsResponse;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class NetworkRequestsService {
    private static DataRequestMethods instance;

    public static synchronized DataRequestMethods getInstance() {
        if (instance == null) {
            instance = getRetrofit().create(DataRequestMethods.class);
        }
        return instance;
    }

    @NonNull
    private static Retrofit getRetrofit() {
        return new Retrofit
                .Builder()
                .baseUrl(MarvelConstants.BaseUrl)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient
                .Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
    }

    public interface DataRequestMethods {
        String Limit = "limit";
        String ApiKey = "apikey";
        String HashKey = "hash";
        String TimeStamp = "ts";
        String Offset = "offset";

        @GET(MarvelConstants.ComicsUrl)
        Observable<ComicsResponse> getComicsList(@Query(Offset) Integer offset, @Query(Limit) Integer limit, @Query(ApiKey) String apikey, @Query(HashKey) String hash, @Query(TimeStamp) String ts);

        @GET(MarvelConstants.CharactersUrl)
        Observable<CharactersResponse> getCharactersList(@Query(Offset) Integer offset, @Query(Limit) Integer limit, @Query(ApiKey) String apikey, @Query(HashKey) String hash, @Query(TimeStamp) String ts);

        @GET(MarvelConstants.ComicsDetailPageUrl + "{comicId}")
        Observable<JsonObject> getComicsDetails(@Path("comicId") int comicId, @Query(ApiKey) String apiKey, @Query(HashKey) String hash, @Query(TimeStamp) String ts);

        @GET(MarvelConstants.CharactersDetailPageUrl + "{characterId}")
        Observable<JsonObject> getCharacterDetail(@Path("characterId") int characterId, @Query(ApiKey) String apiKey, @Query(HashKey) String hash, @Query(TimeStamp) String ts);

    }
}
