package com.example.myapplication;

import com.google.gson.annotations.SerializedName;

public class DEAL {
    @SerializedName("Name")
    private String internalName;

    @SerializedName("title")
    private String title;

    @SerializedName("metalink")
    private String metacriticLink;

    @SerializedName("deal")
    private String dealID;

    @SerializedName("store")
    private String storeID;

    @SerializedName("sale")
    private String salePrice;

    @SerializedName("normal")
    private String normalPrice;

    @SerializedName("isitonsale")
    private String isOnSale;

    @SerializedName("savings")
    private String savings;

    @SerializedName("metascore")
    private String metacriticScore;

    @SerializedName("steamratingtext")
    private String steamRatingText;

    @SerializedName("steamratingpercent")
    private String steamRatingPercent;

    @SerializedName("steamratingcount")
    private String steamRatingCount;

    @SerializedName("steamid")
    private String steamAppID;

    @SerializedName("released")
    private String releaseDate;

    @SerializedName("changed")
    private String lastChange;

    @SerializedName("dealrate")
    private String dealRating;

    @SerializedName("thumb")
    private String thumb;

    /*
     "internalName": "DEUSEXHUMANREVOLUTIONDIRECTORSCUT",
             "title": "Deus Ex: Human Revolution - Director's Cut",
             "metacriticLink": "/game/pc/deus-ex-human-revolution---directors-cut",
             "dealID": "HhzMJAgQYGZ%2B%2BFPpBG%2BRFcuUQZJO3KXvlnyYYGwGUfU%3D",
             "storeID": "1",
             "gameID": "102249",
             "salePrice": "2.99",
             "normalPrice": "19.99",
             "isOnSale": "1",
             "savings": "85.042521",
             "metacriticScore": "91",
             "steamRatingText": "Very Positive",
             "steamRatingPercent": "92",
             "steamRatingCount": "17993",
             "steamAppID": "238010",
             "releaseDate": 1382400000,
             "lastChange": 1621536418,
             "dealRating": "9.6",
             "thumb": "https://cdn.cloudflare.steamstatic.com/steam/apps/238010/capsule_sm_120.jpg?t=1619788192"
    */
}

