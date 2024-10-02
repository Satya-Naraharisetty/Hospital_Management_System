package com.hms.doctor;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

import com.dao.DoctorDao;
import com.entity.Doctor;

@WebServlet("/doctorUpdateProfile")
public class EditProfile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String fullName = req.getParameter("fullname");
            String dob = req.getParameter("dob");
            String qualification = req.getParameter("qualification");
            String spec = req.getParameter("spec");
            String email = req.getParameter("email");
            String mobno = req.getParameter("mobno");

            int id = Integer.parseInt(req.getParameter("id"));

            Doctor d = new Doctor(id, fullName, dob, qualification, spec, email, mobno, "");

            DoctorDao dao = new DoctorDao(DBConnect.getConn());
            HttpSession session = req.getSession();

            if (dao.editDoctorProfile(d)) {
                Doctor updateDoctor = dao.getDoctorById(id);
                session.setAttribute("succMsgd", "Doctor Update Sucessfully..");
                session.setAttribute("doctObj", updateDoctor);
                resp.sendRedirect("doctor/edit_profile.jsp");
            } else {
                session.setAttribute("errorMsgd", "something wrong on server");
                resp.sendRedirect("doctor/edit_profile.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}