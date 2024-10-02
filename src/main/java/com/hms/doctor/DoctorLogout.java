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
        session.removeAttribute("DoctorObj");
        session.setAttribute("successMsg", "Doctor Logout Successfully");
        resp.sendRedirect("doctor_login.jsp");

    }



}