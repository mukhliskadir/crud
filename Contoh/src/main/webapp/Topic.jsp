<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
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
<sql:setDataSource var="ic" driver="org.postgresql.Driver"
                   url="jdbc:postgresql://ec2-3-234-131-8.compute-1.amazonaws.com/d19mjejga32und"
                   user = "ocetdbspxioaak"
                   password="046d2c84c24f70b0f1b8cf071d97fe00efe0700a42909777604ad0298b5bec3e"/>
<sql:query dataSource="${ic}" var="oc">
    SELECT row_number() over () "rank",topicid,topicname,topictheme from topic where topicid>0
</sql:query>

<div class="sidebar">
    <div class="img"><img src="IMG/contoh.jpg" style="width:120px;height: 120px; margin-top: 50px;margin-left: 40px;border-radius: 50%;border: 2px solid black;">
    </div>
    <%     Object name = session.getAttribute("staffname"); %>
    <div class="profname" style="margin-left: 10px;margin-top: -35px;font-weight: bold;font-size: 20px;margin-bottom: 20px;margin-right: 30px;text-align:center;"><%=name %></div>
    <button type="urusakaun" href="urusakaun.html" value="urusakaun" style="margin-left: 40px;margin-bottom: 40px;">URUS AKAUN</button>
    <a   href="Speaker.jsp"><i class="fa-solid fa-user"></i>  Penceramah</a>
    <a class="active" href="Topic.jsp"><i class="fa-solid fa-moon"></i>  Tajuk</a>
    <a  href="Jadual.jsp"><i class="fa-solid fa-calendar-days"></i>  Jadual</a>
    <a href="Announcement.jsp"><i class="fa-solid fa-volume-high"></i> Pengumuman</a>
    <a href="laporan.html"><i class="fa-solid fa-print"></i>  Laporan</a>
    <form method="get" action="StaffServlet">
        <input type="hidden" name="action" value="logout">
        <button id="logot" type="logout">LOGOUT</button>
    </form>
</div>
<%@include file="navbar.jsp"%>
<div class="content" >
    <br>
    <h2>TAJUK</h2>
    <div id="mybutton" class="button">
        <button class="add" type="add" value="add" onclick="location.href='addTopic.jsp'">TAMBAH</button>
    </div>
    <select name="topicTheme" id="myInput" >
        <option value="" >Pilih Tema...</option>
        <option value="Sirah">Sirah</option>
        <option value="Akhlak">Akhlak</option>
        <option value="Fiqh">Fiqh</option>
        <option value="Tafsir">Tafsir</option>
        <option value="Akidah">Akidah</option>
    </select>
    <input type="button" class="tajuk" onclick="cariTajuk()" value="Cari" >
    <div style="overflow-x:auto;">
        <table  id="listTajuk">
            <tr>
                <th onclick="susunTajuk(0)" style="width: 80px; height: 50px;">⥯ No.</th>
                <th onclick="susunTajuk(1)" style="width:700px;">⥯ Tajuk</th>
                <th onclick="susunTajuk(2)" style="width: 250px;">⥯ Tema</th>
                <th style="width: 100px;">Tindakan</th>
            </tr>
            <c:forEach var="result" items="${oc.rows}">
                <tr>
                    <td class="no">
                        <c:out value="${result.rank}"/>
                    </td>
                    <td class="name">
                        <c:out value="${result.topicname}"/>
                    </td>
                    <td class="name">
                        <c:out value="${result.topictheme}"/>
                    </td>
                    <td>
                        <form method="post">
                            <button  class="action"  type="edit" formaction="editTopic.jsp?id=${result.topicid}"
                            >EDIT
                            </button>
                        </form>
                        <form method="post">
                            <input type="hidden" name="topics" value="${result.topicid}">
                            <input type="hidden" name="action" value="deleteTopic">
                            <button  class="action"  type="delete" formaction="TopicServlet"  onclick="return confirm('Yakin untuk buang <c:out value="${result.topicname}"/> ?');">BUANG</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br><br><br>
</div>
<style type="text/css">
    h3{color: black;}
    #myInput{display: inline-block;width: 500px ;}
</style>
</body>
</html>