package com.example.myapplication.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DEAL;
import com.example.myapplication.R;

import java.util.List;

public class GameAdapter extends RecyclerView.Adapter<GameViewHolder> {

    private List<DEAL> gameList;
    private GameViewHolder.OnGameItemClickListener listener;

    public GameAdapter(List<DEAL> gameList, GameViewHolder.OnGameItemClickListener listener){
        this.gameList = gameList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_game, parent, false);
        return new GameViewHolder(view, listener);
    }

    public DEAL getGameAt(int position) {
        return gameList.get(position);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position){
        DEAL game = gameList.get(position);
        holder.bind(game);
    }

    @Override
    public int getItemCount(){
        return gameList.size();
    }

    public void setGames(List<DEAL> newGameList){
        gameList.clear();
        gameList.addAll(newGameList);
        notifyDataSetChanged();
    }
}
