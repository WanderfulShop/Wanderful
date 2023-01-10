package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.codeup.adlister.models.Wand;

import java.util.List;

public interface Wands {
    Wand findByWandName(String wandName);
    Long insert(Wand wand);

}