package com.example.mosque;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThemeServlet
 */
@WebServlet("/TopicServlet")
public class TopicServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private TopicDao td;
    public void init() {
        td = new TopicDao();
    }

    public TopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
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
                case "addTopic":
                    addTopic(request, response);
                    break;
                case "deleteTopic":
                    deleteTopic(request,response);
                    break;
                case "updateTopic":
                    updateTopic(request,response);
                    break;
                case "cancel":
                    cancel(request, response);
                    break;

            }

        } catch (SQLException e) {
            throw new ServletException(e);
        }

    }
    private void addTopic(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("topicName");
        String theme = request.getParameter("topicTheme");



        Topic t = new Topic();


        t.setTopicName(name);
        t.setTopicTheme(theme);


        td.addTopic(t);
        response.sendRedirect("Topic.jsp");
    }
    private void deleteTopic(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("topics"));
        td.deleteTopic(id);
        response.sendRedirect("Topic.jsp");
    }
    private void updateTopic(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String topic = request.getParameter("topicName");
        String theme = request.getParameter("topicTheme");

        Topic t=new Topic();
        t.setId(id);
        t.setTopicName(topic);
        t.setTopicTheme(theme);;

        td.updateTopic(t);
        response.sendRedirect("Topic.jsp");
    }
    private void cancel(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        response.sendRedirect("Topic.jsp");
    }
}