package com.hms.doctor;

import com.hms.DBConnection;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

import com.hms.dao.AppointmentDao;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            int did = Integer.parseInt(req.getParameter("did"));
            String comm = req.getParameter("comm");

            AppointmentDao dao = new AppointmentDao(DBConnection.getDBConnection());

            HttpSession session = req.getSession();

            if (dao.updateCommentStatus(id, did, comm)) {
                session.setAttribute("succMsg", "Comment Updated");
                resp.sendRedirect("doctor/patient.jsp");
            } else {
                session.setAttribute("errorMsg", "Something wrong on server");
                resp.sendRedirect("doctor/patient.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}