package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.SQLException;
import java.util.List;

public interface Users {
    User findByUsername(String username);
    User findUserByAdId(int adId);
    Long insert(User user) throws SQLException;

    String getPasswordByUsername(String rawInputUsername);
}
