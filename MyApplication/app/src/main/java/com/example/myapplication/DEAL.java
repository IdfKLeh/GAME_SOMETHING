package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DEAL implements Parcelable {
    @SerializedName("Name")
    private String internalName;

    @SerializedName("title")
    private String title;

    @SerializedName("metacriticLink")
    private String metacriticLink;

    @SerializedName("dealID")
    private String dealID;

    @SerializedName("storeID")
    private String storeID;

    @SerializedName("gameID")
    private String gameID;

    @SerializedName("salePrice")
    private String salePrice;

    @SerializedName("normalPrice")
    private String normalPrice;

    @SerializedName("isOnSale")
    private String isOnSale;

    @SerializedName("savings")
    private String savings;

    @SerializedName("metacriticScore")
    private String metacriticScore;

    @SerializedName("steamRatingText")
    private String steamRatingText;

    @SerializedName("steamRatingPercent")
    private String steamRatingPercent;

    @SerializedName("steamRatingCount")
    private String steamRatingCount;

    @SerializedName("steamAppID")
    private String steamAppID;

    @SerializedName("releasedDate")
    private String releaseDate;

    @SerializedName("lastChange")
    private String lastChange;

    @SerializedName("dealRating")
    private String dealRating;

    @SerializedName("thumb")
    private String thumb;

    public String getInternalName() {
        return internalName;
    }

    public String getTitle() {
        return title;
    }

    public String getMetacriticLink() {
        return metacriticLink;
    }

    public String getDealID() {
        return dealID;
    }

    public String getStoreID() {
        return storeID;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public String getNormalPrice() {
        return normalPrice;
    }

    public String getIsOnSale() {
        return isOnSale;
    }

    public String getSavings() {
        return savings;
    }

    public String getMetacriticScore() {
        return metacriticScore;
    }

    public String getSteamRatingText() {
        return steamRatingText;
    }

    public String getSteamRatingPercent() {
        return steamRatingPercent;
    }

    public String getSteamRatingCount() {
        return steamRatingCount;
    }

    public String getSteamAppID() {
        return steamAppID;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getLastChange() {
        return lastChange;
    }

    public String getDealRating() {
        return dealRating;
    }

    public String getThumb() {
        return thumb;
    }

    protected DEAL(Parcel in){
        internalName = in.readString();
        title = in.readString();
        metacriticLink = in.readString();
        dealID = in.readString();
        storeID = in.readString();
        gameID = in.readString();
        salePrice = in.readString();
        normalPrice = in.readString();
        isOnSale = in.readString();
        savings = in.readString();
        metacriticScore = in.readString();
        steamRatingText = in.readString();
        steamRatingPercent = in.readString();
        steamRatingCount = in.readString();
        steamAppID = in.readString();
        releaseDate = in.readString();
        lastChange = in.readString();
        dealRating = in.readString();
        thumb = in.readString();
    }
    public static final Creator<DEAL> CREATOR = new Creator<DEAL>() {
        @Override
        public DEAL createFromParcel(Parcel in) {
            return new DEAL(in);
        }

        @Override
        public DEAL[] newArray(int size) {
            return new DEAL[size];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(internalName);
        dest.writeString(title);
        dest.writeString(metacriticLink);
        dest.writeString(dealID);
        dest.writeString(storeID);
        dest.writeString(gameID);
        dest.writeString(salePrice);
        dest.writeString(normalPrice);
        dest.writeString(isOnSale);
        dest.writeString(savings);
        dest.writeString(metacriticScore);
        dest.writeString(steamRatingText);
        dest.writeString(steamRatingPercent);
        dest.writeString(steamRatingCount);
        dest.writeString(steamAppID);
        dest.writeString(releaseDate);
        dest.writeString(lastChange);
        dest.writeString(dealRating);
        dest.writeString(thumb);
    }


}

