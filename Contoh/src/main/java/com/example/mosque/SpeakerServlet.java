package com.example.mosque;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SpeakerServlet")
public class SpeakerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private SpeakerDao sd;
    public void init() {
        sd = new SpeakerDao();
    }

    public SpeakerServlet() {
        super();
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");

        String action = request.getParameter("action");
        try {
            switch (action) {
                case "addSpeaker":
                    addSpeaker(request, response);
                    break;
                case "deleteSpeaker":
                    deleteSpeaker(request,response);
                    break;
                case "updateSpeaker":
                    updateSpeaker(request,response);
                    break;
                case "cancel":
                    cancel(request, response);
                    break;

            }

        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }
    private void addSpeaker(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("speakerName");
        String phone = request.getParameter("speakerPhone");
        String edu = request.getParameter("speakerEdu");



        Speaker s = new Speaker();


        s.setSpeakerName(name);
        s.setSpeakerPhone(phone);
        s.setSpeakerEdu(edu);

        sd.addSpeaker(s);
        response.sendRedirect("Speaker.jsp");
    }
    private void deleteSpeaker(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("speakers"));
        sd.deleteSpeaker(id);
        response.sendRedirect("Speaker.jsp");
    }
    private void updateSpeaker(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("speakerName");
        String phone = request.getParameter("speakerPhone");
        String edu= request.getParameter("speakerEdu");

        Speaker s = new Speaker();
        s.setId(id);
        s.setSpeakerName(name);
        s.setSpeakerPhone(phone);
        s.setSpeakerEdu(edu);

        sd.updateSpeaker(s);

        response.sendRedirect("Speaker.jsp");
    }
    private void cancel(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        response.sendRedirect("Speaker.jsp");
    }

}