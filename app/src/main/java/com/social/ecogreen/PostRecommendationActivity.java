package com.social.ecogreen;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.social.ecogreen.adapter.PostRecommendationAdapter;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRecommendationActivity extends AppCompatActivity {

    private RecyclerView recommendationList;
    private PostRecommendationAdapter adapter;
    private PostRecommendationAPI api;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_recommendation);

        // Initialize UI elements
        recommendationList = findViewById(R.id.recommendationList);
        progressBar = findViewById(R.id.progressBar); // Add a progress bar to your layout


        // Initialize adapter
        List<RecommendationPostItem> postList = new ArrayList<>();
        adapter = new PostRecommendationAdapter(postList);
        recommendationList.setLayoutManager(new LinearLayoutManager(this));
        recommendationList.setAdapter(adapter);

        //Retrofit setup - replace 'YOUR_FLASK_API_BASE_URL'
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://vflask-app-6a5a181334b9.herokuapp.com")  // Replace with your actual API URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(PostRecommendationAPI.class);
        fetchRecommendations();
    }

    private void fetchRecommendations() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String uid = user.getUid();

            progressBar.setVisibility(View.VISIBLE); // Show loading indicator

            Call<RecommendationResponse> call = api.getRecommendations(new PostRecommendationAPI.UserId(uid));
            call.enqueue(new Callback<RecommendationResponse>() { // Updated type
                @Override
                public void onResponse(@NonNull Call<RecommendationResponse> call, @NonNull Response<RecommendationResponse> response) {

                    progressBar.setVisibility(View.GONE);

                    if (response.isSuccessful()) {
                        RecommendationResponse recommendationResponse = response.body();
                        if (recommendationResponse != null) {
                            List<RecommendationPostItem> recommendations = recommendationResponse.getRecommendations();

                            if (recommendations != null && !recommendations.isEmpty()) {
                                adapter.updatePostList(recommendations);
                                adapter.notifyDataSetChanged();
                            } else {
                                Toast.makeText(PostRecommendationActivity.this, "No recommendations found.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.e("API_ERROR", "Empty response body");
                            Toast.makeText(PostRecommendationActivity.this, "Failed to fetch recommendations", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Handle error response
                        Log.e("API_ERROR", "Response not successful: " + response.code());
                        Toast.makeText(PostRecommendationActivity.this, "Failed to fetch recommendations", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<RecommendationResponse> call, @NonNull Throwable t) {  // Changed parameter type
                    progressBar.setVisibility(View.GONE);
                    // Optionally, handle network errors
                    Log.e("API_ERROR", "Network failure: " + t.getMessage());
                    Toast.makeText(PostRecommendationActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            // Handle the case where there's no logged-in user
            Toast.makeText(this, "User not logged in.", Toast.LENGTH_SHORT).show();
        }
    }
}
