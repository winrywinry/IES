<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�系�����ý��� - �������</title>
<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<script type="text/javascript" src="/IES/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/join.css">
<script type="text/javascript">
$(function(){
	document.frmChk.user_nm.focus();
});
</script>
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
			<form id="frmChk" name="frmChk" target="_top" AUTOCOMPLETE="off" action="joinAccess" method="post">
			<fieldset class="join_form">
			<legend class="blind">�������</legend>
				<div class="row_group">
					<div class="join_row" id="nmDiv">
						<span class="ps_box">
							<input type="text" class="int" placeholder="�̸�" value="" maxlength="40" name="user_nm" required="required" id="id">
						</span>
					</div>
					<div class="join_row join_serial" id="serialDiv">
						<span class="ps_box int_serial">
							<input type="tel" pattern="\d{4}\-\d{3}" title="0000-000" class="int" placeholder="�����ȣ" required="required" value="" maxlength="8" name="emp_serial" id="serial" style="ime-mode:disabled;">
						</span>
						<!-- �Ʒ� ���� ��� div�� �ζ������� style �־��ּ���. ����Ʈ : display:none -->
						<html:messages id="msg" property="errnm">
						<div class="error" id="serialMsg"><bean:write name="msg" /></div>
						</html:messages>
						<html:messages id="msg" property="errEmpno">
						<div class="error" id="serialMsg"><bean:write name="msg" /></div>
						</html:messages>
						<html:messages id="msg" message="true">
						<div class="error" id="serialMsg"><bean:write name="msg" /></div>
						</html:messages>
					</div>
				</div>
				<div class="btn_join">
					<input type="submit" title="�������" alt="�������" tabindex="12" value="Confirm" onclick="">
				</div>
			</fieldset>
			</form>
		</div>
	</div>
</div>
</body>