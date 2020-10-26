<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<title>登录和注册</title>
	<link rel="stylesheet" href="css/style.css">
	<link href="css/popup-box.css" rel="stylesheet" type="text/css" media="all" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Sign In And Sign Up Forms  Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

	</script><script src="js/jquery.min.js"></script>
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<script type="text/javascript" src="js/modernizr.custom.53451.js"></script>
 <script>
						$(document).ready(function() {
						$('.popup-with-zoom-anim').magnificPopup({
							type: 'inline',
							fixedContentPos: false,
							fixedBgPos: true,
							overflowY: 'auto',
							closeBtnInside: true,
							preloader: false,
							midClick: true,
							removalDelay: 300,
							mainClass: 'my-mfp-zoom-in'
						});
																						
						});										
</script>
</head>
<body>
<div class="w3layouts">
<div class="dataHeader navi">
		${navCode}
	</div>
		<div class="signin-agile">
			<h2>登录
</h2>
			<form action="${pageContext.request.contextPath}/generalUser?action=loginuser" method="post" onsubmit="return checkForm()">
				
				<input type="text" name="name"  id="name" placeholder="用户名" value="${name }">
				
				
				<input type="password" name="password" id="password"  placeholder="密码" value="${password }">
				<ul>
					<li>
						<input type="checkbox" id="brand1" value="">
						<label for="brand1"><span></span>记住密码</label>
					</li>
				</ul>
				<a href="#">忘记密码?</a><br>
				<div class="clear"></div>
				 <font id="error" color="red">${error }</font> <input type="submit" value="登录">				
			</form>
		</div>
		<div class="signup-agileinfo">
			<div class="more">
				<a class="book popup-with-zoom-anim button-isi zoomIn animated" data-wow-delay=".5s" href="#small-dialog">点击注册</a>				
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="pop-up">
	<div class="dataHeader navi">
		${navCode}
	</div> 
	<div id="small-dialog" class="mfp-hide book-form">
		<h3>注册表单 </h3>
			<form action="generalUser?action=registereduser" method="post" onsubmit="return checkForm1()">
			
				<input type="text"  name="name1" id="name1" placeholder="用户名" value="${generalUser.generalusername }"/>
				<font id="message" color="red">${message}</font>
				
				<input type="email"  name="email1" id="email1" placeholder="邮件" value="${generalUser.generaluseremil }"/>
				<font id="message1" color="red">${message}</font>
				
				<input type="password"  name="password1" id="password1" placeholder="至少8-16个字符，至少1个大写字母，1个小写字母和1个数字" value="${generalUser.generaluserpassword }"/>
				<font id="message2" color="red">${message}</font>
				
				<input type="password"  name="password11" id="password11" placeholder="重复密码" value="${generalUser.generaluserpassword }"/>		
				<font id="message3" color="red">${message}</font>
						
				<input type="submit" value="点击注册">
				<font id="message4" color="red">${message}</font>
			</form>
	</div>
</div>	
</body>
<script type="text/javascript">
email.onchange = function(){
	var email = this.value;
	var reg = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
	if(reg.test(email)){
		alert("邮箱格式正确");
	}else{
		alert("邮箱格式不正确请重新输入");
	}
}
</script>
<script type="text/javascript">
	function checkForm(){
		var userName=document.getElementById("name").value;
		var password=document.getElementById("password").value;
		if(userName==null||userName==""){
			document.getElementById("error").innerHTML="用户名不能为空！";
			return false;
		}	
		if(password==null||password==""){
			document.getElementById("error").innerHTML="密码不能为空！";
			return false;
		}
		return true;
	}	

	
function checkForm1(){
	var username=document.getElementById("name1").value;
	var useremail1=document.getElementById("email1").value;
	var password1=document.getElementById("password1").value;
	var password11=document.getElementById("password11").value;
	if(username==null||username==""){
		document.getElementById("message").innerHTML="用户名不能为空！";
		return false;		
	}if(useremail1==null||useremail1==""){
		document.getElementById("message1").innerHTML="邮箱不能为空！";
		return false;
	}if(password1==null||password1==""){
		document.getElementById("message2").innerHTML="密码不能为空！";
		return false;		
	}if(password11==null||password11==""){
		document.getElementById("message3").innerHTML="请确认密码！";
		return false;		
	}if(password11!=password1){
		document.getElementById("message4").innerHTML="两次密码不一样！";
		return false;
	}
}
</script>
<c:if test="${requestScope.flag==1}">
  <script>
    alert("注册成功！");
  </script>
</c:if>

</html>