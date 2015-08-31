<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${initParam.root }/admin/js/jquery.navgoco.min.js"></script>
<link rel="stylesheet" type="text/css" href="${initParam.root}/admin/css/jquery.navgoco.css" />
<link rel="stylesheet" type="text/css" href="${initParam.root}/admin/css/member.css" />
<script type="text/javascript" id="demo2-javascript">
$(document).ready(function() {
	$("#navMenu").navgoco({accordion: true});
	$("#checkAll").click(function(){
		if($("#checkAll").prop("checked")){
			$("input[name=check]").prop("checked",true)
		}else{
			$("input[name=check]").prop("checked",false)
		}
	})
});
function jsGoPage(p){
       location.href= "?page="+ p;
}
</script>

<title>관리자 : 회원관리 - 사내교육시스템</title>
</head>
<body>
<div id="wrap">
	<jsp:include page="/admin/include/header"></jsp:include>
	<section>
		<div id="content">
			<div id="top">
				<h3>회원관리</h3>
				
		<!-- ----------------------------------검색창------------------------------------------>
				<div id="search">
					<form name="searchFrm" action="/iessvn/admin/member/list.do" method="POST">
						<input type="hidden" name="page" value="${pageBean.page}">
						<select name="dept_no">
								<option value="0">==부서==</option>
							<c:forEach var="dept" items="${deptlist }">
								<option value="${dept.dept_no }">${dept.dept_nm }</option>
							</c:forEach>
						</select>
						<select name="job_no">
								<option value="0">==직책==</option>
							<c:forEach var="job" items="${joblist }">
								<option value="${job.job_no }">${job.job_nm }</option>
							</c:forEach>
						</select>
						<input type="checkbox" name="manage_yn"/><label for="auth" >Manager</label>
						<input type="checkbox" name="admin_yn"/><label for="admin">Admin</label>
						<input type="text" name="searchWord"/>
						<input type="submit" value="검색" />
					</form>
				</div>
			</div>
			
		<!-- ----------------------------------리스트 출력------------------------------------------>
			<div id="con">
				<table border="0" cellspacing="0" cellpadding="0" class="listTable">
					<tr>
						<th width="40"><input type="checkbox" id="checkAll" /></th>
						<th width="70">사원번호</th>
						<th width="80">이름</th>
						<th width="50">나이</th>
						<th width="60">부서</th>
						<th width="60">직책</th>
						<th width="100">내선</th>
						<th width="100">연락처</th>
						<th width="60">입사일</th>
						<th width="60">가입일</th>
						<th width="30">At.</th>
						<th width="30">Ad.</th>
					</tr>
					<c:forEach var="member" items="${member }">
					<tr>
						<td><input type="checkbox" name="check" value="${member.user_no}"/></td>
						<td>${member.emp_serial }</td>
						<fmt:formatDate value="${member.birth_dt }" var="b_dt" pattern="yyyy-MM-dd" />
						<td><a href="writePage.do?page=${pageBean.page}&no=${member.user_no }&name=${member.user_nm}&birth=${b_dt}&phone_no=${member.phone_no}">${member.user_nm }</a></td>
						<fmt:formatDate var="NowYear" value="${nowDate }" pattern="yyyy" />
						<fmt:formatDate var="BirthYear" value="${member.birth_dt }" pattern="yyyy" />
						<td>${NowYear-BirthYear+1 }
							(<c:choose><c:when test="${member.gender_yn == 1 }">여</c:when><c:otherwise>남</c:otherwise></c:choose>)
						</td>
						<td>${member.dept_nm }</td>
						<td>${member.job_nm }</td>
						<td>${member.line_no }</td>
						<td>${member.phone_no }</td>
						<td><fmt:formatDate value="${member.hiredate }" pattern="yy/MM/dd"/></td>
						<td><fmt:formatDate value="${member.input_dt }" pattern="yy/MM/dd"/></td>
						<td><c:if test="${member.manage_yn == 1 }"><img src="/iessvn/admin/images/check.png" alt="권한자" title="권한자" /></c:if></td>
						<td><c:if test="${member.admin_yn == 1 }"><img src="/iessvn/admin/images/check.png" alt="관리자" title="관리자" /></c:if></td>
					</tr>
					</c:forEach>
			</table>
				<div id="right"><a href="writePage.do?page=${pageBean.page }" class="css_btn_class">사원추가</a></div>
			</div>
			
		<!-- ----------------------------------페이징------------------------------------------>
			<div id="bot">
				<custom:paging page="${pageBean.page }" totalCnt="${pageBean.total }" par="&dept_no=${pageBean.dept_no}&searchWord=${pageBean.searchWord}&job_no=${pageBean.job_no}&manage_yn=${pageBean.manage_yn}&admin_yn=${pageBean.admin_yn }"></custom:paging>
			</div>
			
		</div>
	</section>
	<jsp:include page="/admin/include/footer"></jsp:include>
</div>
</body>
</html>