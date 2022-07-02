<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="css/style.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src="JS/script.js"></script>
      <title>MASJUD ABU UBAIDAH</title>
      <div class="headerr">
         <img src="logo.png" style="width: 600px;max-height: 130px;">
         <button class="account" name="login" type="login" onclick="signAlert()">LOG IN</button>
      </div>
   </head>
   <body>
      <div id="navbar">
         <a class="active" href="#home">SCHEDULE</a>
         <a href="#contact">ANNOUNCEMENT</a>
      </div>
  
      
      <form id="signform" action="StaffServlet" method="POST">
         <div class="mssg">
            SIGN IN<br>
            <input type="text" name="username" placeholder="Enter Username" value="" required>
            <input type="password" name="password" placeholder="Enter Password" value="" required>
            <button type="cancel" class="cancel" onclick="location.href='index.jsp'">CANCEL</button>
            <input type="hidden" name="action" value="login">
            <button type="signin" class="signIn" name="submit" >SIGN IN</button>
         </div>
      </form>
      </table>
   </body>
   <style >
      body{margin: 0;font-family: Arial, Helvetica, sans-serif;height: 1500px;}
      .headerr {height: 110px; background-color: rgba(0, 0, 0, 0.4);overflow: hidden;padding-right: 30px;}
      .headerr img{float: left;}
      .account{float: right;margin-top: 25px;margin-right: 3px;}
      #navbar{background-color: #d9870d;height: 50px;overflow: hidden;list-style: none;text-align: center;padding-left: 41%;}
      .sticky {position: fixed;top: 0;width: 100%;}
      #navbar a {text-align: center;float: left;text-decoration: none;padding: 13px;color: black;}
      a.active{ background-color: rgba(219, 177, 61, 0.5);}
      a:hover{background-color: rgba(0, 0, 0, 0.2);}
      .sticky + .content {padding-top: 60px;}
      #slideshow .search{position: absolute;top: 50%;left: 50%;transform: translate(-50%, -50%); width: 800px;height: 300px;background-color: rgba(255, 255, 255, 0.9);border-radius: 25px;border: 4px solid #d9870d;text-align: center;padding: 10px;}
      #slideshow{overflow: hidden;}
      #signform {display: none;background-color:#ffbe14;color: #000000;border: 5px solid black ;border-radius: 25px;padding: 15px;position: fixed;width: 500px;height: 250px;left: 35%;top: 250px;box-sizing: border-box;text-align: center;}
      #signform .mssg,#signupform .msssg {
      font-size: 35px;
      }
      #signform button,#signupform button{padding-bottom: 10px;}
      h6{font-size: 5	0px;}
      .marque{display-block;background-color: #d9870d;height: 50px;overflow: hidden;list-style: none;text-align: center;padding-left: 41%;  position: fixed;
      bottom: 0;width:100%
      }
   </style>
   <script >
      window.onscroll = function() {myFunction()};
      
      var navbar = document.getElementById("navbar");
      var sticky = navbar.offsetTop;
      
      function myFunction() {
       if (window.pageYOffset >= sticky) {
         navbar.classList.add("sticky")
       } else {
         navbar.classList.remove("sticky");
       }
      }
      function signAlert(msg, myYes) {
      		
                 var confirmBox = $("#signform");
                 confirmBox.find(".mssg").text(msg);
                 confirmBox.find(".signIn").unbind().click(function() {
                 
                    confirmBox.hide();
                 });
                 confirmBox.find(".cancel").unbind().click(function() {
                    confirmBox.hide();
                 });
                 confirmBox.find(".signIn").click(myYes);
                 confirmBox.show();}
      
   </script>
</html>