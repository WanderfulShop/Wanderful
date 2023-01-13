package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "controllers.EditProfileServlet", urlPatterns = "/profile/editProfile")
public class EditProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello from editProfile doGet");
        // get updated userProfile from db
        //User sessionUser = request.getParameter("user");

        request.getRequestDispatcher("/WEB-INF/profile/editProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // validate inputs
        // update db
        // redirect to profile - display updated info from db
        User updatedUser = new User(request.getParameter("userName"), request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("school"), request.getParameter("email"));
        DaoFactory.getUsersDao().updateUser(updatedUser);
        System.out.println("Hello from editprofile doPost");
        //request.getRequestDispatcher("/profile/viewProfile").forward(request, response);
        response.sendRedirect("/profile/viewProfile");
    }
}
