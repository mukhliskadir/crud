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
<div class="sidebar">
    <div class="img"><img src="IMG/contoh.jpg" style="width:120px;height: 120px; margin-top: 50px;margin-left: 40px;border-radius: 50%;border: 2px solid black;">
    </div>
    <%     Object name = session.getAttribute("staffname"); %>
    <div class="profname" style="margin-left: 10px;margin-top: -35px;font-weight: bold;font-size: 20px;margin-bottom: 20px;margin-right: 30px;text-align:center;"><%=name %></div>
    <button type="urusakaun" href="urusakaun.html" value="urusakaun" style="margin-left: 40px;margin-bottom: 40px;">URUS AKAUN</button>
    <a  class="active" href="Speaker.jsp"><i class="fa-solid fa-user"></i>  Penceramah</a>
    <a href="Topic.jsp"><i class="fa-solid fa-moon"></i>  Tajuk</a>
    <a  href="Jadual.jsp"><i class="fa-solid fa-calendar-days"></i>  Jadual</a>
    <a href="Announcement.jsp"><i class="fa-solid fa-volume-high"></i> Pengumuman</a>
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
    <div class="custform">
        <form class="speaker" method="post" action="SpeakerServlet">
            <div class="dataa">
                <label>   Name </label>
                <input type="text" name="speakerName" value="" required oninvalid="this.setCustomValidity('Sila masukkan nama')" oninput="setCustomValidity('')">
            </div>
            <div class="dataa">
                <label>  Phone</label>
                <input type="text" name="speakerPhone" value="">
            </div>
            <div class="dataa">
                <label>    Education</label>
                <input type="text" name="speakerEdu" value="">
            </div>
            <div id="mybutton" class="button">
                <button type="cancel" name="action"  value="cancel" formaction="SpeakerServlet">BATAL</button>
                <input type="hidden" name="action" value="addSpeaker">
                <button type="submit" class="button button1" name="submit" >TAMBAH</button><br><br>
            </div>
        </form>
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

</script>
<style type="text/css">
    h3{color: black;}
    #myInput{display: inline-block;width: 500px ;}
</style>
</html>