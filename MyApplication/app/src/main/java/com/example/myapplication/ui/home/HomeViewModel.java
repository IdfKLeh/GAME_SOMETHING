package com.example.myapplication.ui.home;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.DEAL;
import com.example.myapplication.cheapshark;
import com.example.myapplication.cheapsharkapiclient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;


public class HomeViewModel extends ViewModel {



    private final MutableLiveData<String> insTitle;
    private final MutableLiveData<Integer> insHigh;
    private final MutableLiveData<String> Title;
    private final MutableLiveData<String> High;
    private final MutableLiveData<Boolean> isAAA;
    private final MutableLiveData<Boolean> isSteamRedeem;
    private final MutableLiveData<Boolean> isOnSale;

    public HomeViewModel() {

        insTitle = new MutableLiveData<>();
        insHigh = new MutableLiveData<>();
        Title = new MutableLiveData<>();
        High = new MutableLiveData<>();
        isAAA = new MutableLiveData<>();
        isSteamRedeem = new MutableLiveData<>();
        isOnSale = new MutableLiveData<>();

        Title.setValue("Title");
        High.setValue("Maximum price");
        //GetDealData();
    }


    public LiveData<String> getInsTitle() {
        return insTitle;
    }
    public LiveData<Integer> getInsHigh() {return  insHigh;}
    public LiveData<String> getTitleText(){return Title;}
    public LiveData<String> getHighText(){return High;}
    public LiveData<Boolean> getIsAAA(){return isAAA;}
    public LiveData<Boolean> getIsSteamRedeem(){return isSteamRedeem;}
    public LiveData<Boolean> getIsOnSale(){return isOnSale;}
    public void setIsAAA(boolean value) {
        isAAA.setValue(value);
    }

    public void setIsSteamRedeem(boolean value) {
        isSteamRedeem.setValue(value);
    }

    public void setIsOnSale(boolean value) {
        isOnSale.setValue(value);
    }


}