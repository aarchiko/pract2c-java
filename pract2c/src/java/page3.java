/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class page3 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet page3</title>");            
            out.println("</head>");
            out.println("<body bgcolor=green>");
            
            HttpSession hs = request.getSession(true);
            if(hs.isNew())
            {
                out.println("<body bgcolor=yellow>");
                String name  = request.getParameter("uname");
                hs.setAttribute("uname", name);
                hs.setAttribute("visit","1");
                out.println("<h1>Welcome first time</h1>");
            }
            else{
                out.println("<h1>Welcome Again</h1>");
                int visit = Integer.parseInt((String)hs.getAttribute("visit"))+1;
                out.println("<h1>You Visited"+ visit +"Times</h1>");
                hs.setAttribute("visit",""+ visit);
            }
            out.println("<h1>Your Session ID:"+hs.getId()+"</h1>");
            out.println("<h1>You Logged in at"+new java.util.Date(hs.getCreationTime())+"</h1>");
            
            out.println("<a href=page1>Click here to visit Page1</a>");
            out.println("<br>");
            out.println("<a href=page2>Click here to visit Page2</a>");
            out.println("<br>");
            out.println("<a href=page4>Click here to visit Page4</a>");
            out.println("<br>");
            out.println("<a href=LogOut>Click here to Terminate session</a>");
            out.println("<br>");
            
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}