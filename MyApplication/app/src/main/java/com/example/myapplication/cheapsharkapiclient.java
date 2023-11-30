package com.example.myapplication;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class cheapsharkapiclient {
    private static final String BASE_URL="https://www.cheapshark.com/api/1.0/";

    public static cheapshark create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(cheapshark.class);

    }
}
