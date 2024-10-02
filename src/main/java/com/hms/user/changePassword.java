package com.hms.user;
import com.hms.dao.UserDao;
import com.hms.DBConnection;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/userChangePassword")
public class changePassword extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int uid = Integer.parseInt(req.getParameter("uid"));
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");

        UserDao dao = new UserDao(DBConnection.getDBConnection());
        HttpSession session = req.getSession();

        if (dao.checkOldPassword(uid, oldPassword)) {

            if (dao.changePassword(uid, newPassword)) {
                session.setAttribute("succMsg", "Password Change Sucessfully");
                resp.sendRedirect("change_password.jsp");

            } else {
                session.setAttribute("errorMsg", "Something wrong on server");
                resp.sendRedirect("change_password.jsp");
            }

        } else {
            session.setAttribute("errorMsg", "Old Password Incorrect");
            resp.sendRedirect("change_password.jsp");
        }

    }

}