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


    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    private void GetDealData(){
        cheapshark cheapShark = cheapsharkapiclient.create();

        Call<List<DEAL>> call = cheapShark.getDeals("1",15);

        call.enqueue(new Callback<List<DEAL>>(){
            @Override
            public void onResponse(Call<List<DEAL>> call, Response<List<DEAL>> response){
                if(response.isSuccessful()){

                }
                else {
                    mText.setValue();

                }
            }
            @Override
            public void onFailure(Call<List<DEAL>> call, Throwable t){

            }
        });
    }



}