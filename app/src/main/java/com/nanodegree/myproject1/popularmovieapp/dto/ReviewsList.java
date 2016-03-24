package com.nanodegree.myproject1.popularmovieapp.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 2/20/16.
 */
public class ReviewsList {
    private Integer id;
    private Integer page;
    private List<Review> results = new ArrayList<Review>();
    private Integer total_pages;
    private Integer total_results;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Review> getResults() {
        return results;
    }

    public void setResults(List<Review> results) {
        this.results = results;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public Integer getTotal_results() {
        return total_results;
    }

    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }

    @Override
    public String toString() {
        return "ReviewsList{" +
                "id=" + id +
                ", page=" + page +
                ", results=" + results +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReviewsList that = (ReviewsList) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (page != null ? !page.equals(that.page) : that.page != null) return false;
        if (results != null ? !results.equals(that.results) : that.results != null) return false;
        if (total_pages != null ? !total_pages.equals(that.total_pages) : that.total_pages != null)
            return false;
        return !(total_results != null ? !total_results.equals(that.total_results) : that.total_results != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (page != null ? page.hashCode() : 0);
        result = 31 * result + (results != null ? results.hashCode() : 0);
        result = 31 * result + (total_pages != null ? total_pages.hashCode() : 0);
        result = 31 * result + (total_results != null ? total_results.hashCode() : 0);
        return result;
    }
}
