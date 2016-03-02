package com.rubbersoft.android.newssample.model;

/**
 * Created by Faiz on 11/02/2016.
 */
public class NewsModel {
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
}
