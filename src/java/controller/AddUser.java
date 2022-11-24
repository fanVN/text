/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author DELL
 */
@WebServlet(name = "AddUser", urlPatterns = {"/AddUser"})
public class AddUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("forward".equals(action)) {
            RequestDispatcher rd = request.getRequestDispatcher("themUser.jsp");
            rd.include(request, response);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        UserDAO userDAO = new UserDAO();
        if ("add".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            RequestDispatcher rd = null;
            User user = UserDAO.selectUser(username);
            if (user != null) {
                request.setAttribute("msg_error_username", "user da ton tai");
                request.setAttribute("msg_error_email", "email da ton tai");
                rd = getServletContext().getRequestDispatcher("/themUser.jsp");
                rd.forward(request, response);
            } else {
                int result = userDAO.insertUser(username, password, email, phone);
                if (result > 0) {
                    rd = request.getRequestDispatcher("ListUserServlet");
                    rd.forward(request, response);
                } else {
                    String msg = "co loi khi add user";
                    request.setAttribute("msg_error", msg);
                    rd = request.getRequestDispatcher("themUser.jsp");
                    rd.forward(request, response);
                }
            }
        }
    }
}
