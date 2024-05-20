package com.social.ecogreen;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.social.ecogreen.model.UserCommunities;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendSuggestionHelper {

    // Hardcoded user data
    private static final Map<String, UserCommunities> userCommunitiesMap = new HashMap<>();

    static {
        // Populate the map with sample user data

        userCommunitiesMap.put("3xmOyQolnhX37uU9AQIAjFIRJjq1", new UserCommunities("3xmOyQolnhX37uU9AQIAjFIRJjq1", "nuvasm2002", "https://placeholder.com/profile.jpg", Arrays.asList("DefaultCommunity", "CleanupCrews", "CompostingChampions", "RecyclingEnthusiast", "EnvironmentalEducation")));
        userCommunitiesMap.put("5wa3Jps2sLUiYqVkw5xzoAiagm82", new UserCommunities("5wa3Jps2sLUiYqVkw5xzoAiagm82", "kawyasamarasinghe1", "https://placeholder.com/profile.jpg", Arrays.asList("CleanupCrews", "GreenTechnology", "CompostingChampions", "EnvironmentalEducation", "DefaultCommunity")));
        userCommunitiesMap.put("CLvFHyfWadX6WN4RRbS0vINioTD3", new UserCommunities("CLvFHyfWadX6WN4RRbS0vINioTD3", "kaviwiha1", "https://placeholder.com/profile.jpg", Arrays.asList("GreenTechnology", "CompostingChampions", "RecyclingEnthusiast", "EnvironmentalEducation", "DefaultCommunity")));
        userCommunitiesMap.put("JrFcQgbZiMMEz9TZssd728TvhKz1", new UserCommunities("JrFcQgbZiMMEz9TZssd728TvhKz1", "kushi", "https://placeholder.com/profile.jpg", Arrays.asList("CompostingChampions", "RecyclingEnthusiast", "EnvironmentalEducation", "DefaultCommunity", "CleanupCrews")));
        userCommunitiesMap.put("Mj1x5xkREUhTuICWznqmEpF2ifX2", new UserCommunities("Mj1x5xkREUhTuICWznqmEpF2ifX2", "Thevindu", "https://placeholder.com/profile.jpg", Arrays.asList("RecyclingEnthusiast", "EnvironmentalEducation", "DefaultCommunity", "CleanupCrews", "GreenTechnology")));
        userCommunitiesMap.put("Sd7QavdMy4T1XpOYoSpQUWc5ucB2", new UserCommunities("Sd7QavdMy4T1XpOYoSpQUWc5ucB2", "sujaisamarasinghe", "https://placeholder.com/profile.jpg", Arrays.asList("EnvironmentalEducation", "DefaultCommunity", "CleanupCrews", "GreenTechnology", "CompostingChampions")));
        userCommunitiesMap.put("TN8PfxyfUpXtmLb2h5ZFFRWzXuJ2", new UserCommunities("TN8PfxyfUpXtmLb2h5ZFFRWzXuJ2", "yuri", "https://placeholder.com/profile.jpg", Arrays.asList("DefaultCommunity", "GreenTechnology", "CompostingChampions", "RecyclingEnthusiast", "CleanupCrews")));
        userCommunitiesMap.put("UwOHFAcpPCTjv2yteFuccs54vHr2", new UserCommunities("UwOHFAcpPCTjv2yteFuccs54vHr2", "Yakari", "https://placeholder.com/profile.jpg", Arrays.asList("GreenTechnology", "CompostingChampions", "EnvironmentalEducation", "DefaultCommunity", "RecyclingEnthusiast")));
        userCommunitiesMap.put("VUiSPva8ccRrQf43OB0jOPoFGbA3", new UserCommunities("VUiSPva8ccRrQf43OB0jOPoFGbA3", "mmaleesha1", "https://placeholder.com/profile.jpg", Arrays.asList("CompostingChampions", "EnvironmentalEducation", "DefaultCommunity", "CleanupCrews", "RecyclingEnthusiast")));
        userCommunitiesMap.put("VlZH7NWVgNecCv4zQv7krwahPt53", new UserCommunities("VlZH7NWVgNecCv4zQv7krwahPt53", "thilinimuthukumarana1", "https://placeholder.com/profile.jpg", Arrays.asList("EnvironmentalEducation", "DefaultCommunity", "CleanupCrews", "GreenTechnology", "RecyclingEnthusiast")));
        userCommunitiesMap.put("bdGaGyNB0VTiMpOeaqjHmP8R8dH3", new UserCommunities("bdGaGyNB0VTiMpOeaqjHmP8R8dH3", "wihangakaw1", "https://placeholder.com/profile.jpg", Arrays.asList("EnvironmentalEducation", "RecyclingEnthusiast", "DefaultCommunity", "GreenTechnology", "CleanupCrews")));
        userCommunitiesMap.put("dXWev0OuqxSRslnb8zrFQmpn5963", new UserCommunities("dXWev0OuqxSRslnb8zrFQmpn5963", "Nuwanjana", "https://placeholder.com/profile.jpg", Arrays.asList("RecyclingEnthusiast", "EnvironmentalEducation", "CompostingChampions", "CleanupCrews", "DefaultCommunity")));
        userCommunitiesMap.put("i2BUOBiFJoS0IJiV3xnYPiLyNPs2", new UserCommunities("i2BUOBiFJoS0IJiV3xnYPiLyNPs2", "kavisamarasinghe11", "https://placeholder.com/profile.jpg", Arrays.asList("DefaultCommunity", "GreenTechnology", "CompostingChampions", "EnvironmentalEducation", "CleanupCrews")));
        userCommunitiesMap.put("ihFHLTUGzFSKqmbjBWHWxc6Tuer1", new UserCommunities("ihFHLTUGzFSKqmbjBWHWxc6Tuer1", "Anee", "https://placeholder.com/profile.jpg", Arrays.asList("GreenTechnology", "CompostingChampions", "EnvironmentalEducation", "CleanupCrews", "RecyclingEnthusiast")));
        userCommunitiesMap.put("jTPfuoPx30Pq2dgVK2m9OrCmqgJ3", new UserCommunities("jTPfuoPx30Pq2dgVK2m9OrCmqgJ3", "chatteam95", "https://placeholder.com/profile.jpg", Arrays.asList("CompostingChampions", "RecyclingEnthusiast", "DefaultCommunity", "GreenTechnology", "EnvironmentalEducation")));
        userCommunitiesMap.put("kA7ytsBv6YhrK8DlOq4k03OHuEp2", new UserCommunities("kA7ytsBv6YhrK8DlOq4k03OHuEp2", "Test", "https://placeholder.com/profile.jpg", Arrays.asList("RecyclingEnthusiast", "DefaultCommunity", "CleanupCrews", "CompostingChampions", "GreenTechnology")));
        userCommunitiesMap.put("psVvFmIy83T0hz6YPj2mVeDduLj1", new UserCommunities("psVvFmIy83T0hz6YPj2mVeDduLj1", "Mihirangi", "https://placeholder.com/profile.jpg", Arrays.asList("DefaultCommunity", "CleanupCrews", "GreenTechnology", "EnvironmentalEducation", "CompostingChampions")));
        userCommunitiesMap.put("rGVcfzvTrvf664S5E7rpWpR2xWm1", new UserCommunities("rGVcfzvTrvf664S5E7rpWpR2xWm1", "dailiyapathirana1", "https://placeholder.com/profile.jpg", Arrays.asList("CleanupCrews", "CompostingChampions", "RecyclingEnthusiast", "EnvironmentalEducation", "DefaultCommunity")));
        userCommunitiesMap.put("sih65Ek6Q0O1SDPJGvVRVvLMsI52", new UserCommunities("sih65Ek6Q0O1SDPJGvVRVvLMsI52", "Aruna", "https://placeholder.com/profile.jpg", Arrays.asList("GreenTechnology", "EnvironmentalEducation", "DefaultCommunity", "CompostingChampions", "RecyclingEnthusiast")));
        userCommunitiesMap.put("tSsDtETK88eN9ahOdPepsjpzW043", new UserCommunities("tSsDtETK88eN9ahOdPepsjpzW043", "sewwandana1", "https://placeholder.com/profile.jpg", Arrays.asList("EnvironmentalEducation", "DefaultCommunity", "GreenTechnology", "CleanupCrews", "RecyclingEnthusiast")));
        userCommunitiesMap.put("vGduZIHt3GfNOoNDAFpEMP6iyb13", new UserCommunities("vGduZIHt3GfNOoNDAFpEMP6iyb13", "nuvanjana2002", "https://placeholder.com/profile.jpg", Arrays.asList("DefaultCommunity", "CleanupCrews", "RecyclingEnthusiast", "CompostingChampions", "EnvironmentalEducation")));
        userCommunitiesMap.put("65LlS4vkexOkyuiJseg7feovH982", new UserCommunities("65LlS4vkexOkyuiJseg7feovH982", "oshani", "https://placeholder.com/profile.jpg", Arrays.asList("GreenTechnology", "CompostingChampions", "DefaultCommunity", "CleanupCrews", "RecyclingEnthusiast")));

        // ...Add more users here (at least 10) with different community combinations...
    }

    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static CollectionReference usersRef = db.collection("Users");

    public static void suggestFriends(String currentUserId, Callback<List<UserCommunities>> callback) {
        UserCommunities currentUser = userCommunitiesMap.get(currentUserId);

        if (currentUser != null) {
            List<UserCommunities> overlappingFriends = new ArrayList<>();
            List<UserCommunities> randomFriends = new ArrayList<>();

            for (UserCommunities otherUser : userCommunitiesMap.values()) {
                if (!otherUser.userId.equals(currentUserId)) {
                    int overlapCount = 0;
                    for (String community : currentUser.recentCommunities) {
                        if (otherUser.recentCommunities.contains(community)) {
                            overlapCount++;
                        }
                    }
                    if (overlapCount >= 3) {
                        overlappingFriends.add(otherUser);
                    } else {
                        randomFriends.add(otherUser);
                    }
                }
            }

            Collections.shuffle(overlappingFriends);
            Collections.shuffle(randomFriends);

            // Ensure 6 overlapping friends, add from random if needed
            while (overlappingFriends.size() > 6) {
                overlappingFriends.remove(overlappingFriends.size() - 1);
            }
            while (overlappingFriends.size() < 6 && !randomFriends.isEmpty()) {
                overlappingFriends.add(randomFriends.remove(0));
            }

            // Take up to 4 random friends
            randomFriends = randomFriends.subList(0, Math.min(4, randomFriends.size()));

            // Now fetch profile images and create final list
            List<UserCommunities> finalSuggestedFriends = new ArrayList<>();
            int totalToFetch = overlappingFriends.size() + randomFriends.size();

            for (UserCommunities user : overlappingFriends) {
                fetchProfileImageAndAddToSuggestions(user, finalSuggestedFriends, totalToFetch, callback);
            }
            for (UserCommunities user : randomFriends) {
                fetchProfileImageAndAddToSuggestions(user, finalSuggestedFriends, totalToFetch, callback);
            }

        } else {
            callback.onFailure(new Exception("Current user not found."));
        }
    }

    private static void fetchProfileImageAndAddToSuggestions(UserCommunities user, List<UserCommunities> suggestedFriends, int totalToFetch, Callback<List<UserCommunities>> callback) {
        usersRef.document(user.getUserId()).get().addOnSuccessListener(documentSnapshot -> {
            if (documentSnapshot.exists()) {
                String profileImageUrl = documentSnapshot.getString("profileImage");
                user.setProfileUrl(profileImageUrl); // Update profile URL
                suggestedFriends.add(user);

                if (suggestedFriends.size() == totalToFetch) { // All data fetched
                    callback.onSuccess(suggestedFriends); // Return the list via the callback
                }
            }
        }).addOnFailureListener(callback::onFailure);
    }

    // Callback interface to return the results asynchronously
    public interface Callback<T> {
        void onSuccess(T result);
        void onFailure(Exception e);
    }
}
