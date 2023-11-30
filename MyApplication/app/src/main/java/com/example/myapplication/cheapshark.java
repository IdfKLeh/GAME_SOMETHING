package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface cheapshark {
    @GET("deals")
    Call<List<DEAL>> getDeals(
            @Query("storeID") String storeID,
            @Query("upperPrice") Integer upperPrice
    );
}
