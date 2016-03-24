package com.nanodegree.myproject1.popularmovieapp.dto;

/**
 * Created by frank on 2/17/16.
 */
public class SpokenLanguage {
    private String iso_639_1;
    private String name;

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SpokenLanguage{" +
                "iso_639_1='" + iso_639_1 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpokenLanguage that = (SpokenLanguage) o;

        if (iso_639_1 != null ? !iso_639_1.equals(that.iso_639_1) : that.iso_639_1 != null)
            return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = iso_639_1 != null ? iso_639_1.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
