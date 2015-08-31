<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<aside>
		<header><a href="/IES/member/login"><img src="/IES/images/Logo.png" alt="Logo" title="Logo"/></a></header>
		<div id="userInfo">
			<p><em>${user.user_nm}</em> 님 안녕하세요 ^^</p>
			<p class="btn"><a href="/IES/member/login/">사내교육시스템</a> | <a href="/IES/member/login">로그아웃</a></p>
		</div>
		<jsp:include page="/admin/include/left_menu"></jsp:include>
	</aside>
