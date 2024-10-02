package com.hms.admin;

import com.hms.DBConnection;
import com.hms.dao.DoctorDao;
import com.hms.entity.Doctor;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String Full_Name = req.getParameter("Full_Name");
            String DOB = req.getParameter("DOB");
            String Qualification = req.getParameter("Qualification");

            String Speciality = req.getParameter("Specialist");

            String Email = req.getParameter("Email");
            String Mobile_No = req.getParameter("Mobile_No");
            String Password = req.getParameter("Password");

            Doctor d = new Doctor(Full_Name, DOB, Qualification, Speciality, Email, Mobile_No, Password);
            DoctorDao dao = new DoctorDao(DBConnection.getDBConnection());
            HttpSession session = req.getSession();

            if (dao.registerDoctor(d)) {
                session.setAttribute("successMsg", "Doctor Added Successfully..");
                resp.sendRedirect("admin/doctor.jsp");
            } else {
                session.setAttribute("errorMsg", "something wrong on server");
                resp.sendRedirect("admin/doctor.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}