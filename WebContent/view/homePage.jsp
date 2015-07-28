<%@ page import="java.util.List" %>
<%@ page import="org.snapimdb2.Movie"%>
<!DOCTYPE html>
<html>
  <head>
  
    <meta charset="ISO-8859-1">
    <title>IMDB 2.0</title>
    <link rel="stylesheet" href="./view/css/homePage.css" type="text/css"/>
    <!--fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Alfa+Slab+One' rel='stylesheet' type='text/css'>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
	</script>
        
    <script type="text/javascript">
    	
    	function search(arg){
    		var xmlhttp = new XMLHttpRequest();
			xmlhttp.onreadystatechange=function(){				
				if (xmlhttp.readyState==4 && xmlhttp.status==200){					
					document.getElementById("omdb").innerHTML=xmlhttp.responseText;
				}
			}
			if( arg === "null"){
				var url = "http://www.omdbapi.com/?t="+document.getElementById("searchText").value;
			}
			else{				
				var url = "http://www.omdbapi.com/?t="+arg;
			}
			xmlhttp.open("GET",url,true);
			xmlhttp.send();
    	}
    	
    	function highlight(rowId){
    		document.getElementById(rowId).style.color="blue";
	      	document.getElementById(rowId).style.fontWeight="bold";
	      	search(document.getElementById(rowId+"col").childNodes.item(0).nodeValue);	
    	}
    	    	
    	function unHighlight(rowId){
	      	document.getElementById(rowId).style.color="black";
	      	document.getElementById(rowId).style.fontWeight="normal";
    	}
    	
    	$(document).ready(function(){
    		$("button").click(function () {   
    			 $("tr:even").css("background-color","red");
    		 	 //$("tr:even").css("background-color","green");
    		});
    		
    		$("#login").bind("mouseover", function(){
    			//alert("dsds");
    			$("#login").text("No login needed. yolo!!");
    		});
    		
    		$("#login").bind("mouseout", function(){
    			//alert("aaa");
    			$("#login").text("Login");
    		});
    	});
    	    	
    </script>
  
  </head>
  
  <body>
    
    <div class="header">
		<div class="logo" id="logo">
			<a href="#">IMDB 2.0</a>
		</div>
		<div class="login" id="login">
			<a href="#">Login</a>
		</div>
		<div class="search">
			<form>
				<input type="text" value="Search" class="searchText" id="searchText" onchange="search('null')"
				onkeydown="search('null')" oninput="search('null')"/>
				<button type="button" value="Search" class="searchButton" onclick="search('null')">Search</button>
			</form>
		</div>
	</div>

    <div class = "content">
      <div class = "page-content" id="main-content">
        
        <table class="mtable" id="mtable">
        	<tr>
        		<th>#</th>
        		<th>Movie Name</th>
        		<th>Director</th>
        	</tr>        	
        	<% 
        		List<Movie> movies = (List<Movie>)request.getAttribute("movies");        		
        		if(!movies.isEmpty())
	        		for(int i = 0; i < movies.size(); i++){
	        		    out.println("<tr id=\"row"+i+"\" onmouseenter=\"highlight('row"+i+"')\" " + 
	        		            "onmouseleave=\"unHighlight('row"+i+"')\">");		        		
	        		    
	        		    out.println( 
	        		            "<td>"+ (i+1) + "</td>" +
		        		        "<td id=\"row"+i+"col\">"+ movies.get(i).getMovieMetaData().getMovieName() + 
		        		        "</td><td>"+movies.get(i).getMovieMetaData().getDirectorName() + "</td>");
		        		out.println("<tr/>");		        		        
		        	}
        	%>
        </table>
        
      </div>
      <div class="filter-content">
        <%
        	String url1 = response.encodeUrl("index.html?param=inv");
        	String url2 = response.encodeUrl("index.html?param=rfh");           	        	
        	
        	if(request.getParameter("param")!=null){
	        	if(request.getParameter("param").equals("inv")){
	        	    if(!session.isNew())
	        	    session.invalidate();	        	    
	        	}
	        	else if (request.getParameter("param").equals("rfh")){
	        	    //request.
	        	}
        	}
        	
        	HttpSession httpSession = request.getSession();        	        
        	long creationTime = httpSession.getCreationTime();
        	long lastAccessTime = httpSession.getLastAccessedTime();
        	String sessionId = httpSession.getId();
        	boolean isNew = httpSession.isNew();              	
        	
        	out.println(    "sessionId: "+sessionId + "<br/>" +
        	        		"Creation time: "+creationTime + "<br/>" +
        	                "lastAccessTime: "+lastAccessTime + "<br/>" +        	                
        	                "isNew: "+isNew + "<br/>" +
        	                "<a href="+url1+">Invalidate</a><br/><a href="+url2+">Refresh</a>"
        	        ); 	
        %>       
        
        <div class="omdb" id="omdb">
        	Sample
        </div>
        
      </div>
    </div>

    <div class = "footer">
      <div class = "footer-content">
        <div class = "footer-content" id = "dummy-left"></div>
        <p class = "footer-content" id = "contact-info">+91 9988911911<span style="color:#A4A4A4;"> | </span>hi@snapimdb.com</p>
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

<!-- <!DOCTYPE html>
<html>
<head>
<title>Search Box Example 2 - default placeholder text gets cleared on click</title>
<meta name="ROBOTS" content="NOINDEX, NOFOLLOW" />
JAVASCRIPT to clear search text when the field is clicked
<script type="text/javascript">
window.onload = function(){ 
	//Get submit button
	var submitbutton = document.getElementById("tfq");
	//Add listener to submit button
	if(submitbutton.addEventListener){
		submitbutton.addEventListener("click", function() {
			if (submitbutton.value == 'Search our website'){//Customize this text string to whatever you want
				submitbutton.value = '';
			}
		});
	}
}
</script>
CSS styles for standard search box with placeholder text
<style type="text/css">
	#tfheader{
		background-color:#c3dfef;
	}
	#tfnewsearch{
		float:right;
		padding:20px;
	}
	.tftextinput2{
		margin: 0;
		padding: 5px 15px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		color:#666;
		border:1px solid #0076a3; border-right:0px;
		border-top-left-radius: 5px 5px;
		border-bottom-left-radius: 5px 5px;
	}
	.tfbutton2 {
		margin: 0;
		padding: 5px 7px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		font-weight:bold;
		outline: none;
		cursor: pointer;
		text-align: center;
		text-decoration: none;
		color: #ffffff;
		border: solid 1px #0076a3; border-right:0px;
		background: #0095cd;
		background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
		background: -moz-linear-gradient(top,  #00adee,  #0078a5);
		border-top-right-radius: 5px 5px;
		border-bottom-right-radius: 5px 5px;
	}
	.tfbutton2:hover {
		text-decoration: none;
		background: #007ead;
		background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
		background: -moz-linear-gradient(top,  #0095cc,  #00678e);
	}
	/* Fixes submit button height problem in Firefox */
	.tfbutton2::-moz-focus-inner {
	  border: 0;
	}
	.tfclear{
		clear:both;
	}
</style>
</head>
<body>
	HTML for SEARCH BAR
	<div id="tfheader">
		<form id="tfnewsearch" method="get" action="http://www.google.com">
		        <input type="text" id="tfq" class="tftextinput2" name="q" size="21" maxlength="120" value="Search our website"><input type="submit" value=">" class="tfbutton2">
		</form>
		<div class="tfclear"></div>
	</div>
</body>
</html>
 -->

