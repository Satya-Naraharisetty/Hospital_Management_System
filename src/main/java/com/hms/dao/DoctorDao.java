package com.hms.dao;
import com.hms.entity.Doctor;
import java.sql.*;
import java.util.*;

public class DoctorDao {
    private Connection conn;

    public DoctorDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean registerDoctor(Doctor d) {
        boolean flag = false;

        try {
            String sql = "insert into Doctor(Full_Name, DOB, Qualification, Specialist, Email, Mobile_No, Password) values(?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getFull_Name());
            ps.setString(2, d.getDob());
            ps.setString(3, d.getQualification());
            ps.setString(4, d.getSpecialist());
            ps.setString(5, d.getEmail());
            ps.setString(6, d.getMobNo());
            ps.setString(7, d.getPassword());

            int i = ps.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public List<Doctor> getAllDoctor() {
        List<Doctor> list = new ArrayList<Doctor>();
        Doctor d = null;
        try {

            String sql = "select * from doctor order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setId(rs.getInt(1));
                d.setFull_Name(rs.getString(2));
                d.setDob(rs.getString(3));
                d.setQualification(rs.getString(4));
                d.setSpecialist(rs.getString(5));
                d.setEmail(rs.getString(6));
                d.setMobNo(rs.getString(7));
                d.setPassword(rs.getString(8));
                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Doctor getDoctorById(int id) {

        Doctor d = null;
        try {

            String sql = "select * from doctor where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                d = new Doctor();
                d.setId(rs.getInt(1));
                d.setFull_Name(rs.getString(2));
                d.setDob(rs.getString(3));
                d.setQualification(rs.getString(4));
                d.setSpecialist(rs.getString(5));
                d.setEmail(rs.getString(6));
                d.setMobNo(rs.getString(7));
                d.setPassword(rs.getString(8));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    public boolean updateDoctor(Doctor d) {
        boolean f = false;

        try {
            String sql = "update Doctor set Full_Name=?, DOB=?, Qualification=?, Specialist=?, Email=?, Mobile_No=?, Password=? where Id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, d.getFull_Name());
            pstmt.setString(2, d.getDob());
            pstmt.setString(3, d.getQualification());
            pstmt.setString(4, d.getSpecialist());
            pstmt.setString(5, d.getEmail());
            pstmt.setString(6, d.getMobNo());
            pstmt.setString(7, d.getPassword());
            pstmt.setInt(8, d.getId());
            int i = pstmt.executeUpdate();

            if (i == 1) {
                f = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public boolean deleteDoctor(int id) {
        boolean f = false;
        try {
            String sql = "delete from doctor where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int i = ps.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public Doctor login(String email, String psw) {
        Doctor d = null;
        try {

            String sql = "select * from Doctor where email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, psw);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setId(rs.getInt(1));
                d.setFull_Name(rs.getString(2));
                d.setDob(rs.getString(3));
                d.setQualification(rs.getString(4));
                d.setSpecialist(rs.getString(5));
                d.setEmail(rs.getString(6));
                d.setMobNo(rs.getString(7));
                d.setPassword(rs.getString(8));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return d;
    }

    public int countDoctor() {
        int i = 0;
        try {
            String sql = "select * from doctor";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    public int countAppointment() {
        int i = 0;
        try {
            String sql = "select * from appointment";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    public int countAppointmentByDoctorId(int did) {
        int i = 0;
        try {
            String sql = "select * from appointment where doctor_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, did);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    public int countUSer() {
        int i = 0;
        try {
            String sql = "select * from user_details";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    public int countSpecialist() {
        int i = 0;
        try {
            String sql = "select * from Specialist";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    public boolean checkOldPassword(int userid, String oldPassword) {
        boolean flag = false;

        try {
            String sql = "select * from Doctor where Id=? and Password=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userid);
            pstmt.setString(2, oldPassword);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean changePassword(int userId, String newPassword) {
        boolean flag = false;

        try {
            String sql = "update doctor set Password=? where Id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setInt(2, userId);

            int i = pstmt.executeUpdate();
            if (i == 1) {
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean editDoctorProfile(Doctor d) {
        boolean flag = false;

        try {
            String sql = "update Doctor set Full_Name=?, DOB=?, Qualification=?, Specialist=?, Email=?, Mobile_No=? where Id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, d.getFull_Name());
            pstmt.setString(2, d.getDob());
            pstmt.setString(3, d.getQualification());
            pstmt.setString(4, d.getSpecialist());
            pstmt.setString(5, d.getEmail());
            pstmt.setString(6, d.getMobNo());
            pstmt.setInt(7, d.getId());
            int i = pstmt.executeUpdate();

            if (i == 1) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    public List<Doctor> searchDoctor(String ch) {
        List<Doctor> list = new ArrayList<Doctor>();
        Doctor d = null;
        try {
            String sql = "select * from Doctor where Full_Name like ? or Specialist like ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + ch + "%");
            pstmt.setString(2, "%" + ch + "%");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                d = new Doctor();
                d.setId(rs.getInt(1));
                d.setFull_Name(rs.getString(2));
                d.setDob(rs.getString(3));
                d.setQualification(rs.getString(4));
                d.setSpecialist(rs.getString(5));
                d.setEmail(rs.getString(6));
                d.setMobNo(rs.getString(7));
                d.setPassword(rs.getString(8));
                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}