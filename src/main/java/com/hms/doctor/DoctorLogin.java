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

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        DoctorDao dao = null;
        try {
            dao = new DoctorDao(DBConnection.getDBConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Doctor doctor = dao.login(email, password);

        if (doctor != null) {
            session.setAttribute("doctorObj", doctor);
            resp.sendRedirect("doctor/index.jsp");
        } else {
            session.setAttribute("errorMsg", "invalid email & password");
            resp.sendRedirect("doctor_login.jsp");
        }

    }

}