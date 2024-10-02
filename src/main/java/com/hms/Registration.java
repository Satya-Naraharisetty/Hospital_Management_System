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
            String confirmPassword = request.getParameter("confirmPassword");

            // Check if passwords match
            if (!Password.equals(confirmPassword)) {
                request.setAttribute("errorMessage", "Passwords do not match!");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
                return;
            }

            // Proceed with registration if passwords match
            UserData userData = new UserData(Full_Name, Role, Email, Password);
            UserDao dao = new UserDao(DBConnection.getDBConnection());
            boolean flag = dao.UserRegister(userData);

            if (flag) {
                System.out.println("Data Insertion/Registration Successful");
//                response.sendRedirect("login.jsp"); // Redirect to login page after success
            } else {
                System.out.println("Data Insertion/Registration Failed");
                request.setAttribute("errorMessage", "Registration failed! Please try again.");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Something went wrong!");
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        }
    }
}
