<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@taglib uri= "http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri= "http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri= "http://struts.apache.org/tags-logic" prefix="logic" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>�系�����ý��� - �α���</title>
<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/login.css">

<script type="text/javascript">
function FormChkModule(f){
	if(f.id.value==""){
		alert("���̵� �Է��ϼ���!!");
		f.id.focus();
		return false;
	}
	if(f.pass.value==""){
		alert("��й�ȣ�� �Է��ϼ���!!");
		f.pass.focus();
		return false;
	}
	return true;
}//FormChkModule
$(function(){
	document.frmLogin.id.focus();
});
</script>
<!-- <html:messages id="msg" message="true"> Action�� GLOBAL_MESSAGE�� mapping
	<script type="text/javascript">alert('<bean:write name ="msg"/>');</script>
</html:messages>
<html:messages id= "msg" property ="errid">
	<script type="text/javascript">alert('<bean:write name="msg"/>');</script>
</html:messages>
<html:messages id= "msg" property ="errpass">
	<script type="text/javascript">alert('<bean:write name="msg"/>');</script>
</html:messages> -->
</head>

<body>
<div id="wrap">
	<!-- header -->
	<div id="header">
		<h1><a href="login" class="logo hid_txt" tabindex="1">�系�����ý���</a></h1>
	</div>
	<!-- container -->
	<div id="container">
		<!-- content -->
		<div id="content">
			<form id="frmLogin" name="frmLogin" target="_top" AUTOCOMPLETE="off" action="loginAccess" method="post" onsubmit="return FormChkModule(this)">
			<fieldset class="login_form">
			<legend class="blind">�α���</legend>
				<div class="input_row" id="id_area">
					<span class="input_box">
						<label for="id" id="label_id_area" class="lbl">���̵�</label>
						<input type="text" id="id" name="id" tabindex="7" accesskey="L" placeholder="���̵�" class="int" maxlength="20" value="">
					</span>
				</div>
				<div class="input_row" id="pw_area">
					<span class="input_box">
						<label for="pw" id="label_pw_area" class="lbl" >��й�ȣ</label>
						<input type="password" id="pw" name="pass" tabindex="8" placeholder="��й�ȣ" class="int" maxlength="20">
					</span>
				</div>
				<div class="btn_login">
					<input type="submit" title="�α���" alt="�α���" tabindex="12" value="login">
				</div>
			</fieldset>
			</form>
			<div class="find_info">
				<a href="findIdCheck" onclick="">���̵� ã��</a> / <a href="findPasswordCheck" onclick="">��й�ȣ ã��</a> <span class="bar">|</span> <a href="joinCheck">ȸ������</a>
			</div>
		</div>
	</div>
</div>
</body>