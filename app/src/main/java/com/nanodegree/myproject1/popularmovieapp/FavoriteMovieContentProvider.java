package com.nanodegree.myproject1.popularmovieapp;

import android.content.ContentValues;
import android.net.Uri;
import android.util.Log;

import net.simonvt.schematic.annotation.ContentProvider;
import net.simonvt.schematic.annotation.ContentUri;
import net.simonvt.schematic.annotation.InexactContentUri;
import net.simonvt.schematic.annotation.NotifyInsert;
import net.simonvt.schematic.annotation.TableEndpoint;

/**
 * Created by frank on 3/4/16.
 */
@ContentProvider(authority = FavoriteMovieContentProvider.AUTHORITY,
        database = FavoriteMoviesDatabase.class,
        packageName = "com.nanodegree.myproject1.popularmovieapp.provider")
public final class FavoriteMovieContentProvider {
    public static final String AUTHORITY = "com.nanodegree.myproject1.popularmovieapp.FavoriteMovieContentProvider";

    private static Uri buildUri(String... paths) {
        Uri.Builder builder = Uri.parse("content://" + AUTHORITY).buildUpon();
        for (String path : paths) {
            builder.appendPath(path);
        }
        return builder.build();
    }

    @TableEndpoint(table = FavoriteMoviesDatabase.LISTS) public static class Lists {
        @ContentUri(path = "lists", type = "vnd.android.cursor.dir/list", defaultSort = FavoriteMoviesListColumns.TITLE + " ASC")
        public static final Uri LISTS = Uri.parse("content://" + AUTHORITY + "/lists");

        @InexactContentUri(
                path = "lists" + "/#",
                name = "LIST_ID",
                type = "vnd.android.cursor.item/list",
                whereColumn = FavoriteMoviesListColumns.MOVIE_ID,
                pathSegment = 1)
        public static Uri withId(long id) {
            return buildUri("lists", String.valueOf(id));
        }

        @NotifyInsert(paths = "lists")
        public static Uri[] onInsert(ContentValues values) {
            Log.i(Constants.LOG_TAG, "insert values:" + values);
            Log.i(Constants.LOG_TAG, "" + LISTS);
            return new Uri[] {};
        }
    }
}


