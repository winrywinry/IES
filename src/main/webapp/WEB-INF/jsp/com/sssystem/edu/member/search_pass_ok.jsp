<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>�系�����ý��� - ���̵�ã��</title>
	<link rel="stylesheet" type="text/css" href="${initParam.root }/css/search.css">
</head>
<body>
<div id="wrap">
	<!-- header -->
	<div id="header">
		<h1>${member.user_nm }���� ��й�ȣ</h1>
	</div>
	<!-- container -->
	<div id="container">
		<!-- content -->
		<div id="content">
			<ul class="search_id">
				<li class="li_con">${member.email }</li>
			</ul>
			<a class="link" href="login">�̸��Ϸ� �ӽ� ��й�ȣ �����ϱ�</a>
		</div>
	</div>
</div>
</body>