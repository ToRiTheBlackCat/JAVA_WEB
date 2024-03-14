package trinhm.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
@WebServlet(urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private final String LOGINCONTROLLER = "LoginController";
    private final String DELETECONTROLLER = "DeleteController";
    private final String SEARCHCONTROLLER = "SearchController";
    private final String UPDATECONTROLLER = "UpdateController";
    private final String ADDTOCARTCONTROLLER = "AddToCartController";
    private final String VIEWCARTCONTROLLER = "ViewCart.jsp";
    private final String REMOVEITEMCONTROLLER = "RemoveItemCotroller";
    private final String SIGNUPCONTROLLER = "SignUpController";

    


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
            out.println("<title>Servlet MainController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MainController at " + request.getContextPath() + "</h1>");
            
            String url = "";
            String button = request.getParameter("btAction");
            if( button.equals("Login")){
                url = LOGINCONTROLLER;
            } else if(button.equals("Search")){
                url = SEARCHCONTROLLER;
            } else if ( button.equals("Delete") ){
                url = DELETECONTROLLER;
            } else if ( button.equals("Update") ){
                url = UPDATECONTROLLER;
            } else if ( button.equals("Add Book To Cart") ){
                url = ADDTOCARTCONTROLLER;
            } else if ( button.equals("View Cart") ){
                url = VIEWCARTCONTROLLER;
            }else if ( button.equals("Remove") ){
                url = REMOVEITEMCONTROLLER;
            }else if ( button.equals("Sign Up") ){
                url = SIGNUPCONTROLLER;
            }
                
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
                    
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
