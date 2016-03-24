package com.nanodegree.myproject1.popularmovieapp;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.nanodegree.myproject1.popularmovieapp.dto.MovieDetail;

/**
 * Created by frank on 2/16/16.
 */
public class FetchMovieTask extends AsyncTask<String, Void, MovieDetail> {

    @Override
    protected MovieDetail doInBackground(String... params) {
        Uri url = constructUrl(params);
        String res = Utility.callAPI(url);
        MovieDetail retval = Utility.parseJson(res, MovieDetail.class);
        return retval;
    }

    private final String BASE_URL = "http://api.themoviedb.org/3/movie";
    private final String API_KEY_PARAM = "api_key";

    private Uri constructUrl(String... params) {
        Log.i(Constants.LOG_TAG, "url params: " + params[0]);
        String url = BASE_URL;
        String movieId = params[0];
        Uri uri = Uri.parse(BASE_URL).buildUpon().appendPath(movieId).appendQueryParameter(API_KEY_PARAM, Constants.API_KEY).build();
        Log.i(Constants.LOG_TAG, uri + "");
        return uri;
    }
}
