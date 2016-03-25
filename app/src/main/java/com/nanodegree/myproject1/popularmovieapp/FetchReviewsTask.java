package com.nanodegree.myproject1.popularmovieapp;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.nanodegree.myproject1.popularmovieapp.dto.ReviewsList;

/**
 * Created by frank on 2/20/16.
 */
public class FetchReviewsTask extends AsyncTask<String, Void, ReviewsList> {
    @Override
    protected ReviewsList doInBackground(String... params) {
        Log.i(Constants.LOG_TAG, "in background");
        Uri uri = constructUrl(params);
        Log.i(Constants.LOG_TAG, uri + "");
        String apiResult = Utility.callAPI(uri);
        Log.i(Constants.LOG_TAG, apiResult == null ? "api result is null" : apiResult);
        ReviewsList res = Utility.parseJson(apiResult, ReviewsList.class);
        Log.i(Constants.LOG_TAG, res + "");
        return res;
    }

    private final String BASE_URL = Constants.BASE_MOVIE_URL;
    private final String API_KEY_PARAM = Constants.Params.API_KEY_PARAM;

    private Uri constructUrl(String... params) {
        Log.i(Constants.LOG_TAG, "url params: " + params[0]);
//        String url = BASE_URL;
        String movieId = params[0];
        Uri uri = Uri.parse(BASE_URL).buildUpon().appendPath(movieId).appendPath("reviews").appendQueryParameter(API_KEY_PARAM, Constants.API_KEY).build();
        Log.i(Constants.LOG_TAG, uri + "");
        return uri;
    }
}
