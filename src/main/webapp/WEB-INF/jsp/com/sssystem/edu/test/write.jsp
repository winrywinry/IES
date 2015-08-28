<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="test.css" />
<title>사내교육시스템 - 이수확인 등록</title>
<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<script src="/iessvn/js/jquery-ui.js"></script>
<script type="text/javascript" src="/iessvn/js/test.js"></script>
<link href="/iessvn/css/jquery-ui.css" rel="stylesheet">
<html:messages id="msg" property="error">
<script type="text/javascript">alert("<bean:write name='msg' />");</script>
</html:messages>
<html:messages id="msg" message="true">
<script type="text/javascript">alert("<bean:write name='msg' />");</script>
</html:messages>
</head>
<body>
<div id="winWrap">
	<div id="winHeader"><h3>시험 등록</h3></div>
	<div id="winCon">
		<form method="post" name="writeFrm" action="save.do">
		<input type="hidden" name="test" value="${test_no }" />
		<input type="hidden" name="edu" value="${edu_no }" />
		<table class="testWrite">
			<tr>
				<th>구분</th>
				<td>
					<input type="radio" name="gubun" value="A" id="gubun_A" ${testBean.gubun eq 'A' || testBean.gubun == null ? 'checked=checked' : '' } /><label for="gubun_A">객관식</label>
					<input type="radio" name="gubun" value="B" id="gubun_B" ${testBean.gubun eq 'B' ? 'checked=checked' : '' } /><label for="gubun_B">주관식</label>
				</td>
			</tr>
			<tr>
				<th>문제</th>
				<td><input type="text" name="question" class="txt w280" value="${testBean.question }" /></td>
			</tr>
			<tr id="answer_A">
				<th>정답</th>
				<td><div id="answerList">
					<c:if test="${testBean.answer_nm == null }">
					<div>1. <input type="radio" name="corr_answer" value="1" /><input type="text" name="answer_arr" class="txt w200" /> 
					<img src="/iessvn/images/bt_plus.png" class="btn answer_add rollover" /> <img src="/iessvn/images/bt_minus.png" class="btn answer_del rollover" /></div>
					<div>2. <input type="radio" name="corr_answer" value="2" /><input type="text" name="answer_arr" class="txt w200" /></div>
					</c:if>
					<c:if test="${testBean.answer_nm != null }">
						<c:set var="answer_arr" value="${fn:split(testBean.answer_nm, '@') }" />
						<c:forEach var="answer_nm" items="${answer_arr }" varStatus="status">
						<div>${status.count }. <input type="radio" name="corr_answer" value="${status.count }" ${testBean.corr_answer eq status.count ? "checked=checked" : "" } /><input type="text" name="answer_arr" class="txt w200" value="${answer_nm }" /> 
							<c:if test="${status.count == 1 }"><img src="/iessvn/images/bt_plus.png" class="btn answer_add rollover" /> <img src="/iessvn/images/bt_minus.png" class="btn answer_del rollover" /></c:if></div>
							<script type="text/javascript">answer_no = ${status.count + 1};</script>
						</c:forEach>
					</c:if>
					</div>
				</td>
			</tr>
			<tr id="answer_B">
				<th>정답</th>
				<td><textarea name="corr_answer2" class="txtArea">${testBean.corr_answer }</textarea></td>
			</tr>
		</table>
		<div id="btnArea">
			<a class="css_btn_class" onclick="submitChk();"><span id="sub">작성</span></a>
			<a class="css_btn_class" onclick="document.writeFrm.reset();">취소</a>
		</div>
		</form>
	</div>
</div>

</body>
</html>