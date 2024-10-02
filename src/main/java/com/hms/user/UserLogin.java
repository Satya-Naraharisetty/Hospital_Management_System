package com.hms.user;

import com.hms.DBConnection;
import com.hms.entity.User;
import com.hms.dao.UserDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("Email");
        String password = req.getParameter("Password");

        HttpSession session = req.getSession();

        UserDao dao = null;
        try {
            dao = new UserDao(DBConnection.getDBConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        User user = dao.login(email, password);

        if (user != null) {
            session.setAttribute("UserObj", user);
            resp.sendRedirect("index.jsp");
        } else {
            session.setAttribute("errorMsg", "Invalid Email & Password");
            resp.sendRedirect("user_login.jsp");
        }

    }

}