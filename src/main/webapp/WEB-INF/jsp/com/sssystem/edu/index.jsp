<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<logic:notPresent scope="session" name="user">
<%-- <c:redirect url="/member/login.do" ></c:redirect> --%>
</logic:notPresent>
<!DOCTYPE html>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href='${initParam.root }/fullcalendar-2.3.2/fullcalendar.css' rel='stylesheet' />
<link href='${initParam.root }/fullcalendar-2.3.2/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script src='${initParam.root }/fullcalendar-2.3.2/lib/moment.min.js'></script>
<script src='${initParam.root }/fullcalendar-2.3.2/fullcalendar.min.js'></script>
<script type="text/javascript" src="${initParam.root }/js/fullcalendar.js"></script>

<link rel="stylesheet" type="text/css" href="${initParam.root }/css/index.css" />
<title>사내교육시스템 - 메인</title>
<script type="text/javascript">
$(document).ready(function() {
    $( "#summary" ).sortable({
        revert: true
      });
      $( "dl, dd" ).disableSelection();
});
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="/include/header" />
		<div id="content">
			<section id="cen">
				<div id="top">
					<div id="userInfo" class="left">
					<dl>
						<dt class="prfl_thmb">
						<img src="${initParam.root }/images/profil/${photo }" />
						<div class="mask"></div>
						</dt>
						<dd><em>${user.user_nm }</em> 님 | <a href="${initParam.root }/member/login" onclick="return confirm('로그아웃 하시겠습니까?');">로그아웃</a></dd>
					</dl>
					<p>출석수<span>${log }</span></p>
					<p>교육예정<span>${learnCount }</span></p>
					<p>교육이수<span>${learnCount2 }</span></p>
					<p>게시글수<span>${write }</span></p>
					<p>질문수<span>${question }</span></p>
					<p>댓글수<span>${reply }</span></p>
					</div>
					<div id="imgSection" class="right">
						<img src="${initParam.root }/images/5.png" alt="공간절약" />
					</div>
				</div>
				<div id="mid">
					<span class="title">공지사항</span>
					<c:forEach var="notice1" items="${notice }">
					<a href="/IES/board/view?board_gb=${notice1.board_gb}&no=${notice1.board_no }">${notice1.title }</a>
					</c:forEach>
				</div>
				<div id="bot">
					<div id="calendar" class="left"><div id="calendar"></div></div>
					<div id="summary" class="right">
						<dl>
							<dt>최근 이수 교육</dt>
							<c:forEach var="mylearn2" items="${completes2 }">
							 <dd><a href="/IES/learn/contentsView?no=${mylearn2.edu_no }&page=1&dept_no=${mylearn2.dept_no }&searchWord=">${mylearn2.title }</a></dd>
							 </c:forEach>
						</dl>
						<dl>
							<dt>이수 예정 교육</dt>
							 <c:forEach var="mylearn" items="${completes }">
							<dd><a href="/IES/learn/contentsView?no=${mylearn.edu_no }&page=1&dept_no=${mylearn.dept_no }&searchWord=">${mylearn.title }</a></dd>
							</c:forEach> 
						</dl>
						<dl>
							<dt>나의 질문</dt>
							<c:forEach var="myQuestion" items="${myWriteView }">
							<dd><a href="/IES/qna/view?board_gb=${myQuestion.board_gb}&no=${myQuestion.qna_no }">${myQuestion.title }</a></dd>
							</c:forEach>
						</dl>
						<dl>
							<dt>나의 게시글</dt>
							<c:forEach var="myWrite" items="${myQuestionView }">
							<dd><a href="/IES/board/view?board_gb=${myWrite.board_gb}&no=${myWrite.board_no }">${myWrite.title }</a></dd>
							</c:forEach>
						</dl>
						<dl>
							<dt>나의 댓글</dt>
							<c:forEach var="contents" items="${replyContents }">
							<dd><a href="/IES/board/view?board_gb=${contents.board_gb}&no=${contents.board_no }">${contents.contents }</a></dd>
							</c:forEach>
						</dl>
						<dl>
							<dt>건의사항</dt>
							<c:forEach var="qnaBoard" items="${recommendView }">
							<dd><a href="/IES/qna/view?board_gb=${qnaBoard.board_gb}&no=${qnaBoard.qna_no }">${qnaBoard.title }</a></dd>
							</c:forEach>
						</dl>
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="/include/footer" />
	</div>
	
</body>
</html>


