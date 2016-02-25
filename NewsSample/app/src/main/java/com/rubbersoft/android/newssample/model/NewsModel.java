package com.rubbersoft.android.newssample.model;

/**
 * Created by Faiz on 11/02/2016.
 */
public class NewsModel {
    private String title;
    private String desc;
    private String imgUrl;
    private String time;
    private Category category;

    public NewsModel() {
    }

    public NewsModel(String title, String desc, String imgUrl, String time, Category category) {
        this.title = title;
        this.desc = desc;
        this.imgUrl = imgUrl;
        this.time = time;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
