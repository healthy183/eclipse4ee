<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/common/global.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link href="ligerlib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <style type="text/css">

*{ font-size:12px;
	   font-family:"宋体";
	 }

.tableA{
	text-align:center;
	width:99%;
	font:Georgia 11px;
	font-size:12px;
	color:#333333;
	border-collapse:collapse;/*细线表格*/
}

.tableA th{
	border:1px solid #C6D7FF;/*细线条颜色*/
	height:22px;
	text-align: center;
}

	.tableA td{
	border:1px solid #C6D7FF;/*细线条颜色*/
	height:22px;
}

#good{
 		font-size: 14px;
 	}
#good input{
		margin-top: 10px;
	}	
	


</style>
    <script src="ligerlib/jquery/jquery-1.8.3.js" type="text/javascript"></script>
    <script src="ligerlib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="ligerlib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
    <script src="ligerlib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <!--  
    <script src="ligerlib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="ligerlib/ligerUI/js/plugins/ligerDateEditor.js" type="text/javascript"></script>
	<script src="ligerlib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
	-->
	<script type="text/javascript">
			$(function(){
				
				function checkIsNull(o,msg){
					$(".addLable").html("");
					if(o.val() == ""){
						$("#"+o.attr("id")+"Label").html(msg);
						return false;
					}else{
						return true;
					}
				};
				
				$("#addUsr").click(function(){
		             
					$(".addLable").html("");
					$("input[type='text']").val("");
		            // $("#usrName").ligerTextBox();
		            // $("#usrPwd").ligerTextBox();
		             $.ligerDialog.open({ 
		            	 width: 450, 
		            	 title: '添加用户', 
		            	 target: $("#target1"),
		            	 buttons: [
			            	         { text: '确定', onclick: function (item, dialog) {
			            	        
			            	        var isTrue = true;	
			            	        var usrName =  $("#usrName");
			            	        var usrPwd = $("#usrPwd");
			            	        var usrNameVar = usrName.val();
			            	        var usrPwdVar =	 usrPwd.val();
			            	        
			            	    	isTrue = isTrue && checkIsNull(usrName,"员工名称不能为空!");
			    					isTrue = isTrue && checkIsNull(usrPwd,"员工密码不能为空!");
			            	        
			    					if(isTrue){
			    					
				    					$.post("${pageContext.request.contextPath}/main/isHadName.html",
				    							{usrNameVar:usrNameVar},function(data){
				    					
				    						if(data == "true"){
				    							
				    							$.post("${pageContext.request.contextPath}/main/saveUsr.html",
				    									{usrNameVar:usrNameVar,usrPwdVar:usrPwdVar},function(date){
				    								
				    									var lastIndex =	$("#tableA>tbody>tr:last").attr("id");
				    									lastIndex = (lastIndex*1)+1;
				    									
				    									var addTr ="<tr id='"+lastIndex+"'usrid='"+date+"'>"+
				    									"<td id='usrname"+lastIndex+"'>"+usrNameVar+"</td><td id='usrpwd"+lastIndex+"'>"+usrPwdVar+"</td><td>"+
				    									"<a href='javascirpt:void();' id='' class='updtButton' "+
				    										">"+
				    												"修&nbsp;改</a>&nbsp;"+
				    									"<a href='javascirpt:void();' id='' class='delButton'"+
				    									">"+
				    												"删&nbsp;除</a>"+	
				    									"</td></tr>";
				    									$("#tableA tbody").append(addTr);
				    										
				    							//	alert(date);
				    								dialog.hide();
				    							});
				    							 
				    						}else{
				    							$("#usrPwdLabel").html("");
				    							$("#usrNameLabel").html(usrNameVar+"已经被占用!");
				    						}
				    					});
			    					}
			            	       } },
			            	         { text: '取消', onclick: function (item, dialog) { 
			            	        	// alert(item.text); 
			            	        	 dialog.hide();
			            	        	 } }
				            	  ]
		             });
				});			
			});
	</script>


</head>

<body>

<div id="target1" style="width:400px; margin:3px; display:none;" title="添加用户">
    
    <div id="good">
      	用户名称:<input type="text" id="usrName" />
      	<font style="color:red;">*</font><label id="usrNameLabel" style="color:red;" class="addLable"></label>
      <br/>
      	用户密码:<input type="text" id="usrPwd"/>
    	<font style="color:red;">*</font><label id="usrPwdLabel" style="color:red;" class="addLable"></label>
    	<br/>
    </div>
 </div>




	<table class="tableA" id="tableA">
		<tr>
			<th>用户名</th><th>密码</th>
			<th><input id="addUsr" type="button" value="添加"></input></th>
		</tr>
		<c:forEach items="${requestScope.usrList}" var="usr" varStatus="u">
			<tr id="${u.count}" usrid="${usr.usrId}">
				<td id="usrname${u.count}">${usr.usrName}</td>
				<td id="usrPwd${u.count}">${usr.usrPwd}</td>
				<td><a href="javascript:void();" class="updtButton">修改</a>&nbsp;<a href="javascript:void();" class="delButton">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>