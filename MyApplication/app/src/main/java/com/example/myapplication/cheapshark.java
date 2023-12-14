package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface cheapshark {
    @GET("deals")
    Call<List<DEAL>> getDeals(
            @Query("title") String title,
            @Query("upperPrice") Integer upperPrice,
            @Query("AAA") Integer AAA,
            @Query("steamworks") Integer steamworks,
            @Query("onSale") Integer onSale
    );
}
