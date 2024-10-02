package com.hms.user;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/userLogout")
public class UserLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.removeAttribute("userObj");
        session.setAttribute("succMsg", "User Logout Sucessfully");
        resp.sendRedirect("user_login.jsp");

    }

}