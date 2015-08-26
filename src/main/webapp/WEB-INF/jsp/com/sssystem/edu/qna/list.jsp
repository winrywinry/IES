<%@page import="com.sssystem.edu.common.SetBoardTitle"%>
<%@page import="com.sssystem.edu.vo.QnaBoardVO"%>
<%@page import="com.sssystem.edu.vo.SearchVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
	
	function formchk(){
		   oEditors.getById["ta1"].exec("UPDATE_CONTENTS_FIELD", []);
		      return true;
	      }

	function searchFormChk() {
		var form = document.searchForm;
	        if (form.searchForm.value == '') {
	            alert('검색어를 입력하세요.');
	            // 제목 INPUT BOX 커서가 이동
	            form.searchForm.focus();
	            return false;
     }
	}<%--1--%>
     function compare(){
     	var searchWord= document.searchFrm.pSearchWord.value;
     	if(searchWord == '') {    		
     		alert('비밀번호를 입력해주세요.');
     	}
     }

	$(document).ready(function(){
		$("#navMenu").navgoco({accordion: true});
	});
	function jsGoPage(p,param){
	       location.href= "list.do?page="+ p + param;
	}
	
	</script>
	
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.3/jquery.min.js"></script>
<script type="text/javascript">	
                $(function() {
                    $('dl.accordion>dd').hide();
                    $('dl.accordion>dt').click(function(e) {
                        $('dl.accordion>dt').not(this).removeClass('opened');
                        $(this).toggleClass('opened');
                        $('dl.accordion>dt').not(this).nextUntil('dl.accordion>dt').hide('slow');
                        $(this).nextUntil('dl.accordion>dt').toggle(250);
                    });
                });
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/qna.css" />
<title>공지사항</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="/include/header" />
		<div id="content">
			<c:choose>
				<c:when test="${param.board_gb==60}">
				<jsp:include page="/include/left_menu_propose" />
				</c:when>
				<c:when test="${param.board_gb==40 || param.board_gb==50 }">
				<jsp:include page="/include/left_menu_info" />
				</c:when>
			</c:choose>
			<section id="cen">
				<div id="center">
					<form name="searchFrm" action="/iessvn/qna/list.do?board_gb=${param.board_gb }" method="post" id="searchFrm" onsubmit="return formchk();">
					<table class="listtop">
							<tr>
								<th valign="bottom" >
									<c:if test="${param.board_gb==40 }"><h3>질문과답변</h3><br></c:if>
									<c:if test="${param.board_gb==50 }"><h3>FAQ</h3><br></c:if>
									<c:if test="${param.board_gb==60 }"><h3>건의사항</h3><br></c:if>
								</th>
								<td>
								<td width="20%"><input type="text" id=pSearchWord name="pSearchWord" value="${searchVO.searchWord }"/></td>
								<td width="6%" id="text"><img src="../images/glasses2.png" onclick="document.searchFrm.submit();"></td>
								<td width="6%"><img src="../images/write.png" onclick="location.href='/iessvn/qna/writeForm.do?board_gb=${param.board_gb }';"></td>
							</tr>
						</table>
					</form>	
					<c:if test="${param.board_gb!=50 }">
					<table border="0" cellspacing="0" cellpadding="0" class="listTab">
						<tr>
							<th width="10%">번호</th>
							<th>제 목</th>			
							<th width="10%">첨부파일</th>
							<th width="15%">작성일</th>
							<th width="10%">조회수</th>
						</tr>
						<c:forEach var="qnaBoard" items="${list }">
						<tr>
							<td>${qnaBoard.rownum }</td>
							<td class="left"><a href="view?board_gb=${qnaBoard.board_gb}&no=${qnaBoard.qna_no }&user_no=${user.user_no }">${qnaBoard.title }</a></td>
							<td><a href=#><img src="../images/ico_file_def.gif"></a></td>
							<td><fmt:formatDate value="${qnaBoard.question_dt}" pattern="yyyy-MM-dd'<br>'HH:mm"/>${qnaboard.question_dt }</td>
							<td>${qnaBoard.visit_no }</td>
						</tr>	
						</c:forEach>				
					</table>
					</c:if>
					<c:if test="${param.board_gb==50 }">
					<table border="0" cellspacing="0" cellpadding="0" class="listTab">
						<tr>
							<th width="50" valign="top">번호</th>
							<th>내용</th>
						</tr>
							<c:forEach var="qnaBoard" items="${list }">
						<tr>
						<td>${qnaBoard.rownum}</td>
						<td>
												<dl class="accordion">
                     			<dt><b>${qnaBoard.title }</b></dt>
                     				<dd>
                     					<img alt="" src="../images/faq.gif">
                     					${qnaBoard.q_contents }<br>
                     					<a class="link1" onclick="location.href='/iessvn/qna/updateForm.do?no=${qnaBoard.qna_no }&board_gb=${param.board_gb }';">수정</a>|
                     					<a class="link1" onclick="location.href='/iessvn/qna/deleteForm.do?no=${qnaBoard.qna_no }&board_gb=${param.board_gb}';">삭제</a>
                    				</dd>
						</dl>
						</td>
						</tr>
							</c:forEach>	
					</table>
						</c:if>
	<%--					<dl class="accordion">
							<dt>번호 &nbsp; &nbsp; <span style="display:block;text-align:center;">내용</span></dt>
							<c:forEach var="qnaBoard" items="${list }">
                     			<dt style="CURSOR: pointer">&nbsp; ${qnaBoard.rownum } &nbsp; &nbsp; <b>${qnaBoard.title }</b></dt>
                     				<dd>
                     					<img alt="" src="../images/faq.gif">
                     					${qnaBoard.q_contents }<br><a class="link1">수정</a>|<a class="link1" onclick="location.href='/iessvn/qna/deleteForm.do?no=${qnaBoard.qna_no }&board_gb=${param.board_gb }&board_no';">삭제</a>
                    				</dd>
							</c:forEach>	
						</dl>
					</c:if> --%>
				</div>
				<div id="bot">
					<div id="paging"></div>
<%-- 					<div id="btn">
							<form action="writeForm.do" method="post">
								<input type ="hidden" name ="board_gb" value="${param.board_gb }" >
								<a href="/iessvn/qna/writeForm.do?board_gb=${param.board_gb }" class="css_btn_class">등록</a>
							</form>
						</div> --%>
				<custom:paging page="${searchVO.page_no}" totalCnt="${searchVO.total}" par="&board_gb=${param.board_gb}&pSearchWord=${searchVO.searchWord}"></custom:paging>
				</div>				
			</section>
		</div>
		<jsp:include page="/include/footer" />
	</div>
</body>
</html>