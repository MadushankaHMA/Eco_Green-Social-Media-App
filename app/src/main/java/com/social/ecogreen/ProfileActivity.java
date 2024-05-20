package com.social.ecogreen;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.social.ecogreen.fragments.Profile;

public class ProfileActivity extends AppCompatActivity implements Profile.OnLogoutListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile); // Create activity_profile.xml layout file

        String userUID = getIntent().getStringExtra("userUID");

        Profile profileFragment = new Profile();
        Bundle bundle = new Bundle();
        bundle.putString("userUID", userUID);
        profileFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.profile_container, profileFragment) // Add profileFragment to the container in your layout
                .commit();
    }

    @Override
    public void onLogout() {
        // Handle logout logic here if needed
    }
}