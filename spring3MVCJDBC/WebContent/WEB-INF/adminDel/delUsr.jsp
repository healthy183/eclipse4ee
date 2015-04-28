<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

*忽略外键约束
<table border="1">
  		<tr>
  			<td>序号</td><td>名称</td><td>领导</td><td>操作</td>
  		</tr>
 
  	<c:forEach items="${requestScope.usrVoList}" var="vo" varStatus="v">
  		<tr>
  			<td>${v.count}</td>
  			<td>${vo.usrname}</td>
  			<td>${vo.leanderName}</td>
  			<td>
  				<c:url value="adminDel/delUsrSuccess.html" var="delUsr">
  					<c:param name="usrid" value="${vo.usrid}"></c:param>
  				</c:url>
  				<a href="${delUsr}">删除</a>
  			</td>
  		</tr>
  	</c:forEach>
  	 </table>

</body>
</html>