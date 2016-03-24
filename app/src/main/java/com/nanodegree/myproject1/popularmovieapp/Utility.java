package com.nanodegree.myproject1.popularmovieapp;

import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by frank on 2/12/16.
 */
public class Utility {

    public static <T> T parseJson(String json, Class<T> clazz) {
        Gson gson = new Gson();
        T jsonObj = gson.fromJson(json, clazz);
        return jsonObj;
    }

    public static String callAPI(Uri apiUri) {
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

}
