package com.example.apinya.apiexcercise;

import com.google.gson.annotations.SerializedName;

public class Pages {

    @SerializedName("totoalItems")
    private String totalItems;
    @SerializedName("selfLink")
    private String selfLink;

    public String getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }
}
