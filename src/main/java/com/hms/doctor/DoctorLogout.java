package com.hms.doctor;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/doctorLogout")
public class DoctorLogout extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.removeAttribute("doctObj");
        session.setAttribute("succMsg", "Doctor Logout Sucessfully");
        resp.sendRedirect("doctor_login.jsp");

    }



}