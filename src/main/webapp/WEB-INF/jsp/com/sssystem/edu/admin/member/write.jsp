<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript" src="${initParam.root }/admin/js/jquery.navgoco.min.js"></script>
<link rel="stylesheet" type="text/css" href="${initParam.root }/admin/css/jquery.navgoco.css" />
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript" src="${initParam.root }/js/postSearch.js"></script>
<script type="text/javascript" src="${initParam.root }/admin/js/formcheck.js"></script>
<link rel="stylesheet" type="text/css" href="${initParam.root }/admin/css/member.css" />
<script type="text/javascript" id="demo2-javascript">
$(document).ready(function() {
	$("#navMenu").navgoco({accordion: true});
	var no = $("input[name='no']").val();
	if (no > 0){
		$("input[name='user_nm']").prop("disabled", true );
		$("input[name='birth']").prop("disabled", true);
		$("input[name='gender_yn']").prop("disabled", true);
		$("input[name='hire']").prop("disabled", true);
		$("#add").text("수정");
	}
	
	if(!no>0){
		$("#delete").hide();
		//$("#error").text("* 이미 등록된 사용자입니다.");
	}
	
	if($("#error").text().length>0){
		$("#addbt").attr("onclick", "return false;");
	}
	
	$("#reset").click(function(){
		if (confirm("취소하시겠습니까?")){
			var origin = $("input[name='origin']").val();
			if (origin != ""){
				$("#profil").prop("src", "/IES/images/profile/"+origin);
			} else {
				$("#profil").prop("src", "");
			}
			return true;
		} else {
			return false;
			
		}
	})
});

function del(){
	if (confirm("정말 삭제하시겠습니까??")){    //확인
		location.href="./delete?no="+document.insertFrm.no.value;
	}else{   //취소
	    return;
	}
}
</script>
<script type="text/javascript">
    
    var xmlReq; // 전역변수로 지정.
    // Ajax 객체 생성 과정
    function createAjax() {
        xmlReq = new XMLHttpRequest();
    }
     
    // Ajax 객체를 이용한 데이터 전송 과정
    function ajaxSend() {
       createAjax();
       var user_nm = document.getElementById("user_nm").value;
       var birth = document.getElementById("birth").value;
	       xmlReq.onreadystatechange = callBack; // 괄호 열고닫고가 틀리다.!
	       xmlReq.open("GET", "receive?user_nm="+user_nm+"&birth="+birth, true);
	       xmlReq.send(null);
       // send가 끝나고나면 비동기식이기 때문에 프로그램이 계속 진행된다.
   }
    
   // 콜백 함수 과정
   function callBack() {
       if(xmlReq.readyState == 4) {
           if(xmlReq.status == 200) {
               printData();
           }
       }
   }
    
   // 결과 출력 과정
   function printData() {
       var result = xmlReq.responseXML;
       
       var rootNode = result.documentElement;
       // <root>true</root> , <root>false</root>
       var rootValue = rootNode.firstChild.nodeValue;
       var rootTag = document.getElementById("error");
       
       var nameNode = rootNode.getElementsByTagName("name");
       var nameValue = nameNode.item(0).firstChild.nodeValue;
       var birthValue = rootNode.getElementsByTagName("birth").item(0).firstChild.nodeValue;

       if (nameValue != 'unknown' && birthValue != 'unknown'){
	       if(rootValue == "true") {
	           rootTag.innerHTML = "<font color=blue>* 등록 가능한 사용자입니다.</font>";
	       } else {
	           rootTag.innerHTML = "* 이미 등록된 사용자입니다.";
	       }
       } else {
    	   rootTag.innerHTML = "";
       }
   }
</script>
<html:messages id="msgs" property="errors">
<script type="text/javascript">alert('<bean:write name="msgs"/>');</script>
</html:messages>
<title>관리자 : 회원관리 - 사내교육시스템</title>
</head>
<body>
<div id="wrap">
	<jsp:include page="/admin/include/header"></jsp:include>
	<section>
		<div id="content">
			<div id="top">
				<h3>회원관리</h3><span id="error" style="margin-left:20px"></span>
			</div>
			<form method="post" name="insertFrm" action="/IES/admin/member/writeAction" onsubmit="return Formchk(this)" novalidate="novalidate" enctype="multipart/form-data">
			<input type="hidden" name="page" value="${page }" />
			<input type="hidden" name="no" value="${member.user_no }"/>	
			<div id="con">
				<fmt:formatDate var="nowDate" value="${nowDate }" pattern="yyyy-MM-dd" />
				<table border="0" cellspacing="0" cellpadding="0" class="viewTable">
					<tr>
						<th width="100">이름</th>
						<td width="150"><input type="text" id="user_nm" name="user_nm" class="txt" maxlength="20" value="${member.user_nm }" required  onkeyup="ajaxSend()"/></td>
						<th width="100">생년월일</th>
						<td width="150">
							<fmt:formatDate var="birth_dt" value="${member.birth_dt }" pattern="yyyy-MM-dd" />
							<input type="date" id="birth" class="txt" value="${birth_dt }" max="${nowDate }" onchange="ajaxSend()"/></td>
						<th width="100">성별</th>
						<td>
							<input type="radio" name="gender_yn" value="0" id="gender_0" ${member.gender_yn == 0?'checked':'' } onfocus="ajaxSend()" /><label for="gender_0">남</label>
							<input type="radio" name="gender_yn" value="1" id="gender_1" ${member.gender_yn == 1?'checked':'' } onfocus="ajaxSend()" /><label for="gender_0">여</label>
						</td>
					</tr>
					<tr>
						<th>입사일</th>
						<td>
							<fmt:formatDate var="hiredate" value="${member.hiredate }" pattern="yyyy-MM-dd" />
							<input type="date" name="hire" class="txt" max="${nowDate }" value="${member.hiredate != null ? hiredate : nowDate }" />
						</td>
						<th>부서/직책</th>
						<td colspan="3">
							<select name="dept">
								<option value="">::부서::</option>
							<c:forEach var="dept" items="${dept }">
								<option value="${dept.dept_no }"<c:if test="${member.dept_no == dept.dept_no }"> selected</c:if>>${dept.dept_nm }</option>
							</c:forEach>
							</select>
							<select name="job">
								<option value="">::직책::</option>
							<c:forEach var="job" items="${job }">
								<option value="${job.job_no }"<c:if test="${member.job_no == job.job_no }"> selected</c:if>>${job.job_nm }</option>
							</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>연락처</th>
						<td><input type="text" pattern="\d{3}\-\d{4}\-\d{3}" name="phone_no" maxlength="13" class="txt" value="${member.phone_no }" /></td>
						<th>비상연락처</th>
						<td><input type="text" pattern="\d{3}\-\d{4}\-\d{3}" name="second_no" maxlength="13" class="txt" value="${member.second_no }" /></td>
						<th>내선</th>
						<td><input type="text" pattern="\d{3}\-\d{4}\-\d{3}" name="line_no" maxlength="13" class="txt" value="${member.line_no }" /></td>
					</tr>
					<tr>
						<th>주소</th>
						<td colspan="5">
							<input type="tel" name="post" id="addrcode" readonly pattern="\d{3}\-\d{3}" maxlength="7" class="txt" value="${member.post }" /> <a href="javascript:execDaumPostcode();" class="css_btn_small">우편번호찾기</a><br />
							<input type="text" name="address" id="addr" class="txt1" value="${member.address }" />
						</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td colspan="3"><input type="email" name="email" class="txt1" maxlength="20" value="${member.email }" /></td>
						<th>권한</th>
						<td>
							<c:if test="${member.manage_yn == 1 }"><c:set var="manage_yn" value="checked" /></c:if>
							<c:if test="${member.admin_yn == 1 }"><c:set var="admin_yn" value="checked" /></c:if>
							<input type="checkbox" name="manage_yn" value="1" id="manage_yn" ${manage_yn } /><label for="manage_yn">Manager</label>
							<input type="checkbox" name="admin_yn" value="1" id="admin_yn" ${admin_yn } /><label for="admin_yn">Admin</label> 
						</td>
					</tr>
					<tr>
						<th>사진</th>
						<td colspan="5">
							<input type="hidden" name="origin" value="${member.profil_picture }" />
							<c:set var="origin_pic" value="/IES/images/profile/${member.profil_picture }" />
							<c:if test="${member.profil_picture != null }"><c:set var="profil_url" value="/IES/images/profile/${member.profil_picture }" /></c:if>
							<img id="profil" src="${profil_url }" width="150" height="200" /><br /><input type="file" name="profil_picture" id="profil_picture" onchange="imageURL(this)" /></td>
					</tr>
				</table>
				
				<div id="left">
					<a href="list?page=${page }" class="css_btn_class">목록</a>
				</div>
				<div id="right">
					<a onclick="document.insertFrm.submit();" class="css_btn_class" id="addbt"><span id="add">추가</span></a>
					<a onclick="del();" class="css_btn_class" id="delete">삭제</a>
					<a onclick="document.insertFrm.reset();" class="css_btn_class" id="reset"><span id="re">초기화</span></a>
				</div>
			</div>
			</form>
			<div id="bot">
			</div>
		</div>
	</section>
	<jsp:include page="/admin/include/footer"></jsp:include>
</div>
</body>
</html>