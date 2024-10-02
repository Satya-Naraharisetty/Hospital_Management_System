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

            // Handling existing users
            UserData userData = new UserData(Full_Name, Role, Email, Password);
            UserDao dao = new UserDao(DBConnection.getDBConnection());
            if (dao.isEmailExists(Email)) {
                request.setAttribute("User already exists", "Email already exists, Please login or use a different account!"); // Set the error message
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
                return;
            }

            // Check if passwords match

            if (!Password.equals(confirmPassword)) {
                request.setAttribute("Password Mismatch", "Passwords do not match!");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
                return;
            }

            // Proceed with registration if passwords match

//            HttpSession session = request.getSession();
            boolean flag = dao.UserRegister(userData);

            if (flag) {
                System.out.println("Data Insertion/Registration Successful");
//                session.setAttribute("successMessage", "Registration successful! Please login.");
//                response.sendRedirect("login.jsp");
                // After successful registration
                request.setAttribute("successMessage", "Registration successful! Please login.");
                request.getRequestDispatcher("SignUp.jsp").forward(request, response);
//                response.sendRedirect("login.jsp"); // Redirect to login page after success
            } else {
                System.out.println("Data Insertion/Registration Failed");
//                session.setAttribute("FM", "Registration Failed");
//                session.setAttribute("errorMessage", "Email already exists.");
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
