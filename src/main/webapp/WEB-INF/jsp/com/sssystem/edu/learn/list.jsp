<%@page import="com.sssystem.edu.vo.LearnVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>
<jsp:useBean id="toDay" class="java.util.Date" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="${initParam.root }/css/learn.css" />
<title>Insert title here</title>
<script type="text/javascript">
	window.onload=function(){
	    if(document.searchFrm.dept_no.value=="1000"){
	    	document.getElementById("listtitle").innerHTML = "�ѹ���";
	    }else if(document.searchFrm.dept_no.value=="2000"){
	    	document.getElementById("listtitle").innerHTML = "������";
	    }else if(document.searchFrm.dept_no.value=="3000"){
	    	document.getElementById("listtitle").innerHTML = "������";
	    }else if(document.searchFrm.dept_no.value=="4000"){
	    	document.getElementById("listtitle").innerHTML = "��ȹ��";
	    }else if(document.searchFrm.dept_no.value=="5000"){
	    	document.getElementById("listtitle").innerHTML = "�����";
	    }else if(document.searchFrm.dept_no.value=="6000"){
	    	document.getElementById("listtitle").innerHTML = "�λ��";
	    }else if(document.searchFrm.dept_no.value=="7000"){
	    	document.getElementById("listtitle").innerHTML = "�����";
	    }
		};

	function formchk() {
		oEditors.getById["ta1"].exec("UPDATE_CONTENTS_FIELD", []);
		return true;
	}
	
	function jsGoPage(p,param){
	       location.href= "list?page="+ p + param;
	}
	function viewPage(no, param) {
			location.href="contentsView?no="+ no + param;
	}

</script>
</head>
<body> 
	<div id="wrap">
		<jsp:include page="/include/header" />
		<div id="content">
			<jsp:include page="/include/left_menu_learn" />
			<section id="cen">
			
						<!-------------------------------------�˻�------------------------------------------------------------------>
				<div id="center">
				<form name="searchFrm" action="/IES/learn/list" method="POST" onsubmit="return formchk();" id="searchFrm">
					<input type="hidden" name="dept_no" value="${pageBean.dept_no }" />
						<table class="listtop">
							<tr>
								<th valign="bottom" style="padding-top:10px;"><h3><div id="listtitle">����</div></h3></th>
								<td>
								<td width="20%"><input type="text" name="searchWord" value="${pageBean.searchWord }"></td>
								<td width="6%" id="text"><img src="../images/glasses2.png" onclick="document.searchFrm.submit();"></td>
								<td width="6%"><a href="write"><img src="../images/write.png"></a></td>
							</tr>
						</table>
					</form>
					
				<!-------------------------------------����Ʈ���-------------------------------------------------------------->
					<table class="listTab">
						<tr>
							<th width="10%">��ȣ</th>
							<th>����</th>
<!-- <th width="100">�н�����</th> -->
							<th width="20%">�ۼ���</th>
							<th width="10%">��ȸ��</th>
<!-- <th width="8%">��õ��</th> -->
						</tr>
						<c:set var="firstNo" value="${pageBean.total - ((pageBean.page_no-1) * 10) }" />
						<c:forEach var="learn" items="${list}">
						<fmt:formatDate value="${toDay}" pattern="yyyy-MM-dd" var="tod"/>
						<fmt:formatDate value="${learn.input_dt }" pattern="yyyy-MM-dd" var="inp" />
						<tr>
							<td>
							${firstNo }<br/>
							<c:set var="firstNo" value="${firstNo-1 }"/>
							</td>
							<td class="left">
								<c:if test="${learn.essential_yn == 1}">
								<font color="red">[�ʼ�]</font>
								</c:if>
								<a href="#" onclick="viewPage(${learn.edu_no }, '&page=${pageBean.page_no }&dept_no=${pageBean.dept_no}&searchWord=${pageBean.searchWord}');">${learn.title }</a>
								<c:if test="${inp == tod}">
								<img src='/IES/images/new.jpg' />
								</c:if>
							</td>
<!-- <td>�н�����....</td> -->
							<td><fmt:formatDate value="${learn.input_dt }" pattern="yyyy-MM-dd HH:mm" /></td>
							<td>${learn.view_cnt}</td>
<%-- <td>${learn.favorite_cnt }</td> --%>
						</tr>	
						</c:forEach>
					</table>
					<br><br>
					<custom:paging page="${pageBean.page_no}" totalCnt="${pageBean.total}" par="&dept_no=${pageBean.dept_no}&searchWord=${pageBean.searchWord}"></custom:paging>
				</div>
			</section>
		</div>
		<jsp:include page="/include/footer" />
	</div>
</body>
</html>