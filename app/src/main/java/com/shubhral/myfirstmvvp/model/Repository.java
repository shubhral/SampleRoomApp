package com.shubhral.myfirstmvvp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Shubhral on 3/14/2018.
 */

public class Repository implements Parcelable {

    private String name;
    private String description;
    private String url;
    private long id;
    private int forks;
    private int watchers;
    @SerializedName("stargazers_count")
    private int stars;

    protected Repository(Parcel in) {
        name = in.readString();
        description = in.readString();
        url = in.readString();
        id = in.readLong();
        forks = in.readInt();
        watchers = in.readInt();
        stars = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(url);
        dest.writeLong(id);
        dest.writeInt(forks);
        dest.writeInt(watchers);
        dest.writeInt(stars);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel in) {
            return new Repository(in);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public long getId() {
        return id;
    }

    public int getForks() {
        return forks;
    }

    public int getWatchers() {
        return watchers;
    }

    public int getStars() {
        return stars;
    }
}
