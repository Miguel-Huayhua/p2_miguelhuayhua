package com.miguel.practica2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "sessionMiguel", urlPatterns = {"/sessionMiguel"})
public class sessionMiguel extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sessionMiguel</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sessionMiguel at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("tarea") == null) {
            ArrayList<Tarea> tarea = new ArrayList<Tarea>();
            request.getSession().setAttribute("tarea", tarea);
        }

        if ("si".equals(request.getParameter("borrar"))) {
            ArrayList<Tarea> lista = (ArrayList<Tarea>) request.getSession().getAttribute("tarea");
            for (Tarea t : lista) {
                if (t.getId() == Integer.parseInt(request.getParameter("id"))) {

                    lista.remove(t);
                    break;
                }
            }
        }
        request.getRequestDispatcher("session.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Tarea t = new Tarea();
        t.setCompletado(Boolean.parseBoolean(request.getParameter("completado")));
        t.setId(Integer.parseInt(request.getParameter("id")));
        t.setTarea(request.getParameter("tarea"));
        ArrayList<Tarea> lista = (ArrayList<Tarea>) request.getSession().getAttribute("tarea");
        lista.add(t);
        response.sendRedirect("sessionMiguel");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
