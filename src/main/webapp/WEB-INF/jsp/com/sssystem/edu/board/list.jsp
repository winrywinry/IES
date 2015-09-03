<%@page import="com.sssystem.edu.common.SetBoardTitle"%>
<%@page import="com.sssystem.edu.vo.BoardVO"%>
<%@page import="com.sssystem.edu.vo.search.SearchVO"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>
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

$(document).ready(function() {
	$("#navMenu").navgoco({accordion: true});
});
function jsGoPage(p,param){
       location.href= "list?page="+ p + param;
}
	
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/board.css" /> 
<title>공지사항</title>

</head>
<body>
	<div id="wrap">
		<jsp:include page="/include/header" />
		<div id="content">
			<c:choose>
				<c:when test="${param.board_gb==10 || param.board_gb==30 }">
				<jsp:include page="/include/left_menu_community" />
				</c:when>
				<c:when test="${param.board_gb==20 }">
				<jsp:include page="/include/left_menu_info" />
				</c:when>
			</c:choose>
			<section id="cen">
				<div id="center">				
					<form name="searchFrm" action="/IES/board/list?board_gb=${param.board_gb }" method="post" id="searchFrm" onsubmit="return formchk();">
					<table class="listtop">
							<tr>
								<th valign="bottom" >
									<c:if test="${param.board_gb==10 }"><h3>공지사항</h3><br></c:if>
									<c:if test="${param.board_gb==30 }"><h3>자유게시판</h3><br></c:if>
									<c:if test="${param.board_gb==20 }"><h3>자료실</h3><br></c:if>
								</th>
								<td>
								<td width="20%"><input type="text" id=pSearchWord name="pSearchWord" value="${searchBean.searchWord }"/></td>
								<td width="6%" id="text"><img src="../images/glasses2.png" onclick="document.searchFrm.submit();"></td>
								<td width="6%"><img src="../images/write.png" onclick="location.href='/IES/board/write?board_gb=${param.board_gb }';"></td>
							</tr>
						</table>
					</form>	
					<table class="listTab">
						<tr>
							<th width="10%">번호</th>
							<th>제 목</th>			
							<c:if test="${param.board_gb != 30 }"><th width="10%">첨부파일</th></c:if>
							<th width="15%">작성일</th>
							<th width="10%">조회수</th>
						</tr>
						<c:forEach var="board" items="${list }">
						<tr>
							<td>${board.rownum }</td>
							<td class="left"><a href="view?board_gb=${board.board_gb}&no=${board.board_no }">${board.title }</a></td>

							<c:if test="${param.board_gb != 30 }"><td><a href=#><img src="../images/ico_file_def.gif"></a></td></c:if>
							<td><fm:formatDate value="${board.input_dt }" pattern="yyyy-MM-dd'<br>'HH:mm"/></td>
							<td>${board.view_cnt }</td>
						</tr>	
						</c:forEach>				
					</table>
				</div>
				<div id="bot">
					<div id="paging"></div>
					<div id="btn">
						<form action="writeForm.do" method="post">
							<input type ="hidden" name ="board_gb" value="${param.board_gb }" >
						</form>
					</div>
				<custom:paging page="${searchVO.page_no}" totalCnt="${searchVO.total}" par="&board_gb=${param.board_gb}&pSearchWord=${searchVO.searchWord}"></custom:paging>
				</div>				
			</section>
		</div>
		<jsp:include page="/include/footer" />
	</div>
</body>
</html>