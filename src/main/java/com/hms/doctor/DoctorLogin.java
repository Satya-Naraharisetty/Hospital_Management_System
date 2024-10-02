package com.hms.doctor;

import com.hms.DBConnection;
import com.hms.dao.DoctorDao;
import com.hms.entity.Doctor;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("Email");
        String password = req.getParameter("Password");

        HttpSession session = req.getSession();

        DoctorDao dao = null;
        try {
            dao = new DoctorDao(DBConnection.getDBConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Doctor doctor = dao.login(email, password);

        if (doctor != null) {
            session.setAttribute("DoctorObj", doctor);
            resp.sendRedirect("doctor/index.jsp");
        } else {
            session.setAttribute("errorMsg", "Invalid Email & Password");
            resp.sendRedirect("doctor_login.jsp");
        }

    }

}