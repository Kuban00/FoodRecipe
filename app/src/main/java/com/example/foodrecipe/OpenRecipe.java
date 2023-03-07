package com.example.foodrecipe;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OpenRecipe extends AppCompatActivity {
    public TextView textViewTitle;
    public TextView textViewRecipe;
    public ImageView imageViewProduct;
    public String d1;
    public String d2;
    public int imageViewIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_openrecipe);

        imageViewProduct = findViewById(R.id.imageViewProduct);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewRecipe = findViewById(R.id.textViewRecipe);

        getData();
        setData();
    }

    private void getData() {
        if (getIntent().hasExtra("imageViewIcon") && getIntent().hasExtra("d1") && getIntent().hasExtra("d2")) {
            d1 = getIntent().getStringExtra("d1");
            d2 = getIntent().getStringExtra("d2");
            imageViewIcon = getIntent().getIntExtra("imageViewIcon", 1);
        } else {
            Toast.makeText(this, "Brak danych", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        textViewTitle.setText(d1);
        textViewRecipe.setText(d2);
        imageViewProduct.setImageResource(imageViewIcon);
    }
}