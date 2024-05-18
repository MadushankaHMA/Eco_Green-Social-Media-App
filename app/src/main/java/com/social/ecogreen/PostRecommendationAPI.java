package com.social.ecogreen;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
public interface PostRecommendationAPI
{
    @POST("/get_recommendations")
    Call<RecommendationResponse> getRecommendations(@Body UserId userId);  // Updated return type

    // A simple class to represent the UID to send to the server
    class UserId {
        String uid;

        public UserId(String uid) {
            this.uid = uid;
        }

    }}
