<%@page import="com.sssystem.edu.vo.LearnVO"%>
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
			if (confirm("정말 삭제하시겠습니까??")){    //확인
				location.href="./delete?edu_no="+document.frm.edu_no.value;
			}else{   //취소
			    return;
			}
		}
		
		window.onload=function(){
		    var essential = document.getElementById('essential');//console: Element
		    var e = ${learn.essential_yn};
		    var msg=null;
		    if(e==1){
		    	msg="필수";
		    }else{
		    	msg="선택";
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
							<th width="15%">첨부파일</th>
							<td width="30%"><a class="css_btn_class" onclick="favoriteCnt">추천</a><span>${learn.favorite_cnt}</span></td>
							<th width="10%">필수여부</th>
							<td width="10%"><span id="essential"></span></td>
							<th width="10%">조회수</th>
							<td width="10%">${learn.view_cnt }</td>
						 	<th width="25%">추천수</th>
							<td width="10%">${learn.favorite_cnt}</td>
						</tr>
<%-- 	<tr>
		<th>교육기간</th>
		<td colspan="5"><fmt:formatDate value="${learn.period_st}" pattern="yyyy년 MM월 dd일" /> ~ <fmt:formatDate value="${learn.period_ed}" pattern="yyyy년 MM월 dd일" /></td>
	</tr> --%>
<!--<tr>
 	<th>시작</th>
	<td colspan="5"><input type="button" value="START"><input type="button" id="favorite" value="추천" onclick="setDisable(favorite)"></td>
</tr> -->
						<tr>
							<th style="height: 300px" rowspan="2">내용</th>
							<td colspan="5">
								<iframe width="700	px" height="400px" src="http://www.youtube.com/embed/${learn.contents_tag }" allowfullscreen="allowfullscreen"></iframe>
							</td>
<!-- <td colspan="3" bgcolor="yellow">채팅형 Q&A창</td> -->
						</tr>
						<tr>	
							<td colspan="5">${learn.contents }</td>
<!-- <td colspan="3" bgcolor="pink">부서별 출석여부</td> -->
						</tr>
<!-- 	<tr>
		<th>종료</th>
		<td colspan="5"><input type="button" value="END"></td>
	</tr> -->
					</table>
					<br>
					<span style="font-size: 80%; font-weight: bolder; float: right;">
					<a class="link1" onclick="del()" >삭제</a> | 
					<a class="link1" onclick="location.href='/IES/learn/updatePage?no=${learn.edu_no}&user_no=${learn.user_no}&update=update';">수정</a> | 
					<a class="link1" onclick="location.href='/IES/learn/list';">목록으로</a>
					</span>
					<br><br>
					<table class="moveTab">
						<tr>
							<td width="20%"><img src='/IES/images/up.png' /> 이전글</td>
							<td width="60%" class="left"><a href="contentsView?no=${learnPrev.edu_no}&dept_no=${param.dept_no}&page=${param.page}">${learnPrev.title }</a></td>
							<td width="20%"><fmt:formatDate value="${learnPrev.input_dt }" pattern="MM-dd HH:mm" /></td>
						</tr>
						<tr>
							<td><img src='/IES/images/down.png' /> 다음글</td>
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