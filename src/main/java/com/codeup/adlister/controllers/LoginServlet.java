package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User userAttempt = new User();
        userAttempt.setUserName(request.getParameter("username"));
        userAttempt.setPassword(request.getParameter("password"));
        String rawInputPw = request.getParameter("password");
        
        User userFromDB = DaoFactory.getUsersDao().findByUsername(userAttempt.getUserName());


        if (userFromDB == null) {
            /* error msg here: No username entered*/
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
            request.setAttribute("error", "Invalid Username!");
            requestDispatcher.forward(request, response);
            return;
        }

        // validate password matches db
        // boolean validAttempt = Password.check(rawInputPw, userFromDB.getPassword());
        boolean validAttempt = true; // for debugging

        if (validAttempt) {
            request.getSession().setAttribute("user", userFromDB);
            response.sendRedirect("/profile");
        } else {
            request.getSession().setAttribute("error", "Invalid password");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);        }
    }
}
