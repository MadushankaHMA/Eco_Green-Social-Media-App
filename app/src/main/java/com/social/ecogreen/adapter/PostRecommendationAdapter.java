package com.social.ecogreen.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.social.ecogreen.R;


import com.social.ecogreen.RecommendationPostItem;

import java.util.List;

public class PostRecommendationAdapter extends RecyclerView.Adapter<PostRecommendationAdapter.PostViewHolder> {

    private List<RecommendationPostItem> postList;

    public PostRecommendationAdapter(List<RecommendationPostItem> postList) {
        this.postList = postList;
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView post_idTextView;
        TextView sellerTextView;
        TextView spi_typeTextView;
        TextView locationTextView;
        TextView industryTextView;
        TextView quantityTextView;
        TextView priceTextView;
        Button buyNowButton;

        public PostViewHolder(View itemView) {
            super(itemView);
            post_idTextView = itemView.findViewById(R.id.post_id);
            sellerTextView = itemView.findViewById(R.id.post_seller);
            spi_typeTextView = itemView.findViewById(R.id.post_spi_type);
            locationTextView = itemView.findViewById(R.id.post_location);
            industryTextView = itemView.findViewById(R.id.post_industry);
            quantityTextView = itemView.findViewById(R.id.post_quantity);
            priceTextView = itemView.findViewById(R.id.post_price);
            buyNowButton = itemView.findViewById(R.id.post_buynowbtn);

        }
    }


    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_recommendation_post_item, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        RecommendationPostItem currentPost = postList.get(position);
        holder.post_idTextView.setText(currentPost.getPostId());
        holder.sellerTextView.setText(currentPost.getSeller());
        holder.spi_typeTextView.setText(String.valueOf(currentPost.getSpi_type()));
        holder.locationTextView.setText(currentPost.getLocation());
        holder.industryTextView.setText(currentPost.getIndustry());
        holder.quantityTextView.setText(String.valueOf(currentPost.getQuantity()));
        holder.priceTextView.setText(String.valueOf(currentPost.getPrice()));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void updatePostList(List<RecommendationPostItem> newPostList) {
        this.postList = newPostList;
    }


}
