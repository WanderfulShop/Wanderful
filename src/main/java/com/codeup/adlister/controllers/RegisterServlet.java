package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

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

        if(username.isEmpty() || email.isEmpty() || password.isEmpty() || ! password.equals(passwordConfirmation)){
            request.setAttribute("error", "invalid input");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/register.jsp");
/*            request.setAttribute("username", username);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("school", school);
            request.setAttribute("email", email);*/
            requestDispatcher.forward(request, response);
            return;
        }



        // create and save a new user
        User user = new User(username, firstName, lastName, school, email, password);
        try {
            DaoFactory.getUsersDao().insert(user);
        } catch (SQLException e) {
            // if username already exists, send back to /register
            request.setAttribute("error", "username " + username + " already exists in database. Pick a different username.");
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        response.sendRedirect("/login");
    }


}
