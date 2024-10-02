package com.hms.admin;

import com.hms.dao.DoctorDao;
import com.hms.DBConnection;
import com.hms.entity.Doctor;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/updateDoctor")
public class UpdateDoctor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String fullName = req.getParameter("fullname");
            String dob = req.getParameter("dob");
            String qualification = req.getParameter("qualification");
            String spec = req.getParameter("spec");
            String email = req.getParameter("email");
            String mobno = req.getParameter("mobno");
            String password = req.getParameter("password");

            int id = Integer.parseInt(req.getParameter("id"));

            Doctor d = new Doctor(fullName, dob, qualification, spec, email, mobno, password);

            DoctorDao dao = new DoctorDao(DBConnection.getDBConnection());
            HttpSession session = req.getSession();

            if (dao.updateDoctor(d)) {
                session.setAttribute("successMsg", "Doctor Update Sucessfully..");
                resp.sendRedirect("admin/view_doctor.jsp");
            } else {
                session.setAttribute("errorMsg", "something wrong on server");
                resp.sendRedirect("admin/view_doctor.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}