<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" >
	function show(){
		alert(1)
		var xhr=new XMLHttpRequest();
		xhr.open("get","/QuickBuild/showList.do",true);
		xhr.onreadystatechange=function(){
		/* 	alert(xhr.readyState); */
			if(xhr.readyState==4){
			/* 	alert(xhr.status); */
				if(xhr.status==200){
					var rs=xhr.responseText;
					alert(rs);
				}
			}
		};

		xhr.setRequestHeader("If-Modified-Since", "Wed, 02 Aug 2018 19:30:15 GMT");
		
		xhr.send(null);
	}
</script>
</head>
<body>
	欢迎光临！

	<br /> 
	<table>
		<thead>
			<tr>
				<td>姓名</td>
				<td>科目</td>
				<td>成绩</td>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${mapList}" var="map">
				<tr>
					<td>${map.SUBJECT_NAME}</td>
					<td>${map.STU_NAME}</td>
					<td>${map.SCORE}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
	<input type="button" value="ajax" onclick="show()">
</body>
</html>