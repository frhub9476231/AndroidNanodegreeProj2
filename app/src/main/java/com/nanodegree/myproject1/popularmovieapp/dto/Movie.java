package com.nanodegree.myproject1.popularmovieapp.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 10/21/15.
 */
public class Movie {
    private Boolean adult;
    private String backdrop_path;
    private List<Integer> genre_ids = new ArrayList<Integer>();
    private Integer id;
    private String original_language;
    private String original_title;
    private String overview;
    private String release_date;
    private String poster_path;
    private Float popularity;
    private String title;
    private Boolean video;
    private Float vote_average;
    private Integer vote_count;

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Float getVote_average() {
        return vote_average;
    }

    public void setVote_average(Float vote_average) {
        this.vote_average = vote_average;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (adult != null ? !adult.equals(movie.adult) : movie.adult != null) return false;
        if (backdrop_path != null ? !backdrop_path.equals(movie.backdrop_path) : movie.backdrop_path != null)
            return false;
        if (genre_ids != null ? !genre_ids.equals(movie.genre_ids) : movie.genre_ids != null)
            return false;
        if (id != null ? !id.equals(movie.id) : movie.id != null) return false;
        if (original_language != null ? !original_language.equals(movie.original_language) : movie.original_language != null)
            return false;
        if (original_title != null ? !original_title.equals(movie.original_title) : movie.original_title != null)
            return false;
        if (overview != null ? !overview.equals(movie.overview) : movie.overview != null)
            return false;
        if (release_date != null ? !release_date.equals(movie.release_date) : movie.release_date != null)
            return false;
        if (poster_path != null ? !poster_path.equals(movie.poster_path) : movie.poster_path != null)
            return false;
        if (popularity != null ? !popularity.equals(movie.popularity) : movie.popularity != null)
            return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (video != null ? !video.equals(movie.video) : movie.video != null) return false;
        if (vote_average != null ? !vote_average.equals(movie.vote_average) : movie.vote_average != null)
            return false;
        return !(vote_count != null ? !vote_count.equals(movie.vote_count) : movie.vote_count != null);

    }

    @Override
    public int hashCode() {
        int result = adult != null ? adult.hashCode() : 0;
        result = 31 * result + (backdrop_path != null ? backdrop_path.hashCode() : 0);
        result = 31 * result + (genre_ids != null ? genre_ids.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (original_language != null ? original_language.hashCode() : 0);
        result = 31 * result + (original_title != null ? original_title.hashCode() : 0);
        result = 31 * result + (overview != null ? overview.hashCode() : 0);
        result = 31 * result + (release_date != null ? release_date.hashCode() : 0);
        result = 31 * result + (poster_path != null ? poster_path.hashCode() : 0);
        result = 31 * result + (popularity != null ? popularity.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (video != null ? video.hashCode() : 0);
        result = 31 * result + (vote_average != null ? vote_average.hashCode() : 0);
        result = 31 * result + (vote_count != null ? vote_count.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "adult=" + adult +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", genre_ids=" + genre_ids +
                ", id=" + id +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", popularity=" + popularity +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }
}
