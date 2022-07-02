package com.example.mosque;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnnouncementDao {
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
    public void addAnnouncement (Announcement anc) throws SQLException {

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement
                     ("insert into announcement(announcementpicture,announcementtitle,announcementdesc,announcementdate,announcementtime) values(?,?,?,?,?)"))
        {

            ps.setString(1, anc.getPicture());
            ps.setString(2, anc.getTitle());
            ps.setString(3, anc.getDescr());
            ps.setDate(4, anc.getDate());
            ps.setString(5, anc.getTime());
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean deleteAnnouncement(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from announcement where announcementid=?");) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public boolean updateAnnouncement(Announcement anc) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("update announcement set announcementpicture=?,announcementtitle=?,announcementdesc=?,announcementdate=?,announcementtime=? where announcementid=?");) {

            ps.setString(1, anc.getPicture());
            ps.setString(2, anc.getTitle());
            ps.setString(3, anc.getDescr());
            ps.setDate(4, anc.getDate());
            ps.setString(5, anc.getTime());
            ps.setInt(6, anc.getId());
            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}

