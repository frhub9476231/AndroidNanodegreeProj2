package com.nanodegree.myproject1.popularmovieapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;


public class MovieDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        int layoutSize = getResources().getConfiguration().screenLayout;
        layoutSize = layoutSize & Configuration.SCREENLAYOUT_SIZE_MASK;

        Log.i(Constants.LOG_TAG, "layout size in detail: " + layoutSize);

        if (2 == layoutSize) {
            Log.i(Constants.LOG_TAG, "in regular mode detail");
            setContentView(R.layout.activity_movie_detail);
        } else {
            Log.i(Constants.LOG_TAG, "in 2pane mode detail");
            setContentView(R.layout.activity_movie_grid);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.dynamic_frag1, new MovieDetailActivityFragment())
                    .commit();

        }

//        if (null == savedInstanceState) {
//            Log.i(Constants.LOG_TAG, "in 2pane mode detail");
//            setContentView(R.layout.activity_movie_grid);
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.dynamic_frag1, new MovieDetailActivityFragment())
//                    .commit();
//        } else {
//            Log.i(Constants.LOG_TAG, "in regular mode detail");
//            setContentView(R.layout.activity_movie_detail);
//        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_movie_detail, menu);

        return true;
    }

}
