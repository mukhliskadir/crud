package com.example.mosque;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AnnouncementServlet
 */
@WebServlet("/AnnouncementServlet")
public class AnnouncementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AnnouncementDao ad;
    public void init() {
        ad = new AnnouncementDao();
    }


    public AnnouncementServlet() {
        super();
    }

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String action = request.getParameter("action");
        try {
            switch (action) {
                case "addAnnouncement":
                    addAnnouncement(request, response);
                    break;
                case "deleteAnnouncement":
                    deleteAnnouncement(request,response);
                    break;
                case "updateAnnouncement":
                    updateAnnouncement(request,response);
                    break;
                case "cancel":
                    cancel(request, response);
                    break;

            }

        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }
    private void addAnnouncement(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String pic = request.getParameter("aPicture");
        String title = request.getParameter("aTitle");
        String desc = request.getParameter("aDesc");
        String date = request.getParameter("aDate");
        String timme = request.getParameter("aTime");



        Announcement anc = new Announcement();

        anc.setPicture(pic);
        anc.setTitle(title);
        anc.setDescr(desc);
        anc.setDate(Date.valueOf(date));
        anc.setTime(timme);

        ad.addAnnouncement(anc);
        response.sendRedirect("Announcement.jsp");
    }
    private void deleteAnnouncement(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("aId"));
        ad.deleteAnnouncement(id);
        response.sendRedirect("Announcement.jsp");
    }
    private void updateAnnouncement(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String pic = request.getParameter("aPicture");
        String title = request.getParameter("aTitle");
        String desc = request.getParameter("aDesc");
        String date = request.getParameter("aDate");
        String timme = request.getParameter("aTime");

        Announcement anc = new Announcement();
        anc.setId(id);
        anc.setPicture(pic);
        anc.setTitle(title);
        anc.setDescr(desc);
        anc.setDate(Date.valueOf(date));
        anc.setTime(timme);

        ad.updateAnnouncement(anc);

        response.sendRedirect("Announcement.jsp");
    }

    private void cancel(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        response.sendRedirect("Announcement.jsp");
    }
}
