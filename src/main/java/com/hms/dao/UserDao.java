package com.hms.dao;

import com.hms.entity.User;

import java.sql.*;

public class UserDao {
    private Connection conn;

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    public boolean UserRegister(User user) {
        boolean flag = false;
        try {
            String sql = "insert into user_details(Full_Name, /*Role,*/ Email, Password) values(?, /*?,*/ ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
//            String temp = user.getFull_Name();
//            ps.setString(1, temp);
            pstmt.setString(1, user.getFull_Name());
//            pstmt.setString(2, user.getRole());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            int i = pstmt.executeUpdate();

            if (i == 1) {
                flag = true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public User login(String email, String password) {
        User u = null;

        try {
            String sql = "select * from user_details where Email = ? and Password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                u = new User();
                u.setId(rs.getInt(1));
                u.setFull_Name(rs.getString(2));
                u.setEmail(rs.getString(3));
                u.setPassword(rs.getString(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }

    public boolean checkOldPassword(int userid, String oldPassword) {
        boolean f = false;

        try {
            String sql = "select * from user_details where Id = ? and Password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userid);
            ps.setString(2, oldPassword);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public boolean changePassword(int userId, String newPassword) {
        boolean flag = false;

        try {
            String sql = "update user_details set Password = ? where Id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setInt(2, userId);

            int i = ps.executeUpdate();
            if (i == 1) {
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean isEmailExists(String email) {
        boolean exists = false;
        try {
            String sql = "SELECT COUNT(*) FROM user_details WHERE Email = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }


}