<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<aside>
		<header><a href="/IES/member/login"><img src="/IES/images/Logo.png" alt="Logo" title="Logo"/></a></header>
		<div id="userInfo">
			<p><em>${user.user_nm}</em> �� �ȳ��ϼ��� ^^</p>
			<p class="btn"><a href="/IES/member/login/">�系�����ý���</a> | <a href="/IES/member/login">�α׾ƿ�</a></p>
		</div>
		<jsp:include page="/admin/include/left_menu"></jsp:include>
	</aside>
