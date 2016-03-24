package com.nanodegree.myproject1.popularmovieapp.dto;

/**
 * Created by frank on 2/12/16.
 */
public class Trailer {
    private String id;
    private String iso_639_1;
    private String key;
    private String name;
    private String site;
    private Integer size;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "id='" + id + '\'' +
                ", iso_639_1='" + iso_639_1 + '\'' +
                ", key='" + key + '\'' +
                ", name='" + name + '\'' +
                ", site='" + site + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trailer trailer = (Trailer) o;

        if (!id.equals(trailer.id)) return false;
        if (!iso_639_1.equals(trailer.iso_639_1)) return false;
        if (!key.equals(trailer.key)) return false;
        if (!name.equals(trailer.name)) return false;
        if (!site.equals(trailer.site)) return false;
        if (!size.equals(trailer.size)) return false;
        return type.equals(trailer.type);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + iso_639_1.hashCode();
        result = 31 * result + key.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + site.hashCode();
        result = 31 * result + size.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
