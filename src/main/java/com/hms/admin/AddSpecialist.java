package com.hms.admin;

import com.hms.DBConnection;
import com.hms.dao.SpecialistDao;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/addSpecialist")
public class AddSpecialist extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String specName = req.getParameter("specName");

        SpecialistDao dao;
        try {
            dao = new SpecialistDao(DBConnection.getDBConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        boolean f = dao.addSpecialist(specName);

        HttpSession session = req.getSession();

        if (f) {
            session.setAttribute("successMsg", "Specialist Added");
            resp.sendRedirect("admin/index.jsp");
        } else {
            session.setAttribute("errorMsg", "something wrong on server");
            resp.sendRedirect("admin/index.jsp");
        }

    }

}