package com.example.mosque;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/StaffServlet")
public class StaffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private StaffDao sd;
	    public void init() {
	        sd = new StaffDao();
	    }
    
    public StaffServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		  String action = request.getParameter("action");

	        try {
	            switch (action) {
	                case "logout":
	                    logout(request, response);
	                    break;
	              
	            }

	        } catch (SQLException e) {
	            throw new ServletException(e);
	        }
		
	}
	private void logout(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
		  HttpSession session = request.getSession();
	        session.removeAttribute("staffid");
	        session.removeAttribute("staffname");
	        session.invalidate();
	        response.sendRedirect("index.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");

	        String action = request.getParameter("action");

	        try {
	            switch (action) {
	                case "login":
	                    login(request, response);
	                    break;
	              
	            }

	        } catch (SQLException e) {
	            throw new ServletException(e);
	        }
	       
	}
    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {

            Class.forName("org.postgresql.Driver");
        	String dbURL = "jdbc:postgresql://ec2-3-234-131-8.compute-1.amazonaws.com/d19mjejga32und";
    	    String user = "ocetdbspxioaak";
    	    String pass = "046d2c84c24f70b0f1b8cf071d97fe00efe0700a42909777604ad0298b5bec3e";
            Connection con = DriverManager.getConnection(dbURL, user, pass);

            String sql  = "SELECT * FROM staffs";

            if (con != null){
                DatabaseMetaData dm = con.getMetaData();


                Statement statement = con.createStatement();
                ResultSet res = statement.executeQuery(sql);

                while (res.next()){
                    if(username.equals(res.getString("staffusername")) && password.equals(res.getString("staffpassword")))
                    {

                        Staff stf = new Staff();

                        stf.setId(res.getInt(1));
                        stf.setStaffName(res.getString(2));;
                        stf.setStaffUsername(res.getString(3));
                        stf.setStaffPassword(res.getString(4));


                        session.setAttribute("staffid", stf.getId());
                        session.setAttribute("staffname", stf.getStaffName());
            	        session.setAttribute("staffusername",stf.getStaffUsername());
            	        session.setAttribute("staffpassword",stf.getStaffPassword());
         	     
                        response.sendRedirect("Speaker.jsp");


                    }else{
                    }

                }out.print("Invalid Username/Password");

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}