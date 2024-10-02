package com.hms.dao;

import com.hms.entity.Specialist;

import java.sql.*;
import java.util.*;

public class SpecialistDao {

    private Connection conn;

    public SpecialistDao(Connection conn) {
        super();
        this.conn = conn;
    }

    public boolean addSpecialist(String Specialist_Name) {
        boolean f = false;
        try {
            String sql = "insert into Specialist(Name) values (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Specialist_Name);

            int i = pstmt.executeUpdate();
            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    public ArrayList<Specialist> getAllSpecialist() {
        ArrayList<Specialist> list = new ArrayList<>();
        Specialist s = null;

        try {
            String sql = "select * from Specialist";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                s = new Specialist();
                s.setId(rs.getInt(1));
                s.setSpecialistName(rs.getString(2));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}