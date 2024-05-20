package com.social.ecogreen.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.social.ecogreen.ProfileActivity;
import com.social.ecogreen.R;
import com.social.ecogreen.fragments.Profile;
import com.social.ecogreen.model.UserCommunities;

import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.FriendViewHolder> {

    private Context context;
    private List<UserCommunities> friends;

    public FriendsAdapter(Context context, List<UserCommunities> friends) {
        this.context = context;
        this.friends = friends;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.friend_item, parent, false);
        return new FriendViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        UserCommunities friend = friends.get(position);

        holder.usernameTextView.setText(friend.getUsername());
        Glide.with(context)
                .load(friend.getProfileUrl())
                .placeholder(R.drawable.default_profile_pic)
                .error(R.drawable.error_profile_pic)
                .into(holder.profilePictureImageView);

        holder.viewProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProfileActivity.class);
            intent.putExtra("userUID", friend.getUserId()); // Pass the selected user's ID
            context.startActivity(intent);
        });
/*        holder.viewProfileButton.setOnClickListener(v -> {
            AppCompatActivity activity = (AppCompatActivity) context;
            Fragment profileFragment = new Profile();

            Bundle bundle = new Bundle();
            bundle.putString("userUID", friend.getUserId()); // Pass the friend's ID

            profileFragment.setArguments(bundle); // Set arguments for the Profile fragment

            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_friends, profileFragment)
                    .addToBackStack(null)
                    .commit();
        });*/
     }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    static class FriendViewHolder extends RecyclerView.ViewHolder {
        ImageView profilePictureImageView;
        TextView usernameTextView;
        Button viewProfileButton;

        FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            profilePictureImageView = itemView.findViewById(R.id.profilePictureImageView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            viewProfileButton = itemView.findViewById(R.id.viewProfileButton);
        }
    }
}
