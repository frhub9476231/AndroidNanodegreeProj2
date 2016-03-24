package com.nanodegree.myproject1.popularmovieapp;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MovieGridActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_grid);

        if (null == savedInstanceState) {
            Log.i(Constants.LOG_TAG, "save instance null");
        }

        String res = (String) findViewById(R.id.fragment).getTag();
        Log.i(Constants.LOG_TAG, "frag2: " + res);

        int layoutSize = getResources().getConfiguration().screenLayout;
        layoutSize = layoutSize & Configuration.SCREENLAYOUT_SIZE_MASK;

        Log.i(Constants.LOG_TAG, "layoutsize: " + layoutSize);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_grid, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
