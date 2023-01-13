package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;
import org.mindrot.jbcrypt.BCrypt;

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
        // get user input from the post request.
        String rawInputUsername = request.getParameter("username");
        String rawInputPw = request.getParameter("password");

        // get password from the db. Hold the password in a string, rather than in a User object to avoid hashing it again.
        String pwFromDb = DaoFactory.getUsersDao().getPasswordByUsername(rawInputUsername);
        // get a user from the database. Don't use the password from this User object, as it has been hashed twice.
        User userFromDB = DaoFactory.getUsersDao().findByUsername(rawInputUsername);

        if (pwFromDb == null) {
            /* error msg here: No username entered*/
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
            request.setAttribute("error", "Invalid Username!");
            request.setAttribute("username", rawInputUsername);
            requestDispatcher.forward(request, response);
            return;
        }

        // validate password matches db
        boolean validAttempt =  BCrypt.checkpw(rawInputPw, pwFromDb);

        if (validAttempt) {
            // if valid, login and go to profile page
            request.getSession().setAttribute("user", userFromDB);
            response.sendRedirect("/profile/viewProfile");
        } else {
            // if invalid attempt, go back to login page - Apply session data to implement "sticky forms."
            request.getSession().setAttribute("error", "Invalid password: valid attempt: " + validAttempt);
            request.getSession().setAttribute("username", rawInputUsername);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
