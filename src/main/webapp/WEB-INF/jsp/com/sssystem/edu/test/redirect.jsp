<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/test.css" />
<title>사내교육시스템 - 시험</title>
<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<script src="${initParam.root }/js/jquery-ui.js"></script>
<script type="text/javascript" src="${initParam.root }/js/test.js"></script>
<link href="${initParam.root }/css/jquery-ui.css" rel="stylesheet">
</head>
<body>
<div id="winWrap">
	<div id="winHeader"><h3>결과</h3></div>
	<div id="winCon">	
		<table class="testWrite">
			<tr>
				<th>문제수</th>
				<td>${size}</td>
			</tr>
			<tr>
				<th>정답수</th>
				<td>${correct}</td>
			</tr>
			<tr>
				<th>점수</th>
				<td>${jumsu}</td>
			</tr>
			
		</table>
		<div id="btnArea">
			<a class="css_btn_class" href='javascript:self.close();'>종료</a>
		</div>
		</form>
	</div>
</div>

</body>
</html>