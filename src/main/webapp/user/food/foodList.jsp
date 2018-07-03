<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/base.css" rel="stylesheet" type="text/css">
<link href="css/pagename.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/search.js"></script>
<title></title>
</head>
<body>
<div class="rightbar">
          	<div class="bread">
          		 <span style="float:left">${foodtype }</span>
          		<form method="post" action="<%=basePath%>foodController/search.do?pageNow=1">
	          		<div style="width:200px;height:25px;float:right;">
	          			<input type="text" name="ftid" style="float:left;width:100px;height:25px;margin-top:5px;"/>
	          			<input type="submit" style="width:50px;height:30px;float:left;margin-top:5px;" value="搜索"/>
	          		</div>
          		</form>
          	</div>
	
			<c:if test="${zwjl != null }">
				<div style="width:100%;height:50px;text-align:center;color:red;float:left;font-size:20px;">暂无记录</div>
			</c:if>
			
          	 <ul class="ul_zj clearfix">
          	 	<c:if test="${!empty foodlist }">
				<c:forEach items="${foodlist}" var="food">
					<li><a href="<%=basePath %>foodController/detailFood.do?ftid=${food.foodtype.ftid}&aid=${food.article.aid}&pageNow=${pageNow}"><img src="${food.image }" width="220" height="140"><span>${food.fname }</span></a></li>
				</c:forEach>
				</c:if>
              </ul>

              	<!-- 分页 -->
           		<div class="line">
                   <div class="fy_left">
                       共${rowCount }条&nbsp;|&nbsp;每页${18 }条&nbsp;|&nbsp;共${pageCount }页
                   </div>
                    <div class="fy"><a href="<%=basePath%>foodController/ByPage.do?pageNow=${pageCount}&pageCount=${pageCount}&rowCount=${rowCount}">尾页</a></div>
                       <div class="fy"><a href="<%=basePath%>foodController/ByPage.do?pageNow=${pageNow+1>pageCount?pageCount:pageNow+1 }&pageCount=${pageCount}&rowCount=${rowCount}">下一页</a></div>
                       <div class="fy"><a>${pageNow }</a></div>
                       <div class="fy"><a href="<%=basePath%>foodController/ByPage.do?pageNow=${pageNow-1<=0?1:pageNow-1}&pageCount=${pageCount}&rowCount=${rowCount}">上一页</a></div>
                       <div class="fy"><a href="<%=basePath%>foodController/ByPage.do?pageNow=1">首页</a></div>
			        </div>
               </div>

</div>


</body>
</html>