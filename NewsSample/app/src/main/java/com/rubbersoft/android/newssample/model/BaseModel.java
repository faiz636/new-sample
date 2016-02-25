package com.rubbersoft.android.newssample.model;

/**
 * Created by Faiz on 11/02/2016.
 */
public class BaseModel {

    int type;
    NewsModel newsModel;
    Category category;

    public BaseModel() {
    }

    BaseModel(int type){
        this.type = type;
    }

    public BaseModel(int type, NewsModel newsModel) {
        this.type = type;
        this.newsModel = newsModel;
    }

    public BaseModel(int type, Category category) {
        this.type = type;
        this.category = category;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public NewsModel getNewsModel() {
        return newsModel;
    }

    public void setNewsModel(NewsModel newsModel) {
        this.newsModel = newsModel;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public static interface Type{
        int TYPE1 = 0;
        int TYPE2 = 1;
        int TYPE3 = 2;
    }
}
