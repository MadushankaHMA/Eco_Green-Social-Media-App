package com.social.ecogreen;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
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
        classifiedTextView = findViewById(R.id.textView);
/*        locationTextView = findViewById(R.id.location);
        quantityTextView = findViewById(R.id.Qquantity);
        timePeriodTextView = findViewById(R.id.time);
        priceTextView = findViewById(R.id.pPrice);
        postTextView = findViewById(R.id.post);*/

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

        //postTextView.setOnClickListener(v -> postToFirebase());
    }

   /* private Bitmap decodeImage(String encodedImage) {
        byte[] decodedByte = Base64.decode(encodedImage, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }*/

    /*private void postToFirebase() {
        String location = locationTextView.getText().toString();
        String quantity = quantityTextView.getText().toString();
        String timePeriod = timePeriodTextView.getText().toString();
        String price = priceTextView.getText().toString();
        String classifiedResult = classifiedTextView.getText().toString();

        if (location.isEmpty() || quantity.isEmpty() || timePeriod.isEmpty() || price.isEmpty()) {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
            return;
        }

        Map<String, Object> postMap = new HashMap<>();
        postMap.put("location", location);
        postMap.put("quantity", quantity);
        postMap.put("timePeriod", timePeriod);
        postMap.put("price", price);
        postMap.put("classifiedResult", classifiedResult);
        postMap.put("userId", FirebaseAuth.getInstance().getCurrentUser().getUid());

        FirebaseFirestore.getInstance().collection("posts").add(postMap)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "Post created successfully", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e -> Toast.makeText(this, "Failed to create post", Toast.LENGTH_SHORT).show());
    }*/
}
