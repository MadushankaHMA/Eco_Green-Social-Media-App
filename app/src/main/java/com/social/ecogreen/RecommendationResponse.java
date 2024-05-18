package com.social.ecogreen;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RecommendationResponse {
    @SerializedName("recommendations")
    private List<RecommendationPostItem> recommendations;

    // Getter for the recommendations list
    public List<RecommendationPostItem> getRecommendations() {
        return recommendations;
    }
}