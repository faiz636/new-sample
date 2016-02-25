package com.rubbersoft.android.newssample.model;

/**
 * Created by Faiz on 12/02/2016.
 */
public class Category {
    String typeText;
    String typeID;

    public Category() {
    }

    public Category(String typeID, String typeText) {
        this.typeID = typeID;
        this.typeText = typeText;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }
}
