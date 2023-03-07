package com.example.foodrecipe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public String[] s1, s2;
    public int[] icons = {R.drawable.burger,
            R.drawable.tortilla,
            R.drawable.burrito,
            R.drawable.spaghetti,
            R.drawable.pizza,
            R.drawable.shrimp,
            R.drawable.chicken};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.Recipes);
        s2 = getResources().getStringArray(R.array.Time);
        RecipesAdapter recipesAdapter = new RecipesAdapter(this, s1, s2, icons);
        recyclerView.setAdapter(recipesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}