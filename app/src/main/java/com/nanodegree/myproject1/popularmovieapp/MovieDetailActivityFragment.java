package com.nanodegree.myproject1.popularmovieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieDetailActivityFragment extends Fragment {

    public MovieDetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent i = this.getActivity().getIntent();
        GridItem gridItem = i.getParcelableExtra(Constants.GRID_ITEM_KEY);

//        Log.i(Constants.LOG_TAG, "grid item: " + gridItem);

        View rootView = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        TextView detailFragmentView = (TextView) rootView.findViewById(R.id.detailTitle);
        detailFragmentView.setText(gridItem.getTitle());

        ImageView detailImageView = (ImageView) rootView.findViewById(R.id.detailImage);
        if (null != gridItem.getImageUrl()) {
            Picasso.with(this.getActivity().getApplicationContext()).load(Constants.BASE_IMAGE_URL + gridItem.getImageUrl()).into(detailImageView);
        } else {
            // https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/300px-No_image_available.svg.png
            Picasso.with(this.getActivity().getApplicationContext()).load(R.drawable.noimage300px).into(detailImageView);
        }


        TextView detailSynopsis = (TextView) rootView.findViewById(R.id.detailSynopsis);
        detailSynopsis.setText(gridItem.getOverview());

        TextView detailReleaseDate = (TextView) rootView.findViewById(R.id.detailReleaseDate);
        detailReleaseDate.setText(gridItem.getReleaseDate());

        TextView detailUserRating = (TextView) rootView.findViewById(R.id.detailUserRating);
        if (null != gridItem.getVoteAverage()) {
            detailUserRating.setText(gridItem.getVoteAverage() + "");
        }


        return rootView;
    }
}
