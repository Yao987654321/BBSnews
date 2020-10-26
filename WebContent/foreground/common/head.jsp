<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function setDateTime(){
			var date=new Date();
			var day=date.getDay();
			var week;
			switch(day){
			case 0:week="星期日";break;
			case 1:week="星期一";break;
			case 2:week="星期二";break;
			case 3:week="星期三";break;
			case 4:week="星期四";break;
			case 5:week="星期五";break;
			case 6:week="星期六";break;
			}
			var today=date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日  "+week+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
			document.getElementById("today").innerHTML=today;
		}
		
		window.setInterval("setDateTime()", 1000);
		
		function logoutuser(){
			if(confirm('您确定要退出系统吗？')){
				window.location.href='user?action=logoutuser';
			}
		}
	</script>
<div class="row-fluid">
	<div class="span12">
		<img src="${pageContext.request.contextPath}/images/logo.png">
	</div>
</div>
<div class="row-fluid">
	<div class="span12">
		<div class="navbar">
		  <div class="navbar-inner">
		    <a class="brand" href="goIndex">首页</a>
		    <ul class="nav">
		       <c:forEach var="newsType" items="${newsTypeList}">
		       		<li><a href="news?action=list&typeId=${newsType.newsTypeId }">${newsType.typeName }</a></li>
		       </c:forEach>
		    </ul>		
		  </div>
		</div>
	</div>
</div>
<div class="username">
欢迎用户：<font color="red">${currentUser.generalusername }</font>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:logoutuser()">[&nbsp;安全退出&nbsp;]</a>&nbsp;&nbsp;&nbsp;&nbsp;<font id="today" class="currentDateTime"></font>
</div>