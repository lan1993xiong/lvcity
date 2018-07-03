<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>登录页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/default/easyui.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>

<style>
html.body {
	height: 100%;
}

body {
	background-image: url("../images/bg.jpg");
}

.com-gpnu-form-contain {
	height: 100%;
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}

.com-gpnu-form {
	
}

.com-input-btn-contain {
	display: flex;
	flex-direction: row;
	justify-content: flex-end;
	margin: 20px;
	margin-left: 20px;
}

.com-gpnu-group {
	margin-top: 10px;
	border: 1px solid #f75d20;
	border-radius: 3px;
	padding: 5px;
}

.com-gpnu-center {
	height: 300px;
	width: 250px;
	display: flex;
	align-items: center;
	justify-content: center;
	box-shadow: 1px 2px 5px 2px #f75d20;
	border-radius: 10px;
}

.com-gpnu-input {
	border: none;
	outline: none;
	margin-left: 20px;
	background-color: transparent;
}

.com-gpnu-input-sumbit {
	margin-left: 20px;
}

.bgcolor {
	color: #f75d20;
}

.bgbtn {
	background-color: #f75d20;
	outline: 0 none !important;
	blr: expression(this.onFocus = this.blur ());
	color: white;
}
</style>
</head>
<%
	String message = (String) request.getAttribute("message");
	if (message == null) {
		message = "";
	}
	if (!message.trim().equals("")) {
		out.println("<script language='javascript'>");
		out.println("alert('" + message + "')");
		out.println("</script>");
	}
	//request.removeAttribute("message");
%>
<body>
	<div class="com-gpnu-form-contain">
		<div class="com-gpnu-center">
			<form id="ff" class="com-gpnu-form">
				<div class="com-gpnu-group">
					<span class="glyphicon glyphicon-user bgcolor"></span> <input
						class="easyui-validatebox com-gpnu-input" type="text"
						name="adminname" required="true" />
				</div>
				<div class="com-gpnu-group">
					<span class="glyphicon glyphicon-lock bgcolor"></span> <input
						name="passwd" class="com-gpnu-input" type="text"
						required="required" />
				</div>
				<div class="com-input-btn-contain">
					<input class="easyui-validatebox btn com-gpnu-input-sumbit bgbtn"
						type="submit" required="true" value="提交" />
				</div>
			</form>
		</div>
	</div>

</body>
<script>
	$('#ff').form({
		url : '<%=basePath%>loginController/isUser.do',
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(data) {
			var message = eval('(' + data + ')');
			if (message.success == true) {
				window.location.href= "<%=basePath%>loginController/login.do";
			} else {
				alert("出错了");
			}
		}
	});
</script>
</html>
