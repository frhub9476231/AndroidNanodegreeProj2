package com.nanodegree.myproject1.popularmovieapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by frank on 11/2/15.
 */
public class FetchImageTask extends AsyncTask<String, Void, Bitmap> {


    @Override
    protected Bitmap doInBackground(String... params) {

        if (null != params && params.length == 1) {
            String imageUrl = params[0];
            URL url = null;
            InputStream is = null;
            try {
                Log.i(Constants.LOG_TAG, "here's the img_url: " + imageUrl);
                if (null != imageUrl) {
                    url = new URL(imageUrl);
                    Log.i(Constants.LOG_TAG, url + "");
                    is = url.openConnection().getInputStream();
                    Bitmap bmp = BitmapFactory.decodeStream(is);
                    return bmp;
                }
            } catch (MalformedURLException e) {
                Log.e(Constants.LOG_TAG, e.getMessage(), e);
            } catch (IOException e) {
                Log.e(Constants.LOG_TAG, e.getMessage(), e);
            } finally {
                if (null != is) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        Log.e(Constants.LOG_TAG, e.getMessage(), e);
                    }
                }
            }
        }

        return null;
    }
}
