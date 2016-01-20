package com.nanodegree.myproject1.popularmovieapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.AdapterView;
import android.widget.GridView;

import com.nanodegree.myproject1.popularmovieapp.dto.Movie;
import com.nanodegree.myproject1.popularmovieapp.dto.MoviesList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * A placeholder fragment containing a simple view.
 */
public class MovieGridActivityFragment extends Fragment implements AdapterView.OnItemClickListener {

    private CustomGridViewAdapter customGridViewAdapter;

    public MovieGridActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_movie_grid_fragment, menu);
    }

    private static String sortBy = "popularity.desc";

    public static String getSortBy() {
        return MovieGridActivityFragment.sortBy;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        customGridViewAdapter.clear();
        item.setChecked(true);
        switch (id) {
            case R.id.sort_by_highest_rated_asc:
                sortBy = "vote_average.asc";
                customGridViewAdapter.addAll(createGridListHelper(fetchMovieHelper(sortBy)));
                break;
            case R.id.sort_by_highest_rated_desc:
                sortBy = "vote_average.desc";
                customGridViewAdapter.addAll(createGridListHelper(fetchMovieHelper(sortBy)));
                break;
            case R.id.sort_by_popular_asc:
                sortBy = "popularity.asc";
                customGridViewAdapter.addAll(createGridListHelper(fetchMovieHelper(sortBy)));
                break;
            case R.id.sort_by_popular_desc:
                sortBy = "popularity.desc";
                customGridViewAdapter.addAll(createGridListHelper(fetchMovieHelper(sortBy)));
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    private List<Movie> fetchMovieHelper(String sortBy) {
        Log.i(Constants.LOG_TAG, "calling fetch movie helper: " + sortBy);

        MoviesList r = null;

        if (isOnline(getActivity())) {
            FetchMoviesTask ft = new FetchMoviesTask();
            AsyncTask<String, Void, MoviesList> res = ft.execute(sortBy);
            try {
                r = res.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        List<Movie> movies = new ArrayList<Movie>();
        if (null != r) {
            movies = r.getResults();
        }
        return movies;
    }

    private List<GridItem> createGridListHelper(List<Movie> movies) {
        List<GridItem> gt = new ArrayList<GridItem>();

        for (Movie m: movies) {
            GridItem gi = new GridItem(m.getTitle(), m.getBackdrop_path(), m.getOverview(), m.getVote_average(), m.getRelease_date());
            gt.add(gi);
        }
        return gt;
    }

    private View refreshGridView(LayoutInflater inflater, ViewGroup container, String sortBy) {
        List<Movie> moviesList = fetchMovieHelper(sortBy);
        List<GridItem> moviesGridList = createGridListHelper(moviesList);

        View rootView = inflater.inflate(R.layout.fragment_movie_grid, container);
        GridView gridView = (GridView) rootView.findViewById(R.id.gridView);
        Context context = getActivity().getApplicationContext();
        customGridViewAdapter = new CustomGridViewAdapter(context, R.layout.fragment_movie_grid_single, moviesGridList);
        gridView.setAdapter(customGridViewAdapter);
        gridView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        return rootView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return refreshGridView(inflater, container, sortBy);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        GridItem itemAtPosition = (GridItem) parent.getItemAtPosition(position);
        Intent detailIntent = new Intent(getActivity().getApplicationContext(), MovieDetailActivity.class);
        detailIntent.putExtra(Constants.GRID_ITEM_KEY, itemAtPosition);
        startActivity(detailIntent);
    }
}
