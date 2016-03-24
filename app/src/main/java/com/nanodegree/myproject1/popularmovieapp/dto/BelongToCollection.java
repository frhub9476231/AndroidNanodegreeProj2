package com.nanodegree.myproject1.popularmovieapp.dto;

/**
 * Created by frank on 2/18/16.
 */
public class BelongToCollection {
    private Integer id;
    private String name;
    private String poster_path;
    private String backdrop_path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    @Override
    public String toString() {
        return "BelongToCollection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BelongToCollection that = (BelongToCollection) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (poster_path != null ? !poster_path.equals(that.poster_path) : that.poster_path != null)
            return false;
        return !(backdrop_path != null ? !backdrop_path.equals(that.backdrop_path) : that.backdrop_path != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (poster_path != null ? poster_path.hashCode() : 0);
        result = 31 * result + (backdrop_path != null ? backdrop_path.hashCode() : 0);
        return result;
    }
}
