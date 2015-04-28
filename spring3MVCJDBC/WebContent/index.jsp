<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.js"></script>
<script type='text/javascript' src='/spring3MVCJDBC/dwr/engine.js'></script>
<script type='text/javascript' src='/spring3MVCJDBC/dwr/interface/dwrMainController.js'></script>
<script type='text/javascript' src='/spring3MVCJDBC/dwr/util.js'></script>
<script type="text/javascript">
	var jq = jQuery.noConflict();
		jq(function(){
			//alert("abc");
			jq("#button").click(function(){
				
				var usrNameVal = jq.trim(jq("#usrName").val());
				var usrPwdVal = jq.trim(jq("#usrPwd").val());
				
				if(usrNameVal ==""){
					jq("#span").html("");
					jq("#span").append("用户名不能为空!");
					return false;
				}
				if(usrPwdVal ==""){
					jq("#span").html("");
					jq("#span").append("用户密码不能为空!");
					return false;
				}
				dwrMainController.lgn(usrNameVal,usrPwdVal,function(data){
					jq("#data").val(data);
					if(data == "ok"){
						jq("#lgnForm").submit();
					}else{
						jq("#span").html("");
						jq("#span").append("用户名密码错误!");
						return false;
					}
				});	
		});
	});	
	</script>
</head>
<body>

<span id="span" style="color:red"></span>
		<form  id="lgnForm" class="s" action="${pageContext.request.contextPath}/main/lgn.html" method="post">
				用户名字:<input id="usrName" name="usrname" value="梁健康"></input><br>
				用户密码:<input id="usrPwd" name="usrpwd" value="123"></input><br>
				<input id="button" type="button" value="登陆"></input>
				*忽略外键约束数据库用户名密码唯一
		</form>
		<hr>
		<!--  
<a href="lgn.jsp">去lgn.jsp登陆!</a>用ajax验证 -->
</body>
</html>