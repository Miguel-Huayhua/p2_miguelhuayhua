package com.miguel.practica2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cookiesMiguel", urlPatterns = {"/cookiesMiguel"})
public class cookiesMiguel extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean detectar = false;
        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if ("detectar".equals(c.getName())) {
                    detectar = !detectar;
                    request.setAttribute("detectar", detectar);
                    break;
                }
                Cookie c2 = new Cookie("detectar", "");
                c2.setMaxAge(3600);
                response.addCookie(c2);
                request.setAttribute("detectar", detectar);
            }
        } else {
            Cookie c2 = new Cookie("detectar", "");
            c2.setMaxAge(3600);
            response.addCookie(c2);
            request.setAttribute("detectar", detectar);

        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
