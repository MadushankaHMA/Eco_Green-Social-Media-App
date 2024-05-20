package com.social.ecogreen.model;

import java.util.List;

public class UserCommunities {
    public String userId;
    private String username;
    private String profileUrl;
    public List<String> recentCommunities;

    // Constructor
    public UserCommunities(String userId, String username, String profileUrl, List<String> recentCommunities) {
        this.userId = userId;
        this.username = username;
        this.profileUrl = profileUrl;
        this.recentCommunities = recentCommunities;
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public List<String> getRecentCommunities() {
        return recentCommunities;
    }

    // Setters (optional, but good practice)
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public void setRecentCommunities(List<String> recentCommunities) {
        this.recentCommunities = recentCommunities;
    }
}
