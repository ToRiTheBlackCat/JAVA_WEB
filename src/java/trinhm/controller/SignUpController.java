/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinhm.controller;

import Registration.RegistrationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC
 */
public class SignUpController extends HttpServlet {

    private final String LOGIN = "login.html";
    private final String SIGNUPFAIL = "SignUp.jsp";

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String url = "";
            url = SIGNUPFAIL;
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confpass = request.getParameter("txtConfirm");
            String fullname = request.getParameter("txtName");
            String role_raw = request.getParameter("chkRole");
            int role = 0;
            if (role_raw != null) {
                role = 1;
            } else if (role_raw == null) {
                role = 0;
            }

            boolean isError = false;
            SignUpError errors = new SignUpError();
            try {
                if (username.trim().length() < 6 || username.trim().length() > 12) {
                    isError = true;
                    errors.setUsernameLengthError("** Username length must be 6 to 12 characters");
                }
                if (password.trim().length() < 8 || password.trim().length() > 20) {
                    isError = true;
                    errors.setPasswordLengthError("** Password length must be 8 to 20 characters");
                }
                if (!password.trim().equals(confpass.trim())) {
                    isError = true;
                    errors.setConfirmNoMatch("** Confirm is not match");
                }
                if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                    isError = true;
                    errors.setFullNameLengthError("** Fullname length must be 2 to 50 characters");
                }
                if (isError) {
                    request.setAttribute("SIGNUPERROR", errors);
                    
                } else {
                    RegistrationDAO dao = new RegistrationDAO();
                    boolean result = dao.SignUp(username, password, fullname, role);
                    if (result) {
                        url = LOGIN;
                    } else {
                        url = SIGNUPFAIL;
                    }
                }

            } catch (SQLException e) {
                isError = true;
                
                errors.setUsernameIsExisted("** Username is existed");
                request.setAttribute("SIGNUPERROR", errors);
                e.printStackTrace();
            } finally {
                request.getRequestDispatcher(url).forward(request,response);
            }
           

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
