package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String school = request.getParameter("school");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirmPassword");

        // validate input
        if(username.isEmpty()){
            request.setAttribute("error", "invalid username");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/register.jsp");
            requestDispatcher.forward(request, response);
            return;
        }

        if(email.isEmpty()){
            request.setAttribute("error", "invalid email");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/register.jsp");
            requestDispatcher.forward(request, response);
            return;
        }

        if(password.isEmpty()){
            request.setAttribute("error", "invalid password");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/register.jsp");
            requestDispatcher.forward(request, response);
            return;
        }
        if(! password.equals(passwordConfirmation)){
            request.setAttribute("error", "passwords do not match");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/register.jsp");
            requestDispatcher.forward(request, response);
            return;
        }


        // create and save a new user
        User user = new User(username, firstName, lastName, school, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
