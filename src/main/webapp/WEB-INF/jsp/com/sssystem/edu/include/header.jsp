<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
	<div id="con">
		<div id="top">
			<div id="logo">
				<a href="/IES/index"><img src="${initParam.root }/images/Logo.png" alt="�系�����ý���" title="�系�����ý���" /></a>
			</div>

		</div>
		<div id="userInfo">
			<span id="userIntro"><em>${user.user_nm }</em> �� ȯ���մϴ� :)</span> <span
				id="userManu"> <a
				href="${initParam.root }/member/login" onclick="return confirm('�α׾ƿ� �Ͻðڽ��ϱ�?');">�α׾ƿ�</a>
				<c:if test="${user.admin_yn==1}"> &nbsp;| &nbsp;<a href="${initParam.root }/admin/member/list">������</a></c:if>
			</span>
		</div>
		<nav>
			<ul id="topMenu">
				<li><a href="${initParam.root }/learn/list?page=1">����</a></li>
				<li><a href="${initParam.root }/board/list?board_gb=20">��������</a></li>
				<li><a href="${initParam.root }/qna/list?board_gb=60">���ǻ���</a></li>
				<li><a href="${initParam.root }/board/list?board_gb=10">Ŀ�´�Ƽ</a></li>
			</ul>
		</nav>
	</div>
</header>
<script>
$("#topMenu li").css("cursor", "pointer");
$("#topMenu li").hover(function(){
	$("#topMenu li").removeClass("current");
	$(this).addClass("current");
}, function(){
	this.removeClass("current");
})

</script>