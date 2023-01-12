package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.Config;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.Wand;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLWandsDao implements Wands{

    private final Connection connection;

    public MySQLWandsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
    @Override
    public Wand findByWandName(String wandName) {
        String query = "SELECT * FROM wands WHERE wand_name = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, wandName);
            return extractWand(stmt.executeQuery());
        } catch (SQLException e){
            throw new RuntimeException("Error finding " + wandName + " in the wands db", e);
        }
    }

    public Wand findWandByAdId(int adId){
        String query = "SELECT * FROM wands as W JOIN wand_ads as WA ON W.id = WA.wand_id JOIN ads as A ON WA.ad_id = A.id WHERE A.id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, adId + 1);
            return extractWand(stmt.executeQuery());
        } catch(SQLException e){
            throw new RuntimeException("Error finding wand by adId where adId = " + adId, e);
        }

    }
    private Wand extractWand(ResultSet rs) throws SQLException {
        if(! rs.next()){
            return null;
        }
        return new Wand(
            rs.getInt(1),
            rs.getString(2),
            rs.getString(3),
            rs.getString(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getString(7),
            rs.getInt(8)
        );
    }

    @Override
    public void insert(Wand wand){
            String query = "INSERT INTO wands(wand_name, core_material, wood_type, use_category, age, image, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, wand.getWandName());
            stmt.setString(2, wand.getCoreMaterial());
            stmt.setString(3, wand.getWoodType());
            stmt.setString(4, wand.getUseCategory());
            stmt.setInt(5, wand.getAge());
            stmt.setString(6, wand.getImageUri());
            stmt.setInt(7, wand.getUserId());
            stmt.execute();
        } catch(SQLException e){
            throw new RuntimeException("Error creating new wand '" + wand.getWandName() + "'", e);
        }
    }



}
