package com.hms.admin;

import com.hms.DBConnection;
import com.hms.dao.DoctorDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        DoctorDao dao = null;
        try {
            dao = new DoctorDao(DBConnection.getDBConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = req.getSession();

        if (dao.deleteDoctor(id)) {
            session.setAttribute("succMsg", "Doctor Delete Sucessfully..");
            resp.sendRedirect("admin/view_doctor.jsp");
        } else {
            session.setAttribute("errorMsg", "something wrong on server");
            resp.sendRedirect("admin/view_doctor.jsp");
        }


    }

}