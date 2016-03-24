package com.nanodegree.myproject1.popularmovieapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nanodegree.myproject1.popularmovieapp.dto.MovieDetail;
import com.nanodegree.myproject1.popularmovieapp.dto.Review;
import com.nanodegree.myproject1.popularmovieapp.dto.ReviewsList;
import com.nanodegree.myproject1.popularmovieapp.dto.Trailer;
import com.nanodegree.myproject1.popularmovieapp.dto.TrailersList;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * A placeholder fragment containing a simple view.
 *
 * Detailed movie fragment activity
 */
public class MovieDetailActivityFragment extends Fragment {

    public MovieDetailActivityFragment() {
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_movie_detail_fragment, menu);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private String firstYouTubeLink = null;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.you_tube_link:
                Log.i(Constants.LOG_TAG, "clicked on youtube option");


                Intent i = this.getActivity().getIntent();
                final GridItem gridItem = i.getParcelableExtra(Constants.GRID_ITEM_KEY);
                final String movieId = gridItem.getId() + "";

                FetchTrailersTask trailersTask = new FetchTrailersTask();
                AsyncTask<String, Void, TrailersList> trailersTaskRes = trailersTask.execute(movieId);

                TrailersList trailersList = null;
                try {
                    trailersList = trailersTaskRes.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                List<Trailer> trailers = trailersList.getResults();

                for (Trailer t : trailers) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "https://www.youtube.com/watch?v=" + t.getKey());
                    sendIntent.setType("text/plain");
                    startActivity(Intent.createChooser(sendIntent,"Share using"));
                    break;
                }



        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent i = this.getActivity().getIntent();
        final GridItem gridItem = i.getParcelableExtra(Constants.GRID_ITEM_KEY);

//        Log.i(Constants.LOG_TAG, "grid item: " + gridItem);

        final String movieId = gridItem.getId() + "";

        Cursor c = getActivity().getContentResolver().query(FavoriteMovieContentProvider.Lists.withId(Long.parseLong(movieId)), null, null, null, null);
        boolean movieSaved = c.moveToFirst();

        MovieDetail movieDetail = null;

        if (movieSaved) {
            MovieDetail md = new MovieDetail();
            md.setOverview(c.getString(6));
            md.setId(c.getInt(7));
            md.setTitle(c.getString(1));
            md.setBackdrop_path(c.getString(5));
            md.setRelease_date(c.getString(2));
            md.setRuntime(c.getInt(3));
            md.setVote_average(c.getFloat(4));
            movieDetail = md;
            Log.i(Constants.LOG_TAG, "pulling from movie stored");
        } else {
            FetchMovieTask movieTask = new FetchMovieTask();
            AsyncTask<String, Void, MovieDetail> movieTaskRes = movieTask.execute(movieId);
            try {
                movieDetail = movieTaskRes.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            Log.i(Constants.LOG_TAG, "pulling from movie site");
        }

        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        TextView detailFragmentView = (TextView) rootView.findViewById(R.id.detailTitle);
        detailFragmentView.setText(gridItem.getTitle());

        TextView detailReleaseDateView = (TextView) rootView.findViewById(R.id.detailReleaseDate);
        detailReleaseDateView.setText(gridItem.getReleaseDate() != null ? gridItem.getReleaseDate().split("-")[0] : "N/A");

        if (null != movieDetail) {
            TextView detailRuntimeView = (TextView) rootView.findViewById(R.id.detailRuntime);
            detailRuntimeView.setText(movieDetail.getRuntime() + " min");

            TextView detailVoteAverage = (TextView) rootView.findViewById(R.id.detailVoteAverage);
            detailVoteAverage.setText(movieDetail.getVote_average() + "/10");
        } else {
            // TODO:
        }

        ImageView detailImageView = (ImageView) rootView.findViewById(R.id.detailImage);
        if (null != gridItem.getImageUrl()) {
            Picasso.with(this.getActivity().getApplicationContext())
                    .load(Constants.BASE_IMAGE_URL + gridItem.getImageUrl()).resize(450,700).into(detailImageView);
        } else {
            // https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/300px-No_image_available.svg.png
            Picasso.with(this.getActivity().getApplicationContext()).load(R.drawable.noimage300px).into(detailImageView);
        }

        // TODO: query if this movie is selected already
        Button markAsFavButton = (Button) rootView.findViewById(R.id.markAsFavorite);
        final MovieDetail finalMovieDetail = movieDetail;
        markAsFavButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // insert into DB.  Don't insert duplicates?
                Uri uri = FavoriteMovieContentProvider.Lists.LISTS;
                ContentValues cv = new ContentValues();
                cv.put(FavoriteMoviesListColumns.MOVIE_ID, movieId);
                cv.put(FavoriteMoviesListColumns.RATING, finalMovieDetail.getVote_average());
                cv.put(FavoriteMoviesListColumns.RUN_TIME, finalMovieDetail.getRuntime());
                cv.put(FavoriteMoviesListColumns.RELEASE_DATE, finalMovieDetail.getRelease_date());
                cv.put(FavoriteMoviesListColumns.TITLE, gridItem.getTitle());
                cv.put(FavoriteMoviesListColumns.SYNOPSIS, gridItem.getOverview());
                cv.put(FavoriteMoviesListColumns.IMAGE_URL, gridItem.getImageUrl());

                Cursor c1 = getActivity().getContentResolver().query(FavoriteMovieContentProvider.Lists.withId(Long.parseLong(movieId)), null, null, null, null);
                boolean movieExist = c1.moveToFirst();
                Log.i(Constants.LOG_TAG, "movie exist: " + movieExist);

                if (!movieExist) {
                    getActivity().getContentResolver().insert(uri, cv);
                    Cursor c = getActivity().getContentResolver().query(uri, null, null, null, null);
                    Log.i(Constants.LOG_TAG, "count: " + c.getCount());
                    while (c.moveToNext()) {
                        Log.i(Constants.LOG_TAG, c.getInt(0) + ":" + c.getString(1) + ":" + c.getInt(7));
                    }
                }
            }
        });

        TextView detailSynopsis = (TextView) rootView.findViewById(R.id.detailSynopsis);
        detailSynopsis.setText(gridItem.getOverview());

//        TextView detailReleaseDate = (TextView) rootView.findViewById(R.id.detailReleaseDate);
//        detailReleaseDate.setText(gridItem.getReleaseDate());

//        TextView detailUserRating = (TextView) rootView.findViewById(R.id.detailUserRating);
//        if (null != gridItem.getVoteAverage()) {
//            detailUserRating.setText(gridItem.getVoteAverage() + "");
//        }

        // add youtube list here
        // add reviews list

//        FetchTrailersTask ftt = new FetchTrailersTask();
//        ftt.doInBackground();


//        fmt.doInBackground(gridItem.getId() + "");

        FetchTrailersTask trailersTask = new FetchTrailersTask();
        AsyncTask<String, Void, TrailersList> trailersTaskRes = trailersTask.execute(movieId);

        TrailersList trailersList = null;
        try {
            trailersList = trailersTaskRes.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        List<Trailer> trailers = trailersList.getResults();

        LinearLayout trailerLayout = (LinearLayout) rootView.findViewById(R.id.trailerLayout);

        // TODO: add the play image and the line in between trailers
        // also add link to open trailer
        // create intent
        for (final Trailer trailer:trailers) {
            Log.i(Constants.LOG_TAG, trailer + "");
            LinearLayout tmpLinearLayout = new LinearLayout(getActivity());
            tmpLinearLayout.setOrientation(LinearLayout.VERTICAL);
            tmpLinearLayout.setPadding(0, 0, 0, 30);

            LinearLayout innerLinearLayout = new LinearLayout(getActivity());
            innerLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
            innerLinearLayout.setPadding(0, 0, 0, 30);

            ImageView playButton = new ImageView(getActivity());

            playButton.setImageDrawable(getActivity().getDrawable(R.drawable.play_arrow));
            playButton.setPadding(30, 0, 20, 0);
            innerLinearLayout.addView(playButton);
            TextView trailerNameView = new TextView(getActivity());
            trailerNameView.setText(trailer.getName());
            innerLinearLayout.addView(trailerNameView);
            innerLinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String youTubeUrl = "https://www.youtube.com/watch?v=" + trailer.getKey();
                    Uri u = Uri.parse(youTubeUrl);

                    if (null == firstYouTubeLink) {
                        firstYouTubeLink = youTubeUrl;
                    }

                    Intent i = new Intent(Intent.ACTION_VIEW, u);
                    startActivity(i);
                }
            });
            tmpLinearLayout.addView(innerLinearLayout);

            View lineSeparatorView = new View(getActivity());
            lineSeparatorView.setBackgroundColor(Color.DKGRAY);
            lineSeparatorView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));
            tmpLinearLayout.addView(lineSeparatorView);
            trailerLayout.addView(tmpLinearLayout);
        }

        FetchReviewsTask reviewsTask = new FetchReviewsTask();
        AsyncTask<String, Void, ReviewsList> reviewsTaskRes = reviewsTask.execute(movieId);

        ReviewsList reviewsList = null;
        try {
            reviewsList = reviewsTaskRes.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        List<Review> reviews = reviewsList.getResults();

        LinearLayout reviewLayout = (LinearLayout) rootView.findViewById(R.id.reviewLayout);

        for (Review r: reviews) {
            TextView reviewAuthor = new TextView(getActivity());
            reviewAuthor.setText(r.getAuthor());
            reviewLayout.addView(reviewAuthor);
            TextView reviewContent = new TextView(getActivity());
            reviewContent.setText(r.getContent());
            reviewLayout.addView(reviewContent);

            View lineSeparatorView = new View(getActivity());
            lineSeparatorView.setBackgroundColor(Color.DKGRAY);
            lineSeparatorView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2));
            reviewLayout.addView(lineSeparatorView);
        }

        return rootView;
    }
}
