<%@page import="com.sssystem.edu.vo.LearnVO"%>
<%@page import="com.sssystem.edu.vo.CompleteVO"%>
<%@page import="com.sssystem.edu.vo.support.SessionVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/learn.css" />
<title>Insert title here</title>
<% LearnVO learn = (LearnVO)request.getAttribute("learn");%>
	<script type="text/javascript">
		function del(){
			if (confirm("���� �����Ͻðڽ��ϱ�??")){    //Ȯ��
				location.href="./delete?edu_no="+document.frm.edu_no.value;
			}else{   //���
			    return;
			}
		}
		
		window.onload=function(){
		    var essential = document.getElementById('essential');//console: Element
		    var e = ${learn.essential_yn};
		    var msg=null;
		    if(e==1){
		    	msg="�ʼ�";
		    }else{
		    	msg="����";
		    }
        essential.innerHTML = msg;  
		}		
		
		function favoriteCnt() {
			location.href="./favorite?edu_no="+document.frm.edu_no.value+"&user_no="+${user.user_no};
			document.frm.favorite
		}

	</script>
</head>
<body>
	<div id="wrap"> 
		<jsp:include page="/include/header" />
		<div id="content">
			<jsp:include page="/include/left_menu_learn" />
			<section id="cen">
				<div id="center">
					<table class="listtop">
									<tr>
										<th height="36px" valign="bottom" style="padding-top:10px;"><h3>${learn.title }</h3></th>
										<td width="15%"><fmt:formatDate value="${learn.input_dt }" pattern="yyyy-MM-dd HH:mm" /></td>
									</tr>
								</table>
					<form name="frm" method="POST">
					<input type="hidden" name="edu_no" value="${learn.edu_no}">
					<table class="contentTab">
						<tr>
							<th width="15%">÷������</th>
							<td width="30%"><a class="css_btn_class" onclick="favoriteCnt">��õ</a><span>${learn.favorite_cnt}</span></td>
							<th width="10%">�ʼ�����</th>
							<td width="10%"><span id="essential"></span></td>
							<th width="10%">��ȸ��</th>
							<td width="10%">${learn.view_cnt }</td>
						 	<th width="25%">��õ��</th>
							<td width="10%">${learn.favorite_cnt}</td>
						</tr>
<%-- 	<tr>
		<th>�����Ⱓ</th>
		<td colspan="5"><fmt:formatDate value="${learn.period_st}" pattern="yyyy�� MM�� dd��" /> ~ <fmt:formatDate value="${learn.period_ed}" pattern="yyyy�� MM�� dd��" /></td>
	</tr> --%>
<!--<tr>
 	<th>����</th>
	<td colspan="5"><input type="button" value="START"><input type="button" id="favorite" value="��õ" onclick="setDisable(favorite)"></td>
</tr> -->
						<tr>
							<th style="height: 300px" rowspan="2">����</th>
							<td colspan="5">
								<iframe width="700	px" height="400px" src="http://www.youtube.com/embed/${learn.contents_tag }" allowfullscreen="allowfullscreen"></iframe>
							</td>
<!-- <td colspan="3" bgcolor="yellow">ä���� Q&Aâ</td> -->
						</tr>
						<tr>	
							<td colspan="5">${learn.contents }</td>
<!-- <td colspan="3" bgcolor="pink">�μ��� �⼮����</td> -->
						</tr>
<!-- 	<tr>
		<th>����</th>
		<td colspan="5"><input type="button" value="END"></td>
	</tr> -->
					</table>
					<br>
					<span style="font-size: 80%; font-weight: bolder; float: right;">
					<c:if test="${learnComplete.start_dt == null}">
					<a class="link1" onclick="location.href='/IES/learn/updateComplete?no=${learn.edu_no}&start_dt=${learnComplete.start_dt }&end_dt=${learnComplete.end_dt }&dept_no=${param.dept_no }&page=${param.page }'">��������</a> |
					</c:if>
					<c:if test="${learnComplete.end_dt != null and learnComplete.end_dt == '1111-11-11 00:00:00.0'}">
					<a class="link1" onclick="location.href='/IES/learn/updateComplete?no=${learn.edu_no}&start_dt=${learnComplete.start_dt }&end_dt=${learnComplete.end_dt }&dept_no=${param.dept_no }&page=${param.page }'">��������</a> |
					</c:if>
					<c:if test="${learnComplete.end_dt != null and learnComplete.end_dt != '1111-11-11 00:00:00.0'}">
					<a class="link1" onclick="">�������${learnComplete.end_dt }</a> |					
					</c:if>
					<a class="link1" href="/IES/qna/write?board_gb=40&edu_no=${learn.edu_no }" >�����ϱ�</a> | 
					<a class="link1" onclick="del()" >����</a> | 
					<a class="link1" onclick="location.href='/IES/learn/updatePage?no=${learn.edu_no}&user_no=${learn.user_no}&update=update';">����</a> | 
					<a class="link1" onclick="location.href='/IES/learn/list';">�������</a>
					</span>
					<br><br>
					<table class="moveTab">
						<tr>
							<td width="20%"><img src='/IES/images/up.png' /> ������</td>
							<td width="60%" class="left"><a href="contentsView?no=${learnPrev.edu_no}&dept_no=${param.dept_no}&page=${param.page}">${learnPrev.title }</a></td>
							<td width="20%"><fmt:formatDate value="${learnPrev.input_dt }" pattern="MM-dd HH:mm" /></td>
						</tr>
						<tr>
							<td><img src='/IES/images/down.png' /> ������</td>
							<td class="left"><a href="contentsView?no=${learnNext.edu_no}&dept_no=${param.dept_no}&page=${param.page}">${learnNext.title }</a></td>
							<td><fmt:formatDate value="${learnNext.input_dt }" pattern="MM-dd HH:mm" /></td>
						</tr>
					</table>
					
					</form>
				</div>
			</section>
		</div>
		<jsp:include page="/include/footer" />
	</div>
</body>
</html>