package com.codeup.adlister.dao;

import com.codeup.adlister.models.Wand;

public interface Wands {
    Wand findByWandName(String wandName);
    void insert(Wand wand);
    Wand getWandByAdId(int adId);

}