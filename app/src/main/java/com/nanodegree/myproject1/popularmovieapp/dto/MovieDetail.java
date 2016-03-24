package com.nanodegree.myproject1.popularmovieapp.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 2/16/16.
 */
public class MovieDetail {
    private Boolean adult;
    private String backdrop_path;
    private BelongToCollection belongs_to_collection;
    private Integer budget;
    private List<Genre> genres = new ArrayList<Genre>();
    private String homepage;
    private Integer id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private Float popularity;
    private String poster_path;
    private List<ProductionCompany> production_companies = new ArrayList<ProductionCompany>();
    private List<ProductionCountry> production_countries = new ArrayList<ProductionCountry>();
    private String release_date;
    private Integer revenue;
    private Integer runtime;
    private List<SpokenLanguage> spoken_languages = new ArrayList<SpokenLanguage>();
    private String status;
    private String tagline;
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

    public BelongToCollection getBelongs_to_collection() {
        return belongs_to_collection;
    }

    public void setBelongs_to_collection(BelongToCollection belongs_to_collection) {
        this.belongs_to_collection = belongs_to_collection;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
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

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public List<ProductionCompany> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<ProductionCompany> production_companies) {
        this.production_companies = production_companies;
    }

    public List<ProductionCountry> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<ProductionCountry> production_countries) {
        this.production_countries = production_countries;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<SpokenLanguage> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<SpokenLanguage> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
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
    public String toString() {
        return "MovieDetail{" +
                "adult=" + adult +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", belongs_to_collection='" + belongs_to_collection + '\'' +
                ", budget=" + budget +
                ", genres=" + genres +
                ", homepage='" + homepage + '\'' +
                ", id=" + id +
                ", imdb_id='" + imdb_id + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", production_companies=" + production_companies +
                ", production_countries=" + production_countries +
                ", release_date='" + release_date + '\'' +
                ", revenue=" + revenue +
                ", runtime=" + runtime +
                ", spoken_languages=" + spoken_languages +
                ", status='" + status + '\'' +
                ", tagline='" + tagline + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDetail that = (MovieDetail) o;

        if (adult != null ? !adult.equals(that.adult) : that.adult != null) return false;
        if (backdrop_path != null ? !backdrop_path.equals(that.backdrop_path) : that.backdrop_path != null)
            return false;
        if (belongs_to_collection != null ? !belongs_to_collection.equals(that.belongs_to_collection) : that.belongs_to_collection != null)
            return false;
        if (budget != null ? !budget.equals(that.budget) : that.budget != null) return false;
        if (genres != null ? !genres.equals(that.genres) : that.genres != null) return false;
        if (homepage != null ? !homepage.equals(that.homepage) : that.homepage != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (imdb_id != null ? !imdb_id.equals(that.imdb_id) : that.imdb_id != null) return false;
        if (original_language != null ? !original_language.equals(that.original_language) : that.original_language != null)
            return false;
        if (original_title != null ? !original_title.equals(that.original_title) : that.original_title != null)
            return false;
        if (overview != null ? !overview.equals(that.overview) : that.overview != null)
            return false;
        if (popularity != null ? !popularity.equals(that.popularity) : that.popularity != null)
            return false;
        if (poster_path != null ? !poster_path.equals(that.poster_path) : that.poster_path != null)
            return false;
        if (production_companies != null ? !production_companies.equals(that.production_companies) : that.production_companies != null)
            return false;
        if (production_countries != null ? !production_countries.equals(that.production_countries) : that.production_countries != null)
            return false;
        if (release_date != null ? !release_date.equals(that.release_date) : that.release_date != null)
            return false;
        if (revenue != null ? !revenue.equals(that.revenue) : that.revenue != null) return false;
        if (runtime != null ? !runtime.equals(that.runtime) : that.runtime != null) return false;
        if (spoken_languages != null ? !spoken_languages.equals(that.spoken_languages) : that.spoken_languages != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (tagline != null ? !tagline.equals(that.tagline) : that.tagline != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (video != null ? !video.equals(that.video) : that.video != null) return false;
        if (vote_average != null ? !vote_average.equals(that.vote_average) : that.vote_average != null)
            return false;
        return !(vote_count != null ? !vote_count.equals(that.vote_count) : that.vote_count != null);

    }

    @Override
    public int hashCode() {
        int result = adult != null ? adult.hashCode() : 0;
        result = 31 * result + (backdrop_path != null ? backdrop_path.hashCode() : 0);
        result = 31 * result + (belongs_to_collection != null ? belongs_to_collection.hashCode() : 0);
        result = 31 * result + (budget != null ? budget.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (homepage != null ? homepage.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (imdb_id != null ? imdb_id.hashCode() : 0);
        result = 31 * result + (original_language != null ? original_language.hashCode() : 0);
        result = 31 * result + (original_title != null ? original_title.hashCode() : 0);
        result = 31 * result + (overview != null ? overview.hashCode() : 0);
        result = 31 * result + (popularity != null ? popularity.hashCode() : 0);
        result = 31 * result + (poster_path != null ? poster_path.hashCode() : 0);
        result = 31 * result + (production_companies != null ? production_companies.hashCode() : 0);
        result = 31 * result + (production_countries != null ? production_countries.hashCode() : 0);
        result = 31 * result + (release_date != null ? release_date.hashCode() : 0);
        result = 31 * result + (revenue != null ? revenue.hashCode() : 0);
        result = 31 * result + (runtime != null ? runtime.hashCode() : 0);
        result = 31 * result + (spoken_languages != null ? spoken_languages.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (tagline != null ? tagline.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (video != null ? video.hashCode() : 0);
        result = 31 * result + (vote_average != null ? vote_average.hashCode() : 0);
        result = 31 * result + (vote_count != null ? vote_count.hashCode() : 0);
        return result;
    }
}
