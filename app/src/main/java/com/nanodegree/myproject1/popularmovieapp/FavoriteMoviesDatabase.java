package com.nanodegree.myproject1.popularmovieapp;

import net.simonvt.schematic.annotation.Database;
import net.simonvt.schematic.annotation.Table;

/**
 * Created by frank on 3/3/16.
 */
@Database(version = FavoriteMoviesDatabase.VERSION,
packageName = "com.nanodegree.myproject1.popularmovieapp.provider")
public final class FavoriteMoviesDatabase {

    public static final int VERSION = 1;

    @Table(FavoriteMoviesListColumns.class) public static final String LISTS = "lists";
}
