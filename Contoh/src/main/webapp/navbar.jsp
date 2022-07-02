<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/9bff21277a.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="JS/script.js"></script>
    <script src="JS/sortTable.js"></script>
    <script src="JS/searchTable.js"></script>
</head>
<body>

<div class = "header" style="">
    <img src="IMG/logo.png" style="width: 500px;height: 90px; float: left;margin-left: 270px ;">
    <h3 style="color:black">Waktu  	: <span id="datetime"></span></h3>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
  /*  $(document).on('click','a',function(){
        $(this).addClass('active').siblings().removeClass('active')
    })*/
    {var dt = new Date();
        document.getElementById("datetime").innerHTML = dt.toLocaleString();
    }
</script>
</html>