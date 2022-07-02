<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<!DOCTYPE html>
<html>
<head>
  <title></title>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/style.css">
  <script src="https://kit.fontawesome.com/9bff21277a.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  
</head>
<body>
<%
Class.forName("org.postgresql.Driver");
String dbURL = "jdbc:postgresql://ec2-3-234-131-8.compute-1.amazonaws.com/d19mjejga32und";
String user = "ocetdbspxioaak";
String pass = "046d2c84c24f70b0f1b8cf071d97fe00efe0700a42909777604ad0298b5bec3e";
String id=request.getParameter("id");
int num=Integer.parseInt(id);
String sql= "select * from announcement where announcementid='"+num+"'";
Connection con=DriverManager.getConnection(dbURL, user, pass);
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(sql);
while(rs.next())
{
%>
<div class="sidebar">
    <div class="img"><img src="IMG/contoh.jpg" style="width:120px;height: 120px; margin-top: 50px;margin-left: 40px;border-radius: 50%;border: 2px solid black;">
    </div>
    <%     Object name = session.getAttribute("staffname"); %>
    <div class="profname" style="margin-left: 10px;margin-top: -35px;font-weight: bold;font-size: 20px;margin-bottom: 20px;margin-right: 30px;text-align:center;"><%=name %></div>
    <button type="urusakaun" href="urusakaun.html" value="urusakaun" style="margin-left: 40px;margin-bottom: 40px;">URUS AKAUN</button>
    <a  class="active" href="Speaker.jsp"><i class="fa-solid fa-user"></i>  Penceramah</a>
    <a href="Topic.jsp"><i class="fa-solid fa-moon"></i>  Tajuk</a>
    <a  href="Jadual.jsp"><i class="fa-solid fa-calendar-days"></i>  Jadual</a>
    <a class="active" href="Announcement.jsp"><i class="fa-solid fa-volume-high"></i> Pengumuman</a>
    <a href="laporan.html"><i class="fa-solid fa-print"></i>  Laporan</a>
    <form method="get" action="StaffServlet">
        <input type="hidden" name="action" value="logout">
        <button id="logot" type="logout">LOGOUT</button>
    </form>
</div>

<%@include file="navbar.jsp"%>

<div class="content">
  
  <br>
  <h2>PENCERAMAH</h2>   

 
        
      <div class="ANNOUNCEMENTFORM">
         <form class="announcement" method="post">
      <div class="dataa">
     <label>   Poster </label>
        <input type="file"  accept="image/*" name="aPicture" id="file"  onchange="loadFile(event)" >
    </div>
    <div class="dataa">
     <label>   Tajuk </label>
        <input type="text" name="aTitle" value='<%=rs.getString("announcementtitle") %>' >
    </div>
    <div class="dataa">
    <label>    Tarikh</label>
        <input type="date" name="aDate" value='<%=rs.getString("announcementdate") %>'>
    </div>
    <div class="dataa">
    <label>    Masa</label>
        <input type="time" name="aTime" value='<%=rs.getString("announcementtime") %>'>
  	</div><div class="dataa">
      <label>  Maklumat</label>
        <textarea type="text" name="aDesc" style="height:200px;" > <%=rs.getString("announcementdesc") %></textarea>
    </div>
        <div class="dataa">
    <input type="hidden" name="id" value='<%=rs.getString("announcementid") %>'/>  </div>
  
    <%} %>
    
     <div id="mybutton" class="button">
             <button type="cancel" name="action"  value="cancel" formaction="AnnouncementServlet">CANCEL</button>
          <input type="hidden" name="action" value="updateAnnouncement">
                        <button type="submit" formaction="AnnouncementServlet">Update</button>
                         </div>
  </form>
<br><br>
 </div>


           <div class="ANNOUNCEMENTFORM">
 <div class="divposter">
 	<div class="dataa">
      <p><img id="output" style="height:400px;" /></p>
    </div>
      </div>
      </div>

           </div>
          
<br><br><br>

 

</body>
<script type="text/javascript">{var dt = new Date();
document.getElementById("datetime").innerHTML = dt.toLocaleString();}

 function functionAlert(msg, myYes) {
        
            var confirmBox = $("#confirm");
            confirmBox.find(".message").text(msg);
            confirmBox.find(".yes").unbind().click(function() {
              alert("Success! Changes has been saved succesfully!");
              window.location.href = "cth.html";
               confirmBox.hide();
            });
            confirmBox.find(".no").unbind().click(function() {
               confirmBox.hide();
            });
            confirmBox.find(".yes").click(myYes);
            confirmBox.show();}
 var loadFile = function(event) {
	  var image = document.getElementById('output');
	  image.src = URL.createObjectURL(event.target.files[0]);
	};

</script>
<style type="text/css">
  h3{color: black;}
  #myInput{display: inline-block;width: 500px ;}
    .ANNOUNCEMENTFORM{display:inline-block;}
  .divposter{padding:1px;background-color:#7F7F7F;height:440px;width:660px; box-shadow: 0px 5px 10px 0px rgba(0, 0, 0, 0.5);}
  #output{max-width:600px;}
</style>
</html>