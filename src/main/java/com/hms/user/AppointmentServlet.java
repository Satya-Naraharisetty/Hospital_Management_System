package com.hms.user;

import com.hms.DBConnection;
import com.hms.entity.Appointment;
import com.hms.dao.AppointmentDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/appAppointment")
public class AppointmentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userId = Integer.parseInt(req.getParameter("UserId"));
        String fullname = req.getParameter("Full_Name");
        String gender = req.getParameter("Gender");
        String age = req.getParameter("Age");
        String appoint_date = req.getParameter("appoint_date");
        String email = req.getParameter("Email");
        String phno = req.getParameter("PhNo");
        String diseases = req.getParameter("Disease");
        int doctor_id = Integer.parseInt(req.getParameter("Doctor_Id"));
        String address = req.getParameter("Address");

        Appointment ap = new Appointment(userId, fullname, gender, age, appoint_date, email, phno, diseases, doctor_id,
                address, "Pending");

        AppointmentDao dao = null;
        try {
            dao = new AppointmentDao(DBConnection.getDBConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = req.getSession();

        if (dao.addAppointment(ap)) {
            session.setAttribute("successMsg", "Appointment Successfully");
            resp.sendRedirect("user_appointment.jsp");
        } else {
            session.setAttribute("errorMsg", "Something wrong on server");
            resp.sendRedirect("user_appointment.jsp");
        }

    }

}