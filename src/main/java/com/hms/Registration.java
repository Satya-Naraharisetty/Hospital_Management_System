package com.hms;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
//    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String Full_Name = request.getParameter("Full_Name");
            String Role = request.getParameter("Role");
            String Email = request.getParameter("Email");
            String Password = request.getParameter("Password");

            UserData userData = new UserData(Full_Name, Role, Email, Password);
            UserDao dao = new UserDao(DBConnection.getDBConnection());
            dao.UserRegister(userData);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}