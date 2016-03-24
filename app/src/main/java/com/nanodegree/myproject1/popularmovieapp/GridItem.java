package com.nanodegree.myproject1.popularmovieapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by frank on 10/27/15.
 */
public class GridItem implements Parcelable {
    private Integer id;
    private String title;
    private String imageUrl;
    private String overview;
    private Float voteAverage;
    private String releaseDate;

    public GridItem(Integer id, String title, String imageUrl, String overview, Float voteAverage, String releaseDate) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.overview = overview;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
    }

    protected GridItem(Parcel in) {
        id = in.readInt();
        title = in.readString();
        imageUrl = in.readString();
        overview = in.readString();
        voteAverage = in.readByte() == 0x00 ? null : in.readFloat();
        releaseDate = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(imageUrl);
        dest.writeString(overview);
        if (voteAverage == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeFloat(voteAverage);
        }
        dest.writeString(releaseDate);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<GridItem> CREATOR = new Parcelable.Creator<GridItem>() {
        @Override
        public GridItem createFromParcel(Parcel in) {
            return new GridItem(in);
        }

        @Override
        public GridItem[] newArray(int size) {
            return new GridItem[size];
        }
    };


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "GridItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", overview='" + overview + '\'' +
                ", voteAverage=" + voteAverage +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
