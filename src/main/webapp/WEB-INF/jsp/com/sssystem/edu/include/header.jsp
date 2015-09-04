<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<header>
	<div id="con">
		<div id="top">
			<div id="logo">
				<a href="/IES/index"><img src="${initParam.root }/images/Logo.png" alt="사내교육시스템" title="사내교육시스템" /></a>
			</div>

		</div>
		<div id="userInfo">
			<span id="userIntro"><em>${user.user_nm }</em> 사원님 환영합니다 :)</span> <span
				id="userManu"> <a href="#">회원정보수정</a> &nbsp;| &nbsp;<a
				href="${initParam.root }/member/login" onclick="return confirm('로그아웃 하시겠습니까?');">로그아웃</a> &nbsp;| &nbsp;<a href="${initParam.root }/admin/member/list">관리자</a>
			</span>
		</div>
		<nav>
			<ul id="topMenu">
				<li><a href="${initParam.root }/learn/list?page=1">교육</a></li>
				<li><a href="${initParam.root }/board/list?board_gb=20">정보마당</a></li>
				<li><a href="${initParam.root }/qna/list?board_gb=60">건의사항</a></li>
				<li><a href="${initParam.root }/board/list?board_gb=10">커뮤니티</a></li>
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