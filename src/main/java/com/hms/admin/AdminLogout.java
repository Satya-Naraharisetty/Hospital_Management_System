package com.hms;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/adminLogout")
public class AdminLogout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.removeAttribute("adminObj");
        session.setAttribute("succMsg", "Admin Logout Sucessfully");
        resp.sendRedirect("admin_login.jsp");

    }

}