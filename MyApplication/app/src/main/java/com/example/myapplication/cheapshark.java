package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface cheapshark {
    @GET("/deals?storeID=1&upperPrice15")
    Call<List<DEAL>> getData(@Query("storeID") String id);
}
