package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Wand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutput;
import java.io.IOException;

@WebServlet(name = "controllers.SearchBoxServlet", urlPatterns = "/search")
public class SearchBoxServlet extends HttpServlet {
    //get information from navbar.jsp form✅
    //Query the database for the User✅
    //Display relevant information for the user
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String wands = request.getParameter("wands");
        Wand wand = DaoFactory.getWandsDao().findByWandName(wands);
        request.setAttribute("wand", wand);
        request.getRequestDispatcher("/WEB-INF/search.jsp").forward(request, response);
    }

}