package com.example.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Data data = intent.getParcelableExtra("Data");

        assert data != null;
        int imageRes = data.getImageView();
        String title1 = data.getText1();
        String title2 = data.getText2();

        ImageView imageView = findViewById(R.id.SecondImageViewId);
        imageView.setImageResource(imageRes);

        TextView textView1 = findViewById(R.id.SecondTextView1Id);
        textView1.setText(title1);

        TextView textView2 = findViewById(R.id.SecondTextView2Id);
        textView2.setText(title2);
    }
}
