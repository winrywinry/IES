<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.sssystem.edu.vo.QnaBoardVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- request.setCharacterEncoding("euc-kr"); --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/qna.css" />
<title>Insert title here</title>
	<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
	<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
	<script type= "text/javascript" src ="${initParam.root }/js/SEditor.js" charset="UTF-8" ></script>
	<script type= "text/javascript">
	$(function(){
	       callEditor( "ta1");   
	});
	
	function formchk(){
	   oEditors.getById["ta1"].exec("UPDATE_CONTENTS_FIELD", []);
	   
		var title = document.pWriteForm.title.value;
		var contents = document.pWriteForm.contents.value;
		if(title == '') {
			alert('제목을 입력해주세요!!');
			document.pWriteForm.title.focus();
			return false;
		} else if(contents.length < 20) {
			alert('내용을 입력해주세요!!');
			document.pWriteForm.contents.focus();
			return false;
		} else {
			document.pWriteForm.submit();
		}
	      return true;
	   
	      return true;
      }
	
	</script>
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
				<form action="writeForm" method="post" name="pWriteForm" onsubmit="return formchk();">
					<input type = "hidden" name="board_gb" value="${param.board_gb }">
					<input type = "hidden" name="qna_no" value="${qnaboard.qna_no }">
					<input type = "hidden" name="user_no" value="${qnaboard.q_user_no }">
					<input type = "hidden" name="edu_no" value="${param.edu_no }">
					<c:if test="">
					<input type = "hidden" name="check" value="1">
					</c:if>
						<table class="listtop">
							<tr>
								<th height="36px" valign="bottom" style="padding-top:10px;"><h3><div id="pagetitle">글쓰기</div></h3></th>
							</tr>
						</table>
						<table class="contentTab">
							<tr>
								<th width="100">제목</th>
								<td class="left"><input type="text" name="title" style="width: 700px;" value="${qnaboard.title }"></td>
							</tr>
							<tr>
								<th>내용</th>
								<td class="left">
									<textarea name="contents" id="ta1" rows="10" cols="100" style="width :700px; height:200px; display: none;">
										${qnaboard.q_contents }
									</textarea>
								</td>
							</tr>
						</table>
						<input type="hidden" value="${param.no }" name="no">
						<input style="width: 50px; height: 25px; margin: 10px 5px 0px 0px" class="ml-button-1" type="submit" value="저장" onclick="validationChk()">
						<input style="width: 50px; height: 25px; margin: 10px 0px 0px 5px" class="ml-button-1" type="reset" value="취소" onclick="history.go(-1)">				
					</form>
					</div>
			</section>
		</div>
		<jsp:include page="/include/footer" />
	</div>
</body>
</html>