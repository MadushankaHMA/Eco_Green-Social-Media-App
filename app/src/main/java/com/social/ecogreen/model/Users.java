package com.social.ecogreen.model;

import java.util.List;
public class Users {

    private String email, name, profileImage, uid, status, search, location, spi_type;

    private List<String> followers;
    private List<String> following;

    private boolean online;

    public Users() {
    }

    public Users(String email, String name, String profileImage, String uid, String status, String spi_type, String search, List<String> followers, List<String> following, boolean online, String location) {
        this.email = email;
        this.name = name;
        this.profileImage = profileImage;
        this.uid = uid;
        this.status = status;
        this.spi_type = spi_type;
        this.search = search;
        this.followers = followers;
        this.following = following;
        this.online = online;
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpi_type() { return spi_type; }

    public void setSpi_type(String spi_type) { this.spi_type = spi_type; }

    public String getSearch() { return search; }

    public void setSearch(String search) { this.search = search; }

    public List<String> getFollowers() { return followers; }

    public void setFollowers(List<String> followers) { this.followers = followers; }

    public List<String> getFollowing() { return following; }

    public void setFollowing(List<String> following) { this.following = following; }

    public boolean isOnline() { return online; }

    public void setOnline(boolean online) { this.online = online; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }
}
