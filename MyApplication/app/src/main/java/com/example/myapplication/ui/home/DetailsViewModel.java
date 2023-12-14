package com.example.myapplication.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.DEAL;


public class DetailsViewModel extends ViewModel{
    private final MutableLiveData<DEAL> gameDetails = new MutableLiveData<>();

    public LiveData<DEAL> getGameDetails(){
        return gameDetails;
    }

    public void setGameDetails(DEAL game){
        gameDetails.setValue(game);
    }

}

