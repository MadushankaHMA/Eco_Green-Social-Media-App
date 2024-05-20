package com.social.ecogreen;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.social.ecogreen.adapter.FriendsAdapter;
import com.social.ecogreen.fragments.Profile;
import com.social.ecogreen.model.UserCommunities;

import java.util.List;

public class FriendsActivity extends AppCompatActivity implements Profile.OnLogoutListener{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Fetch current user's ID from Firebase Auth
        String currentUserId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // Get suggested friends (asynchronous)
        FriendSuggestionHelper.suggestFriends(currentUserId, new FriendSuggestionHelper.Callback<List<UserCommunities>>() {
            @Override
            public void onSuccess(List<UserCommunities> suggestedFriends) {
                // Update the adapter with the fetched data
                FriendsAdapter adapter = new FriendsAdapter(FriendsActivity.this, suggestedFriends);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Exception e) {
                Toast.makeText(FriendsActivity.this, "Error fetching friends: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                // Handle the error (e.g., show a retry button, display an error message)
            }
        });
    }
    @Override
    public void onLogout() {
        // Handle logout logic here (e.g., navigate to login screen)
    }
}
