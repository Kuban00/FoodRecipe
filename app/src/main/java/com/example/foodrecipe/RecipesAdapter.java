package com.example.foodrecipe;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.MyViewHolder> {
    public String[] d1;
    public String[] d2;
    public int[] icons;
    public Context context;

    public RecipesAdapter(Context ct, String[] s1, String[] s2, int[] ic) {
        context = ct;
        d1 = s1;
        d2 = s2;
        icons = ic;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_recipes, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.textViewName.setText(d1[position]);
        holder.textViewTime.setText(d2[position]);
        holder.imageViewIcon.setImageResource(icons[position]);

        holder.mainLayout.setOnClickListener(view -> {
            Intent intent = new Intent(context, OpenRecipe.class);
            intent.putExtra("d1", d1[position]);
            intent.putExtra("d2", d2[position]);
            intent.putExtra("imageViewIcon", icons[position]);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return icons.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewTime;
        public ImageView imageViewIcon;
        public RelativeLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            imageViewIcon = itemView.findViewById(R.id.imageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
