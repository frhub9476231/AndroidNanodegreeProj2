package com.nanodegree.myproject1.popularmovieapp.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 2/12/16.
 */
public class TrailersList {
    private List<Trailer> results = new ArrayList<Trailer>();

    public List<Trailer> getResults() {
        return results;
    }

    public void setResults(List<Trailer> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "TrailersList{" +
                "results=" + results +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrailersList that = (TrailersList) o;

        return results.equals(that.results);

    }

    @Override
    public int hashCode() {
        return results.hashCode();
    }
}
