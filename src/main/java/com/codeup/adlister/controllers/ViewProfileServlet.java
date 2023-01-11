package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


//get info from the login servlet
@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null && request.getSession().getAttribute("password") == null) {
            response.sendRedirect("/login");
            return;
        }
        Ads adsDao = DaoFactory.getAdsDao();
        List<Ad> ad = adsDao.all();
        request.setAttribute("ads",ad);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);

    }
}


