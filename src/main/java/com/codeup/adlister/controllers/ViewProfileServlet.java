package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null && request.getSession().getAttribute("password") == null) {
            response.sendRedirect("/login");
            return;
        }
        // With the request I am SETTING the attribute with my desired input (all the ads) and PASSING it to the JSP with the help of the DISPATCHER
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user.getSchool() = " + user.getSchool());
        System.out.println("user.getFirstName() = " + user.getFirstName());
        System.out.println("user.getLastName() = " + user.getLastName());
        System.out.println("user.getEmail() = " + user.getEmail());
        request.setAttribute("ads", DaoFactory.getAdsDao().getAdsOfTheDay());
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean editProfile = Boolean.parseBoolean((String) request.getAttribute("editProfile"));
        if(editProfile){
            request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);
        }

    }
}


