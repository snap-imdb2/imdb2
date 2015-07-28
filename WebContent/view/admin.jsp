<!DOCTYPE html>
<html>
  <head>
  
    <meta charset="ISO-8859-1">
    <title>IMDB 2.0</title>
    <link rel="stylesheet" href="./view/css/admin.css" type="text/css"/>
    <!--fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Alfa+Slab+One' rel='stylesheet' type='text/css'>
    
    <script type="text/javascript">
    </script>
  
  </head>
  
  <body>
    <div class = "header">
      <div class = "logo">
        <a href="#">IMDB 2.0</a>
      </div>
      <div class = "options">

      </div>
      <div class = "userDetails">

      </div>
    </div>

    <div class = "content">
      <div class = "page-content" id="main-content">
      
      <form action="/SNAP-IMDB2/adminServlet">
      	<input type="text" name="numberOfMoviesToFetch" /> <br/>
      	<input type="submit" value="Submit"> </input>
      </form>
      	
      </div>
      <div class="filter-content">
        This is filter content<br />
        This is filter content<br />
        This is filter content<br />
        This is filter content<br />
      </div>
    </div>

    <div class = "footer">
      <div class = "footer-content">
        <div class = "footer-content" id = "dummy-left"></div>
        <p class = "footer-content" id = "contact-info">+91 9988 911 911<span style="color:#A4A4A4;"> | </span>hi@snapimdb.com</p>
        <div class = "footer-content" id = "dummy-right"></div>
      </div>

      <div class = "copyright">
        <div class = "copyright" id = "dummy-left"></div>
        <p class = "copyright" id = "copyright">Copyright (2015) Team SnapIMDB.</p>
        <div class = "copyright" id = "dummy-right"></div>
      </div>
    </div>
  </body>
</html>
