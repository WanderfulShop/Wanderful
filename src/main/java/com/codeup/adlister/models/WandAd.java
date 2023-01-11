package com.codeup.adlister.models;

import java.io.Serializable;

public class WandAd implements Serializable {
    private int adId;
    private int wandId;

    public WandAd(){}
    public WandAd(int wandId, int adId){
        this.adId = adId;
        this.wandId = wandId;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public int getWandId() {
        return wandId;
    }

    public void setWandId(int wandId) {
        this.wandId = wandId;
    }
}
