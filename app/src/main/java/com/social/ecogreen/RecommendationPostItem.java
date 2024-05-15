package com.social.ecogreen;

import com.google.gson.annotations.SerializedName;

public class RecommendationPostItem {
    @SerializedName("post_id")
    private String postId;

    @SerializedName("seller")
    private String seller;

    @SerializedName("spi_type")
    private String spi_type;

    @SerializedName("location")
    private String location;

    @SerializedName("quantity")
    private double quantity;

    @SerializedName("price")
    private double price;

    @SerializedName("industry")
    private String industry;

    // Constructor
    public RecommendationPostItem(String postId, String spi_type, String location, double quantity, double price, String industry) {
        this.postId = postId;
        this.seller = seller;
        this.spi_type = spi_type;
        this.location = location;
        this.quantity = quantity;
        this.price = price;
        this.industry = industry;
    }

    // Getters
    public String getPostId() {
        return postId;
    }

    public String getSeller() { return seller; }

    public String getSpi_type() {
        return spi_type;
    }

    public String getLocation() {
        return location;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getIndustry() {
        return industry;
    }

    // Setters
    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setSeller(String seller) { this.seller = seller; }

    public void setSpi_type(String spi_type) {
        this.spi_type = spi_type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }
}
