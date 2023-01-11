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
        String rawInputUsername = request.getParameter("username");
        String rawInputPw = request.getParameter("password");
        
        User userFromDB = DaoFactory.getUsersDao().findByUsername(rawInputUsername);

        System.out.println(rawInputUsername);
        System.out.println(userFromDB.getUserName());

        if (userFromDB == null) {
            /* error msg here: No username entered*/
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
            request.setAttribute("error", "Invalid Username!");
            request.setAttribute("username", rawInputUsername);
            requestDispatcher.forward(request, response);
            return;
        }

        // checking vars through sout®
        System.out.println("userFromDB.getPassword() = " + userFromDB.getPassword());
        System.out.println("rawInputPw = " + rawInputPw);


        // validate password matches db
        boolean validAttempt =  BCrypt.checkpw(rawInputPw, userFromDB.getPassword());
        // BCrypt is working
        // Is the way password is saved to db incorrect?
        // insert statement in dao
        // refactor the insert?


        if (validAttempt) {
            request.getSession().setAttribute("user", userFromDB);
            response.sendRedirect("/profile");
        } else {

            request.getSession().setAttribute("error", "Invalid password: valid attempt: " + validAttempt);

            request.getSession().setAttribute("username", rawInputUsername);

            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
