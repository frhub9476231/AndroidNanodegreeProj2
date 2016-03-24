package com.nanodegree.myproject1.popularmovieapp;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.nanodegree.myproject1.popularmovieapp.dto.TrailersList;

/**
 * Created by frank on 2/12/16.
 */
public class FetchTrailersTask extends AsyncTask<String, Void, TrailersList> {

    @Override
    protected TrailersList doInBackground(String... params) {
        Log.i(Constants.LOG_TAG, "in background");
        Uri uri = constructUrl(params);
        Log.i(Constants.LOG_TAG, uri + "");
        String apiResult = Utility.callAPI(uri);
        Log.i(Constants.LOG_TAG, apiResult == null ? "api result is null" : apiResult);
        TrailersList res = Utility.parseJson(apiResult, TrailersList.class);
        Log.i(Constants.LOG_TAG, res + "");
        return res;
    }

    private final String BASE_URL = "http://api.themoviedb.org/3/movie";
    private final String API_KEY_PARAM = "api_key";

    private Uri constructUrl(String... params) {
        Log.i(Constants.LOG_TAG, "url params: " + params[0]);
        String movieId = params[0];
        Uri uri = Uri.parse(BASE_URL).buildUpon().appendPath(movieId).appendPath("videos").appendQueryParameter(API_KEY_PARAM, Constants.API_KEY).build();
        Log.i(Constants.LOG_TAG, uri + "");
        return uri;
    }
}
