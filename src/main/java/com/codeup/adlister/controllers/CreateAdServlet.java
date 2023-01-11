package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.models.Wand;
import com.codeup.adlister.models.WandAd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // get session user so I can use user data in SQL inserts
        User user = (User) request.getSession().getAttribute("user");

        // create and insert a new ad into the db
        Ad ad = new Ad(
            user.getId(),
            request.getParameter("title"),
            request.getParameter("description")
        );
        DaoFactory.getAdsDao().insert(ad);
        // get the ad that was just created from the db, so I can access the auto generated id
        Ad adReturnFromDb = DaoFactory.getAdsDao().getAdByTitle(ad.getAdTitle());

        // create and insert a new wand into the db
        Wand wand = new Wand(
                request.getParameter("wandName"),
                request.getParameter("coreMaterial"),
                request.getParameter("woodType"),
                request.getParameter("useCategory"),
                Integer.parseInt(request.getParameter("age")),
                "", // deal with image url later
                user.getId()
        );
        DaoFactory.getWandsDao().insert(wand);
        // get the wand that was just created from the db, so I can access the auto generated id
        Wand wandReturnFromDb = DaoFactory.getWandsDao().findByWandName(wand.getWandName());

        // create and insert wandAd, using id from the wand and ad created earlier in this method
        WandAd wandAd = new WandAd(wandReturnFromDb.getId(), (int) adReturnFromDb.getId());
        DaoFactory.getWandAdsDao().insert(wandAd);

        response.sendRedirect("/ads");
    }
}
