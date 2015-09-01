<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>사내교육시스템 - 로그인</title>
<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/login.css">

<script type="text/javascript">
function FormChkModule(f){
	if(f.user_id.value==""){
		alert("아이디를 입력하세요!!");
		f.user_id.focus();
		return false;
	}
	if(f.user_pwd.value==""){
		alert("비밀번호를 입력하세요!!");
		f.user_pwd.focus();
		return false;
	}
	return true;
}//FormChkModule
$(function(){
	document.frmLogin.user_id.focus();
	 $(".msgAlert").hide();
     $(".msgAlert").each(function(){
           alert($( this).text());            
     })
});
</script>
<c:if test="${msg != null }">
	<script type="text/javascript">alert('${msg}');</script>
</c:if>
</head>

<body>
<form:errors path="member.user_id" cssClass="msgAlert"/>
<form:errors path="member.user_pwd" cssClass="msgAlert"/>
<div id="wrap">
	<!-- header -->
	<div id="header">
		<h1><a href="login" class="logo hid_txt" tabindex="1">사내교육시스템</a></h1>
	</div>
	<!-- container -->
	<div id="container">
		<!-- content -->
		<div id="content">
			<form id="frmLogin" name="frmLogin" target="_top" AUTOCOMPLETE="off" action="loginAccess" method="post" onsubmit="return FormChkModule(this)">
			<fieldset class="login_form">
			<legend class="blind">로그인</legend>
				<div class="input_row" id="id_area">
					<span class="input_box">
						<label for="id" id="label_id_area" class="lbl">아이디</label>
						<input type="text" id="id" name="user_id" tabindex="7" accesskey="L" placeholder="아이디" class="int" maxlength="20" value="">
					</span>
				</div>
				<div class="input_row" id="pw_area">
					<span class="input_box">
						<label for="pw" id="label_pw_area" class="lbl" >비밀번호</label>
						<input type="password" id="pw" name="user_pwd" tabindex="8" placeholder="비밀번호" class="int" maxlength="20">
					</span>
				</div>
				<div class="btn_login">
					<input type="submit" title="로그인" alt="로그인" tabindex="12" value="login">
				</div>
			</fieldset>
			</form>
			<div class="find_info">
				<a href="id.do" onclick="">아이디 찾기</a> / <a href="pass.do" onclick="">비밀번호 찾기</a> <span class="bar">|</span> <a href="check.do">회원가입</a>
			</div>
		</div>
	</div>
</div>
</body>