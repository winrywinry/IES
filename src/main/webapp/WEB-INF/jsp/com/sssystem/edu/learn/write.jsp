<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="learn.css" />
<title>사내교육시스템 - 교육 등록</title>
<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<script type= "text/javascript" src ="/iessvn/js/SEditor.js" charset="euc-kr" ></script>
<script type= "text/javascript" src ="/iessvn/js/common.js" charset="euc-kr" ></script>
<script src="/iessvn/js/jquery-ui.js"></script>
<link href="/iessvn/css/jquery-ui.css" rel="stylesheet">
<script type="text/javascript" src="/iessvn/js/ajax.js"></script>
<script type="text/javascript" src="/iessvn/js/learn.js"></script>
</head>
<body>
	<div id="wrap">
		<%--<jsp:include page="/include/header.jsp" /> --%>
		<div id="content">
			<%--<jsp:include page="/include/left_menu_learn.jsp" /> --%>
			<section id="cen">
				<div id="top">
					<h3>교육 등록</h3>
				</div>
				<div id="con">
					<form action="input.do" name="frm" method="POST" onsubmit="return formchk();">
					<input type="hidden" name="state" value="${update }">
					<input type="hidden" name="edu_no" value="${learn.edu_no }" />
					<input type="hidden" name="dn" value="${learn.dept_no }" />
						<table class="writeTab">
							<tr>
								<th width="15%">제목</th>
								<td>
									<input type="checkbox" id="essential" class="chk" name="essential_yn" value="1"><label for="essential">필수</label>
									<input type="text" name="title" class="txt w750" value="${learn.title}">
								</td>
							</tr>
							<tr>
								<th>열람부서</th>
								<td>
									<ul>
										<li><input type="checkbox" name="dept_all" class="chk chkAll" id="dept_all" /><label for="dept_all"><b>전체</b></label></li>
										<c:forEach var="dept" items="${deptlist }">
										<li><input type="checkbox" name="dept_no" value="${dept.dept_no	}" class="chk" id="dept_${dept.dept_no }" /><label for="dept_${dept.dept_no }">${dept.dept_nm }</label>
										</c:forEach>
									</ul>
								</td>
							</tr>
							<tr>
								<th>열람직책</th>
								<td>
									<ul>
										<li><input type="checkbox" name="job_all" class="chk chkAll" id="job_all" /><label for="job_all"><b>전체</b></label></li>
										<c:forEach var="job" items="${joblist }">
										<li><input type="checkbox" name="job_no" value="${job.job_no }" class="chk" id="job_${job.job_no }" /><label for="job_${job.job_no }">${job.job_nm }</label>
										</c:forEach>
									</ul>
								</td>
							</tr>
							<tr>
							<th>카테고리</th>
								<td>
									<select name="category_no" id="category_no">
										<option value="">::카테고리 선택::</option>
										<c:forEach var="category" items="${categorylist }">
										<option value="${category.category_no }">${fn:replace(category.category_nm, ' ', '&nbsp;') } (${category.category_cnt })</option>
										</c:forEach>
									</select>
									<input type="text" name="category_nm" id="category_nm" maxlength="20" class="txt w150" />
									<ul id="icons">
										<li id="category_mod" class="ui-state-default ui-corner-all" title=".ui-icon-pencil"><span class="ui-icon ui-icon-pencil"></span></li>
										<li id="category_del" class="ui-state-default ui-corner-all" title=".ui-icon-close"><span class="ui-icon ui-icon-close"></span></li>
									</ul>
								</td>
							</tr>
							<tr>
								<th>강의영상</th>
								<td>
									<textarea id="contents_tag" name="contents_tag">${learn.contents_tag}</textarea>
								</td>
							</tr>
							<tr>
								<th>강의내용</th>
								<td>
									<textarea name="contents" id="ta1" style="width :800px; height:200px; display: none;">${learn.contents}</textarea>
								</td>
							</tr>
							<tr>
								<th>개강날짜</th>
								<td class="left">
								<fmt:formatDate value="${learn.period_st}" type="date" pattern="yyyy-MM-dd" var="period_st" />
								<fmt:formatDate value="${learn.period_ed}" type="date" pattern="yyyy-MM-dd" var="period_ed" />
								<input type="text" name="period_st" id="from" value="${period_st}" class="txt w150 cen"> ~ 
								<input type="text" name="period_ed" id="to" value="${period_ed}" class="txt w150 cen" >
								</td>
							</tr>
							<tr>
								<th>첨부</th>
								<td class="left">
									<p><input type="file" name="attach_file" /></p>
								</td>
							</tr>
							<tr>
								<th>이수확인</th>
								<td>
									<a class="css_btn_class" id="test_add" edu="${learn.edu_no }"><span id="sub">추가</span></a><br />
									<ul id="testList">
										<c:forEach var="test" items="${testlist }">
										<li>${test.q_no }. ${test.question } 
											<em><a href="../test/write.do?no=${test.test_no }" onclick="testWinOpen(this.href); return false;">수정</a> | <a href="../test/delete.do?no=${test.test_no }" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</a></em></li>
										</c:forEach>
									</ul>
								</td>
							</tr>
						</table>
						<br>
						<a class="css_btn_class" onclick="submitchk();"><span id="sub">작성</span></a>
						<a class="css_btn_class" onclick="location.href='/iessvn/learn/list.do';">취소</a>
						</form>
					</div>
			</section>
		</div>
		<%--<jsp:include page="/include/footer.jsp" /> --%>
	</div>
</body>
</html>