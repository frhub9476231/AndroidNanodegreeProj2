package com.nanodegree.myproject1.popularmovieapp.dto;

/**
 * Created by frank on 2/17/16.
 */
public class ProductionCountry {
    private String iso_3166_1;
    private String name;

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public void setIso_3166_1(String iso_3166_1) {
        this.iso_3166_1 = iso_3166_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductionCountry{" +
                "iso_3166_1='" + iso_3166_1 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductionCountry that = (ProductionCountry) o;

        if (iso_3166_1 != null ? !iso_3166_1.equals(that.iso_3166_1) : that.iso_3166_1 != null)
            return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = iso_3166_1 != null ? iso_3166_1.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
