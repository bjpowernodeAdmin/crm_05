<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 	request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>

<script type="text/javascript">

	$(function(){
		
		//如果当前页面不是顶层窗口，则将当前页面设置为顶层窗口
		if(window.top!=window){
			window.top.location=window.location;
		}

		
		//页面加载完毕后，用户名自动获得焦点
		$("#loginAct").focus();
		
		//页面加载完毕后，将账号默认内容清空掉
		$("#loginAct").val("");
		
		$("#submitBtn").click(function(){
			
			login();
		
		})
		
		//触发敲键盘事件
		//event:可以取得敲键盘的编码
		$(window).keydown(function(event){
			
			//如果触发的按键编码为13，说明我们敲的是回车键，需要执行登录操作
			if(event.keyCode==13){
				
				login();
				
			}
			
		})
		
		
	})
	
	//注意：自己创建的function方法需要写在$(function(){})的外面
	function login(){
		
		//取得账号密码
		//去掉内容的左右空格$.trim(内容)
		var loginAct = $.trim($("#loginAct").val());
		var loginPwd = $.trim($("#loginPwd").val());
		
		if(loginAct=="" || loginPwd==""){
			
			$("#msg").html("账号密码不能为空");
			
			//一旦账号密码为空，需要强制终止该方法
			return false;
			
			
		}
		
		//验证账号密码
		$.ajax({
			
			url : "settings/user/login.do",
			data : {
				
				"loginAct" : loginAct,
				"loginPwd" : loginPwd
				
			},
			type : "post",
			dataType : "json",
			success : function(data){
				
				/*
				
					data
						{"success":true/false,"msg":?}
				
				*/
				
				
				//如果登录成功
				if(data.success){
					
					//登录成功，跳转到工作台的初始页面（登录成功后的欢迎页）
					window.location.href = "workbench/index.jsp";
					
				//如果登录失败	
				}else{
					
					$("#msg").html(data.msg);
					
				}
				
				
			}
		
		
		})
		
			
	}
	
	
	
	
</script>

</head>
<body>
	<div style="position: absolute; top: 0px; left: 0px; width: 60%;">
		<img src="image/IMG_7114.JPG" style="width: 100%; height: 90%; position: relative; top: 50px;">
	</div>
	<div id="top" style="height: 50px; background-color: #3C3C3C; width: 100%;">
		<div style="position: absolute; top: 5px; left: 0px; font-size: 30px; font-weight: 400; color: white; font-family: 'times new roman'">CRM &nbsp;<span style="font-size: 12px;">&copy;2017&nbsp;动力节点</span></div>
	</div>
	
	<div style="position: absolute; top: 120px; right: 100px;width:450px;height:400px;border:1px solid #D5D5D5">
		<div style="position: absolute; top: 0px; right: 60px;">
			<div class="page-header">
				<h1>登录</h1>
			</div>
			<form action="workbench/index.html" class="form-horizontal" role="form">
				<div class="form-group form-group-lg">
					<div style="width: 350px;">
						<input class="form-control" type="text" placeholder="用户名" id="loginAct">
					</div>
					<div style="width: 350px; position: relative;top: 20px;">
						<input class="form-control" type="password" placeholder="密码" id="loginPwd">
					</div>
					<div class="checkbox"  style="position: relative;top: 30px; left: 10px;">
						
							<span id="msg" style="color: red"></span>
						
					</div>
					<!-- 
					
						注意：type="submit"的问题！！！
					
					 -->
					<button type="button" id="submitBtn" class="btn btn-primary btn-lg btn-block"  style="width: 350px; position: relative;top: 45px;">登录</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>