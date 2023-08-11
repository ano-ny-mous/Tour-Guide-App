package com.example.android.tourguideapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        textView = findViewById(R.id.snametv);
        textView1 = findViewById(R.id.description);
        imageView = (ImageView) findViewById(R.id.simageiv);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            textView.setText(bundle.getString("name"));
            textView1.setText(bundle.getString("des"));
            imageView.setImageResource(bundle.getInt("image", 0));
        }
    }
}
