package com.hms.doctor;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

import com.hms.dao.DoctorDao;

@WebServlet("/doctorChangePassword")
public class DoctorPasswordChange extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int uid = Integer.parseInt(req.getParameter("uid"));
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");

        DoctorDao dao = new DoctorDao(DBConnect.getConn());
        HttpSession session = req.getSession();

        if (dao.checkOldPassword(uid, oldPassword)) {

            if (dao.changePassword(uid, newPassword)) {
                session.setAttribute("succMsg", "Password Change Sucessfully");
                resp.sendRedirect("doctor/edit_profile.jsp");

            } else {
                session.setAttribute("errorMsg", "Something wrong on server");
                resp.sendRedirect("doctor/edit_profile.jsp");
            }

        } else {
            session.setAttribute("errorMsg", "Old Password Incorrect");
            resp.sendRedirect("doctor/edit_profile.jsp");
        }

    }
}