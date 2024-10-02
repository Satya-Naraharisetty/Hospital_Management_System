package com.hms;

import com.hms.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String Email = request.getParameter("Email");
            String Password = request.getParameter("Password");

            HttpSession session = request.getSession();
            if (Email.equals("admin@gmail.com") && Password.equals("admin")) {
                session.setAttribute("admin", new User());
                response.sendRedirect(" admin/index.jsp");
            }
            else {
                request.setAttribute("errorMessage", "Check your credentials");
                request.getRequestDispatcher("admin_login.jsp").forward(request, response);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}