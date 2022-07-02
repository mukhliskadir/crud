package com.example.mosque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static java.lang.System.out;

public class StaffDao {
    String dbURL = "jdbc:postgresql://ec2-3-234-131-8.compute-1.amazonaws.com/d19mjejga32und";
    String user = "ocetdbspxioaak";
    String pass = "046d2c84c24f70b0f1b8cf071d97fe00efe0700a42909777604ad0298b5bec3e";

    protected Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;

    }
    public void addStaff (Staff stf,String imageFileName,String urlPathforDB) throws SQLException {

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement
                     ("insert into staffs(staff_name,staff_phoneno,staff_username,staff_password,staff_pic,staff_role) values(?,?,?,?,?,?)"))
        {

            ps.setString(1, stf.getStaffName());
            ps.setString(2, stf.getStaffPhone());
            ps.setString(3, stf.getStaffUsername());
            ps.setString(4, stf.getStaffPassword());
            ps.setString(5, stf.getStaffPic());
            ps.setString(6, stf.getStaffRole());

            out.println(ps);
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}