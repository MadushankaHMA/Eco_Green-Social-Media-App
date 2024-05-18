package com.social.ecogreen;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class PostActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView classifiedTextView, locationTextView, quantityTextView, timePeriodTextView, priceTextView, postTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        imageView = findViewById(R.id.imageView);
        classifiedTextView = findViewById(R.id.classifiedTextView);
        locationTextView = findViewById(R.id.locationTextView);
        quantityTextView = findViewById(R.id.quantityTextView);
        /*timePeriodTextView = findViewById(R.id.timePeriodTextView);*/
        priceTextView = findViewById(R.id.priceTextView);
        postTextView = findViewById(R.id.postTextView);

        Intent intent = getIntent();
        String imageString = intent.getStringExtra("image");
        String classifiedResult = intent.getStringExtra("classifiedResult");

        if (imageString != null) {
            byte[] imageBytes = Base64.decode(imageString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            imageView.setImageBitmap(bitmap);
        }

        if (classifiedResult != null) {
            classifiedTextView.setText(classifiedResult);
        }

        postTextView.setOnClickListener(v -> postToFirebase());
    }


    private void postToFirebase() {
        String location = locationTextView.getText().toString();
        String quantity = quantityTextView.getText().toString();
        /*String timePeriod = timePeriodTextView.getText().toString();*/
        String price = priceTextView.getText().toString();
        String classifiedResult = classifiedTextView.getText().toString();

        if (location.isEmpty() || quantity.isEmpty() || price.isEmpty()) {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert image to base64 string
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageData = baos.toByteArray();
        String imageBase64 = Base64.encodeToString(imageData, Base64.DEFAULT);

        Map<String, Object> postMap = new HashMap<>();
        postMap.put("location", location);
        postMap.put("quantity", quantity);
        /*postMap.put("timePeriod", timePeriod);*/
        postMap.put("price", price);
        postMap.put("classifiedResult", classifiedResult);
        postMap.put("userId", FirebaseAuth.getInstance().getCurrentUser().getUid());
        postMap.put("image", imageBase64); // Add image data to the map

        FirebaseFirestore.getInstance().collection("posts").add(postMap)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "Post created successfully", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(this, "Failed to create post", Toast.LENGTH_SHORT).show());
    }
}
