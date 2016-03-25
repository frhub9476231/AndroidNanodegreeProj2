package com.nanodegree.myproject1.popularmovieapp;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.nanodegree.myproject1.popularmovieapp.dto.MoviesList;

/**
 * Created by frank on 10/20/15.
 */
public class FetchMoviesTask extends AsyncTask<String, Void, MoviesList> {

    @Override
    protected MoviesList doInBackground(String... params) {
        Log.i(Constants.LOG_TAG, "in background");
        Uri uri = constructUrl(params);
        Log.i(Constants.LOG_TAG, uri + "");
        String apiResult = Utility.callAPI(uri);
        Log.i(Constants.LOG_TAG, apiResult == null ? "api result is null":apiResult);
        MoviesList res = parseJson(apiResult);
        Log.i(Constants.LOG_TAG, res + "");
        return res;
    }

    private final String BASE_URL = Constants.BASE_API_URL + "/discover/movie";
    private final String API_KEY_PARAM = Constants.Params.API_KEY_PARAM;
    private final String SORT_BY_PARAM = Constants.Params.SORT_BY_PARAM;
    private final String SORT_BY = "popularity.desc";

    private Uri constructUrl(String... params) {
        Log.i(Constants.LOG_TAG, "url params: " + params[0]);
        Uri uri = Uri.parse(BASE_URL).buildUpon().appendQueryParameter(SORT_BY_PARAM, params[0]).appendQueryParameter(API_KEY_PARAM, Constants.API_KEY).build();
        return uri;
    }

    private MoviesList parseJson(String json) {
        Gson gson = new Gson();
        MoviesList movies = gson.fromJson(json, MoviesList.class);
        return movies;
    }
}
