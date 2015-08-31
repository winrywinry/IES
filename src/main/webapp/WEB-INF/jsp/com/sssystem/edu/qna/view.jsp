<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="com.sssystem.edu.vo.QnaBoardVO"%>
<%@page import="com.sssystem.edu.vo.support.SessionVO"%>
<%-- <%@page import="kr.or.sssystem.edu.qnaBoard.model.beans.CheckAuthBean"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/learn.css" />
<title>Insert title here</title>
	<script type="text/javascript">
	
	function delConfirm() {
	    if (confirm("�����Ͻðڽ��ϱ�?")){
	       location.href='/IES/qna/delete?no=${qnaboard.qna_no }&board_gb=${param.board_gb }';
	    } else {
	       return false;
	    }
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
					<table class="listtop">
						<tr>
							<th height="36px" valign="bottom" style="padding-top:10px;"><h3>${qnaboard.title }</h3></th>
							<td width="15%"><fm:formatDate value="${qnaboard.question_dt }" pattern="yyyy-MM-dd HH:mm" /></td>
						</tr>
					</table>
					<form name ="frmBoard" >
					<input type="hidden" name="board_no" value="${param.board_gb}">
					<table cellpadding="0" cellspacing="0" class="contentTab">
						<tr>
							<th width="15%">��ȸ��</th>
							<td width="35%" class="left">${qnaboard.visit_no }</td>
							<th width="15%">��������</th>
							<td width="35%" class="left"><c:if test="${qnaboard.secret_yn==0 }">����</c:if></td>
						</tr>
						<tr>
							<th style="height: 300px">����</th>
							<td colspan="5" valign="top" class="left"><div>${qnaboard.q_contents }</div></td>
						</tr>
					</table>
					<br>
					<c:if test="${0 ne qnaboard.a_user_no}">
									<table cellpadding="0" cellspacing="0" class="contentTab">
						<tr>
							<th width="15%">�亯��</th>
							<td width="35%" class="left">${qnaboard.a_user_nm}</td>
							<th width="15%">�亯����</th>
							<td width="35%" class="left"><fm:formatDate value="${qnaboard.answer_dt }" pattern="yyyy-MM-dd a hh:mm"/></td>
						</tr>
						<tr>
							<th style="height: 300px">�亯����</th>
							<td colspan="5" valign="top" class="left"><div>${qnaboard.a_contents }</div></td>
						</tr>
					</table>
					<br>
					</c:if>
					<table class="moveTab">
						<tr>
							<td width="20%"><img src='/IES/images/up.png' /> ������</td>
							<td width="50%" class="left">
							<c:choose>
								<c:when test="${qnaboard.pre_idx==0 }">
								�������� �����ϴ�
								</c:when>
								<c:otherwise>
								<a href="/IES/qna/view?board_gb=${qnaboard.board_gb}&no=${qnaboard.pre_idx }">${qnaboard.pre_title }</a>
								</c:otherwise>
							</c:choose>
							</td>
							<td width="30%">
							<c:choose>
								<c:when test="${qnaboard.pre_dt=='Sat Nov 11 00:00:00 KST 1111' }">
								</c:when>
								<c:otherwise>
								<fm:formatDate value="${qnaboard.pre_dt }" pattern="yyyy-MM-dd'<br>'a hh:mm"/>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
						<tr>
							<td><img src='/IES/images/down.png' /> ������</td>
							<td width="50%" class="left">
							<c:choose>
								<c:when test="${qnaboard.next_idx==0 }">
								�������� �����ϴ�
								</c:when>
								<c:otherwise>
								<a href="/IES/qna/view?board_gb=${qnaboard.board_gb}&no=${qnaboard.next_idx }">${qnaboard.next_title }</a>
								</c:otherwise>
							</c:choose>
							</td>
							<td width="30%">
							<c:choose>
								<c:when test="${qnaboard.next_dt=='Sat Nov 11 00:00:00 KST 1111' }">
								</c:when>
								<c:otherwise>
								<fm:formatDate value="${qnaboard.next_dt }" pattern="yyyy-MM-dd'<br>'a hh:mm"/>
								</c:otherwise>
							</c:choose>
							</td>
						</tr>
					</table>
						<c:if test="${user.manage_yn==1 && 0 eq qnaboard.a_user_no}">
						<input type="button" class="ml-button-1" value="�亯" onclick="location.href='/IES/qna/answer?qna_no=${qnaboard.qna_no }&board_gb=${param.board_gb }';">
						</c:if>
						<c:if test="${user.manage_yn==1 && 0 ne qnaboard.a_user_no}">
						<input type="button" class="ml-button-1" value="�亯����" onclick="location.href='/IES/qna/answer?qna_no=${qnaboard.qna_no }&board_gb=${param.board_gb }';">
						</c:if>
						<input type="button" class="ml-button-1" value="����" onclick="delConfirm()">
						<input type="button" class="ml-button-1" value="�������" onclick="location.href='/IES/qna/list?board_gb=${qnaboard.board_gb}';">
					</form>
				</div>
			</section>
		</div>
		<jsp:include page="/include/footer" />
	</div>
</body>
</html>