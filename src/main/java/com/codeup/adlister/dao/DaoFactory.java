package com.codeup.adlister.dao;
import com.codeup.adlister.controllers.Config;
public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Wands wandsDao;
    private static final Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Wands getWandsDao(){
        if(wandsDao == null){
            wandsDao = new MySQLWandsDao(config);
        }
        return wandsDao;
    }
}
