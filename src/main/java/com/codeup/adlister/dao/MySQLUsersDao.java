package com.codeup.adlister.dao;
import com.codeup.adlister.controllers.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class MySQLUsersDao implements Users {
    private final Connection connection;

    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String userName) {
        String query = "SELECT * FROM users as U WHERE U.user_name = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, userName);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username: " + userName, e);
        }
    }

    @Override
    public User findUserByAdId(int adId){
        String query = "SELECT * FROM users as U JOIN wands as W on U.id = W.user_id JOIN wand_ads as WA ON W.id = WA.wand_id WHERE WA.ad_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, adId);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by adId: " + adId, e);
        }
    }

    @Override
    public Long insert(User user) throws SQLException {
        String query = "INSERT INTO users(user_name, first_name, last_name, school, email, user_password) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getUserName());
        stmt.setString(2, user.getFirstName());
        stmt.setString(3, user.getLastName());
        stmt.setString(4, user.getSchool());
        stmt.setString(5, user.getEmail());
        stmt.setString(6, user.getPassword());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        return rs.getLong(1);
    }

    /**
     * @param userName is a string holding the username to look up
     * @return is a string holding the hashed password. Use this pw to Password.check()
     * */
    public String getPasswordByUsername(String userName){
        String query = "SELECT user_password FROM users as U WHERE U.user_name = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("user_password");
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username: " + userName, e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getInt("id"),
            rs.getString("user_name"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("school"),
            rs.getString("email"),
            rs.getString("user_password")
        );
    }

    @Override
    public User getUserByWandName(String wandName){
        String query = "SELECT * FROM users as U JOIN wands as W ON U.id = W.user_id WHERE W.wand_name = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, wandName);
            return extractUser(stmt.executeQuery());
        } catch(SQLException e){
            throw new RuntimeException("Error finding User by Wand Name where Wand Name = " + wandName, e);
        }
    }

}
