package com.rubbersoft.android.newssample.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Faiz on 11/02/2016.
 */
public class NewsModel implements Parcelable{
    private String title;
    private String l_desc;
    private String s_desc;
    private String imgUrl;
    private String timestamp;
    private String author;
    private int id;
    private Category category;

    public NewsModel() {
    }

    public NewsModel(String title, String desc, String imgUrl, String time, Category category) {
        this.title = title;
        this.s_desc = desc;
        this.imgUrl = imgUrl;
        this.timestamp = time;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getS_desc() {
        return s_desc;
    }

    public void setS_desc(String s_desc) {
        this.s_desc = s_desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getL_desc() {
        return l_desc;
    }

    public void setL_desc(String l_desc) {
        this.l_desc = l_desc;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     *
     * @return a bitmask indicating the set of special object types marshalled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(s_desc);
        dest.writeString(l_desc);
        dest.writeString(imgUrl);
        dest.writeString(timestamp);
        dest.writeString(author);
        dest.writeParcelable(category,flags);
    }

    public static final Parcelable.Creator<NewsModel> CREATOR
            = new Parcelable.Creator<NewsModel>() {
        public NewsModel createFromParcel(Parcel in) {
            return new NewsModel(in);
        }

        public NewsModel[] newArray(int size) {
            return new NewsModel[size];
        }
    };

    private NewsModel(Parcel in) {
         id = in.readInt();
        title = in.readString();
        s_desc = in.readString();
        l_desc = in.readString();
        imgUrl = in.readString();
        timestamp = in.readString();
        author = in.readString();
        category = in.readParcelable(null);

    }
}
