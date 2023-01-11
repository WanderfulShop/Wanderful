package com.codeup.adlister.dao;
import com.codeup.adlister.controllers.Config;
import com.codeup.adlister.models.WandAd;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;


public class MySQLWandAdsDao implements WandAds{
    private final Connection connection;

    public MySQLWandAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error in WandAdsDao connecting to the database!", e);
        }
    }
    @Override
    public void insert(WandAd wandAd) {
        String query = "INSERT INTO wand_ads(wand_id, ad_id) VALUES (?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, String.valueOf(wandAd.getWandId()));
            stmt.setString(2, String.valueOf(wandAd.getAdId()));
            stmt.executeUpdate();
/*            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);*/
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting wandAd" , e);
        }
    }
}
