<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="/common/global.jsp"%>
	   <script src="ligerlib/jquery/jquery-1.8.3.js" type="text/javascript"></script>
	   <script type="text/javascript">
	   			$(function(){
	   				$("#button").click(function(){
	   					
	   					var usrName =  $("#usrName");
            	        var usrPwd = $("#usrPwd");
            	        var usrNameVar = usrName.val();
            	        var usrPwdVar =	 usrPwd.val();
	   					
            	        $.post("${pageContext.request.contextPath}/main/test.html",
            	        		{usrName:usrNameVar},
            	        			function(data){
            	        				alert(data);
            	        });
	    					
	   				});
	   			});
	   </script>
</head>
<body>


	<form action="main/lgn.html" method="post">
		用户名:<input id="usrName" name="usrName" value="梁健康"></input>
		密码:<input id="usrPwd" name="usrPwd" value="123"></input>
		<input type="submit" value="登陆"></input>
		<!--
		<input type="button"  id="button" value="登陆"></input>  -->
	</form>	
	
</body>
</html>