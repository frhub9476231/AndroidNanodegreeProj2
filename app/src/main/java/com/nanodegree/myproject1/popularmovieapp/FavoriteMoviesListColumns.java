package com.nanodegree.myproject1.popularmovieapp;

import net.simonvt.schematic.annotation.AutoIncrement;
import net.simonvt.schematic.annotation.DataType;
import net.simonvt.schematic.annotation.DataType.Type;
import net.simonvt.schematic.annotation.NotNull;
import net.simonvt.schematic.annotation.PrimaryKey;
import net.simonvt.schematic.annotation.Unique;

/**
 * Created by frank on 3/3/16.
 */
public interface FavoriteMoviesListColumns {
    @DataType(Type.INTEGER) @PrimaryKey
    @AutoIncrement
    String _ID = "_id";

    @DataType(Type.TEXT) @NotNull
    String TITLE = "title";

    @DataType(Type.INTEGER)
    String RELEASE_DATE = "releasedate";

    @DataType(Type.INTEGER)
    String RUN_TIME = "runtime";

    @DataType(Type.REAL)
    String RATING = "rating";

    @DataType(Type.TEXT)
    String IMAGE_URL = "imageurl";

    @DataType(Type.TEXT)
    String SYNOPSIS = "synopsis";

    @DataType(Type.INTEGER) @Unique
    String MOVIE_ID = "movieid";

}
