	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	   
	      return true;
      }
	
	</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="/include/header" />
		<div id="content">
			<jsp:include page="/include/left_menu_community" />
			<section id="cen"> 	
							<div id="center"> 	
				<form action="answerForm" method="post" name="pWriteForm" onsubmit="return formchk();">
					<input type = "hidden" name="board_gb"  value="${param.board_gb }">
					<input type = "hidden" name="qna_no" value="${param.qna_no }">
					<input type = "hidden" name="user_no">
					<c:if test="">
					<input type = "hidden" name="check" value="1">
					</c:if>
						<table class="listtop">
							<tr>
								<th height="36px" valign="bottom" style="padding-top:10px;"><h3><div id="pagetitle">답변작성</div></h3></th>
							</tr>
						</table>
						<table cellspacing="0" class="contentTab">
							<tr>
								<th width="100">내용</th>
								<td class="left">
									<textarea name="a_contents" id="ta1" rows="10" cols="100" style="width :620px; height:200px; display: none;">
									</textarea>
								</td>
							</tr>
						</table>
						<input style="width: 50px; height: 25px; margin: 10px 5px 0px 430px" class="ml-button-1" type="submit" value="저장" onclick="titleChk()">
						<input style="width: 50px; height: 25px; margin: 10px 0px 0px 5px" class="ml-button-1" type="reset" value="취소" onclick="history.go(-1)">				
					</form>
					</div>
			</section>
		</div>
		<jsp:include page="/include/footer" />
	</div>
</body>
</html>