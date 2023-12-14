package com.example.myapplication.ui.home;

import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.DEAL;
import com.example.myapplication.R;

import org.w3c.dom.Text;

public class GameViewHolder extends RecyclerView.ViewHolder {

    private ImageView thumbnailImageView;
    private TextView titleTextView;
    private TextView normalpriceTextView;
    private TextView salepriceTextView;
    private OnGameItemClickListener listener;
    public GameViewHolder(@NonNull View itemView, OnGameItemClickListener listener) {
        super(itemView);

        this.listener = listener;
        thumbnailImageView = itemView.findViewById(R.id.thumbnailImageView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        normalpriceTextView= itemView.findViewById(R.id.normalpriceTextView);
        salepriceTextView = itemView.findViewById(R.id.salepriceTextView);

    }

    public void bind(DEAL game){
        // Bind data to views here
        // For example:
        // titleTextView.setText(game.getTitle());
        // You may need to load the thumbnail image using a library like Glide or Picasso
        // Glide.with(itemView).load(game.getThumbnailUrl()).into(thumbnailImageView);
        String thumbnailUrl = game.getThumb();
        String title = game.getTitle();
        String normalPrice = game.getNormalPrice();
        String salePrice = game.getSalePrice();

        Log.d("GameViewHolder", "Normal Price: " + normalPrice);
        Log.d("GameViewHolder", "Sale Price: " + salePrice);

        Glide.with(itemView.getContext()).load(thumbnailUrl).into(thumbnailImageView);
        titleTextView.setText(title);
        normalpriceTextView.setText(normalPrice);
        normalpriceTextView.setPaintFlags(normalpriceTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        salepriceTextView.setText(salePrice);

        itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("GameViewHolder", "Item clicked at position: " + getAdapterPosition());
                if (listener != null) {
                    listener.onGameItemClick(getAdapterPosition());
                }
            }
        });


    }

    public interface OnGameItemClickListener{
        void onGameItemClick(int position);
    }
}
