package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int adId = Integer.parseInt(request.getParameter("adId"));
        request.setAttribute("ad", DaoFactory.getAdsDao().all().get(adId));
        request.setAttribute("wand", DaoFactory.getWandsDao().findWandByAdId(adId));
        request.setAttribute("user", DaoFactory.getUsersDao().findUserByAdId(adId));
        request.getRequestDispatcher("WEB-INF/ads/ad.jsp").forward(request, response);
    }
}
