package com.nanodegree.myproject1.popularmovieapp;

/**
 * Created by frank on 11/15/15.
 */
public class Constants {
    public static final String LOG_TAG = "movieapp";
    public static final String GRID_ITEM_KEY = "griditem";
    public static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w500";
    // TODO: must replace API KEY with your own!
    public static final String API_KEY = "REPLACE";

    public static final String BASE_API_URL = "http://api.themoviedb.org/3";
    public static final String BASE_MOVIE_URL = BASE_API_URL + "/movie";

    public static class Params {
        public static final String API_KEY_PARAM = "api_key";
        public static final String SORT_BY_PARAM = "sort_by";
    }
}
