<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>IMDB 2.0</title>

    <link rel="stylesheet" type="text/css" href="./view/css/main_login.css">
    <script type="text/javascript">
       
    function tryAjax(message){
    	alert("aaa");
    	var xmlhttp = new XMLHttpRequest();
		xmlhttp.onreadystatechange=function(){			   
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
		      document.getElementById("validation_error").innerHTML=message;
		      alert("ddd");
		    }
		}
		xmlhttp.open("GET","./view/ajax_info.txt",true);
		xmlhttp.send();
	}

		var loading = function () {
        var totalCount = 5;
        var num = Math.floor(Math.random() * totalCount) + 1
        document.body.background = '.\/images\/' + num + '.jpg'
    }
		
		function validateSignUpForm(){
			var name = document.forms["signup_form"]["username"].value;
			alert("name is "+name + (name == "") + (name == null));
			if(name == "" || name == null){
				tryAjax("Name must be filled out");
				return false;
			}
			return true;
		}
	   
       
    </script>
  </head>
  <body onload="loading();">
    <div id="wrapper">
      <div id="container">
    	<section class="tabs">
    		<input id="tab-1" type="radio" name="radio-set" class="tab-selector-1" checked="checked" />
    		<span for="tab-1" class="tab-label-1">Signup</span>

    		<input id="tab-2" type="radio" name="radio-set" class="tab-selector-2" />
    		<span for="tab-2" class="tab-label-2">Login</span>

    		<div class="clear-shadow"></div>
    		
    		<img src="”http://www.google.com" al/>
			
			<div id="validation_error"></div>
    		<div id="content">
    			<div class="content-1">
    				<form  action="" autocomplete="on" name="signup_form">
    				  <p>
    					<label for="usernamesignup" class="user_name">Your Name</label>
    					<input class="field" name="username"  type="text" placeholder="username" />
    				  </p>
    				  <p>
    					<label for="emailsignup" class="mail"> Your email</label>
    					<input class="field" name="emailsignup" type="email" placeholder="user@example.com"/>
    				  </p>
    				  <p>
      					<label for="passwordsignup" class="passwrd">Your password </label>
      					<input class="field" name="passwordsignup" type="password" placeholder="password"/>
    				  </p>
    				  <p>
      					<label for="passwordsignup_confirm" class="passwrd">Please confirm your password </label>
      					<input class="field" name="passwordsignup_confirm" type="password" placeholder="password"/>
    				  </p>
      				<input type="submit" class="button" id ="submit-button" onclick="validateSignUpForm()"></input>
    				</form>
    			</div>
    			<div class="content-2">
    				<form  action="" autocomplete="on">
    				  <p>
    					<label for="username" class="username"> Your email or username </label>
    					    <input class="field" name="username" required="required" type="text" placeholder="username or name@example.com"/>
    				  </p>
    				  <p>
    					<label for="password" class="passwrd"> Your password </label>
    					    <input class="field" name="password" required="required" type="password" placeholder="password" />
    				  </p>
    				  <p class="keeplogin">
    					    <input type="submit" class="button" id="login-button"></input>
    				  </p>
    				</form>
    			</div>
    		</div>
    	</section>
      </div>
    </div>
  </body>
</html>
