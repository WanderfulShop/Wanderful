package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutput;
import java.io.IOException;

@WebServlet(name = "controllers.SearchServlet", urlPatterns = "/search/usersearch")
public class SearchServlet extends HttpServlet {
    //get information from navbar.jsp form✅
    //Query the database for the User✅
    //Display relevant information for the user
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/search/usersearch.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        User user = DaoFactory.getUsersDao().findByUsername(username);
        request.setAttribute("user", user);
//        request.getRequestDispatcher("/WEB-INF/search/usersearch.jsp").forward(request, response);


        if (user == null) {
            /* error msg here: No username found*/
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/search/usersearch.jsp");
            request.setAttribute("noUser", "No user found");
            requestDispatcher.forward(request, response);
            return;
        }
        request.getRequestDispatcher("/WEB-INF/search/usersearch.jsp").forward(request, response);
    }

}
