package com.nanodegree.myproject1.popularmovieapp;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.nanodegree.myproject1.popularmovieapp.dto.MoviesList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by frank on 10/20/15.
 */
public class FetchMoviesTask extends AsyncTask<String, Void, MoviesList> {

    @Override
    protected MoviesList doInBackground(String... params) {
        Log.i(Constants.LOG_TAG, "in background");
        Uri uri = constructUrl(params);
        Log.i(Constants.LOG_TAG, uri + "");
        String apiResult = callAPI(uri);
        Log.i(Constants.LOG_TAG, apiResult);
        MoviesList res = parseJson(apiResult);
        Log.i(Constants.LOG_TAG, res + "");
        return res;
    }

    private final String BASE_URL = "http://api.themoviedb.org/3/discover/movie";
    private final String API_KEY_PARAM = "api_key";
    private final String SORT_BY_PARAM = "sort_by";
    private final String SORT_BY = "popularity.desc";

    private Uri constructUrl(String... params) {
        Log.i(Constants.LOG_TAG, "url params: " + params[0]);
        Uri uri = Uri.parse(BASE_URL).buildUpon().appendQueryParameter(SORT_BY_PARAM, params[0]).appendQueryParameter(API_KEY_PARAM, Constants.API_KEY).build();
        return uri;
    }

    private String callAPI(Uri apiUri) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(apiUri.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                Log.i(Constants.LOG_TAG, line);
                sb.append(line);
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            Log.e(Constants.LOG_TAG, e.getMessage(), e);
        } catch (ProtocolException e) {
            Log.e(Constants.LOG_TAG, e.getMessage(), e);
        } catch (IOException e) {
            Log.e(Constants.LOG_TAG, e.getMessage(), e);
        } finally {
            if (null != urlConnection) {
                urlConnection.disconnect();
            }
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e(Constants.LOG_TAG, e.getMessage(), e);
                }
            }
        }
        return null;
    }

    private MoviesList parseJson(String json) {
        Gson gson = new Gson();
        MoviesList movies = gson.fromJson(json, MoviesList.class);
        return movies;
    }
}
