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
import java.util.Enumeration;
import java.util.List;


//get info from the login servlet
@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile/viewProfile")
public class ViewProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello from ViewProfile doGet");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        // With the request I am SETTING the attribute with my desired input (all the ads) and PASSING it to the JSP with the help of the DISPATCHER
        User user = (User) request.getSession().getAttribute("user");
        System.out.println("user.getUserName() = " + user.getUserName());
        User userFromDb = DaoFactory.getUsersDao().findByUsername(user.getUserName());
        System.out.println("userFromDb.getUserName() = " + userFromDb.getUserName());
        request.setAttribute("user", userFromDb);
        request.setAttribute("ads", DaoFactory.getAdsDao().getAdsOfTheDay());
        request.getRequestDispatcher("/WEB-INF/profile/viewProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello from viewProfile doPost");
        response.sendRedirect("/profile/editProfile");
    }
}


