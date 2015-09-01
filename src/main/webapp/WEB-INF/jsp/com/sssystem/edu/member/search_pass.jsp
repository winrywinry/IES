<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사내교육시스템 - 비밀번호 찾기</title>
<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<script type="text/javascript" src="/IES/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/join.css">
<script type="text/javascript">
$(function(){
	document.frmChk.user_id.focus();
});
</script>
</head>
<body>
<div id="wrap">
	<!-- header -->
	<div id="header">
		<h1><a href="login" class="logo hid_txt" tabindex="1">사내교육시스템</a></h1>
	</div>
	<!-- container -->
	<div id="container">
		<!-- content -->
		<div id="content">
			<form id="frmChk" name="frmChk" target="_top" AUTOCOMPLETE="off" action="findPasswordAccess" method="post">
			<fieldset class="join_form">
			<legend class="blind">사원인증</legend>
				<div class="row_group">
					<div class="join_row_name" id="idDiv">
						<span class="ps_box id">
							<input type="text" class="int" placeholder="아이디" value="" maxlength="40" name="user_id" required="required" id="id">
						</span>
					</div>
					<div class="join_row" id="nmDiv">
						<span class="ps_box">
							<input type="text" class="int" placeholder="이름" value="" maxlength="40" name="user_nm" required="required" id="name">
						</span>
					</div>
					<div class="join_row join_serial" id="serialDiv">
						<span class="ps_box int_serial">
							<input type="tel" pattern="\d{4}\-\d{3}" title="0000-000" class="int" placeholder="사원번호" required="required" value="" maxlength="8" name="emp_serial" id="serial" style="ime-mode:disabled;">
						</span>
						<!-- 아래 에러 출력 div는 인라인으로 style 넣어주세요. 디폴트 : display:none -->
						<form:errors path="comm.emp_serial" cssClass="error" id="serialMsg" element="div"/>
						<c:if test="${msg != null }">
						<div class="error" id="serialMsg">${msg }</div>
						</c:if>
					</div>
				</div>
				<div class="btn_join">
					<input type="submit" title="사원인증" alt="사원인증" tabindex="12" value="Confirm" onclick="">
				</div>
			</fieldset>
			</form>
		</div>
	</div>
</div>
</body>