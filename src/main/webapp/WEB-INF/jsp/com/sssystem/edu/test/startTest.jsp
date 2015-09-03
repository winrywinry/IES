<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
	<div id="winHeader"><h3>시험</h3></div>
	<div id="winCon">	
		<form method="get" name="checkTest" action="checkTest">
		<input type="hidden" name="test" value="${test_no }" />
		<input type="hidden" name="edu_no" value="${param.edu_no }" />
		<table class="testWrite">
		<c:forEach var="test" items="${list }" varStatus="no">
			<tr>
				<th>구분</th>
					<td><c:choose>
						<c:when test="${test.gubun=='A' }">객관식</c:when>
						<c:otherwise>주관식</c:otherwise>
					</c:choose></td>
			</tr>
			<tr>
				<th>문제</th>
				<td>${test.question }</td>
			</tr>
			<c:choose>
				<c:when test="${test.gubun=='A' }">
					<tr>
					<th>정답</th>
						<td class="last">
						<c:set var="answer_arr" value="${fn:split(test.answer_nm, '@') }"/>
							<c:forEach var="answer_nm" items="${answer_arr }">
								<input type="radio" name="${test.q_no }" id="${test.q_no }" value="${no.index+1 }">${answer_nm }<br>
						</c:forEach>
						</td>
					</tr>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${test.gubun=='B' }">
					<tr>
					<th>정답</th>
						<td>
							<input type="text" name="${no.index+1 }"/>
						</td>	
					</tr>
				</c:when>
			</c:choose>
		</c:forEach>
		</table>
		<div id="btnArea">
			<input type="submit" class="css_btn_class">
			<a class="css_btn_class" onclick="checkFrm();"><span id="sub">작성</span></a>
			<a class="css_btn_class" onclick="document.writeFrm.reset();">취소</a>
		</div>
		</form>
	</div>
</div>

</body>
</html>