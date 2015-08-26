<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="com.sssystem.edu.vo.BoardVO"%>
<%@page import="com.sssystem.edu.vo.ReplyVO"%>
<%-- <%@page import="kr.or.sssystem.edu.board.model.beans.CheckAuthBean"%> --%>
<%@page import="com.sssystem.edu.vo.support.SessionVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="board.css" />
<title>Insert title here</title>
<%BoardVO board = (BoardVO)request.getAttribute("board");%>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.3/jquery.min.js"></script>
<script type="text/javascript" src="../js/ajax.js"></script>
<script type="text/javascript">
	
	function delConfirm() {
	    if (confirm("삭제하시겠습니까?")){
	       location.href='/iessvn/qna/deleteForm.do?no=${qnaboard.qna_no }&board_gb=${param.board_gb }';
	    } else {
	       return false;
	    }
	 }   
	
	function replyAdd(){//리플 추가
	  	var params='content='+document.addForm.content.value+'&board_no='+${param.no};
	  	new ajax.xhr.Request('/iessvn/board/reply.do?action=insert',params,
	  			                       replyAddResult,'POST');    	
	   }
   
   function replyAddResult(xhr){
  	if(xhr.readyState==4 && xhr.status==200){	
        document.addForm.content.value='';
  	  var doc =	xhr.responseXML;
  	  var jsonTxt = doc.getElementsByTagName("data").item(0).firstChild.nodeValue;
  	  var jsonObj = eval("("+jsonTxt+")");
  	  var newDiv = makeDiv(jsonObj);
  	  var replyList = document.getElementById('replyList');
  	  replyList.appendChild(newDiv);
  	}
   }//replyAddResult

   
   
function setReplyList(){//리플 출력
   	var params='no='+${param.no}+'&action=list'
   new ajax.xhr.Request('/iessvn/board/reply.do',params,replyListResult,'POST');
    }
function replyListResult(xhr){
   	if(xhr.readyState==4 && xhr.status==200){
   	   var list = eval(xhr.responseText);
   	   var replyList = document.getElementById('replyList');
   	   for(var i=0; i<list.length; i++){
   		 var newDiv = makeDiv(list[i]);
   		 replyList.appendChild(newDiv);
   	   }
   	}
}//replyListResult


function replyUpdate(){//수정요청
 	var no = document.updateForm.no.value;
 	var name = document.updateForm.name.value;
 	var content = document.updateForm.content.value;
 	var params = 'comment_no='+no+'&content='+content+'&name='+name;
 	
    new ajax.xhr.Request('/iessvn/board/reply.do?action=update',params,replyUpdateResult,'POST');
  } 
  
 function replyUpdateResult(xhr){
 	if(xhr.readyState==4 && xhr.status==200){
 	   var doc = xhr.responseXML;
 	   var result = 
 		   doc.getElementsByTagName('code').item(0).firstChild.nodeValue;
 	   //result: "success", "fail"
 	   if(result=='success'){
 		 var dataText = doc.getElementsByTagName('data').item(0).firstChild.nodeValue;
 		 var dataJson =  eval('('+dataText+')');
 		 var upDiv = makeDiv(dataJson);//변경될 DIV
 		 var oldDiv = document.getElementById('r'+dataJson.no);//기존 DIV
 		 
 		 //수정폼 모시기와 감추기
 		  var replyUpdate = document.getElementById('replyUpdate');
 		  document.documentElement.appendChild(replyUpdate);
 		  replyUpdate.style.display='none';
 		 oldDiv.parentNode.replaceChild(upDiv,oldDiv);
 	   }else{
 		  alert(
 		   doc.getElementsByTagName('msg').item(0).firstChild.nodeValue		   
 		   );
 	   }
 	}    	 
  }//replyUpdateResult


  function makeDiv(reply){//DIV생성
  	var replyDiv = document.createElement('div');
  	    replyDiv.className='reply'; //<div class=reply>
  	    replyDiv.setAttribute('id','r'+ reply.no);//<div class=reply id=r13><input type="" name=""></div>
  //	var html = '<input type="hidden" value='+reply.name+' name=hide'+reply.no+'><b>'+reply.name+'</b><br>'+
  	var html = '<table class="replyTab"><tr><th class="left"><b>'+reply.name+'</b> <a style="font-size: 5px;">'+reply.input_dt+'</a></th>'+
  '<th class="right"><a class="right"><a class="link1" onclick="viewUpdateForm('+reply.no+')">수정</a> | '+
 ' <a class="link1" onclick="replyDelete('+reply.no+')">삭제</a></a></th></tr>'+
  	   '<tr><td colspan="2" class="left"><br>'+reply.content.replace(/\n/g,'<br>')+'</td><td></td></tr>';
  	replyDiv.innerHTML = html;
      replyDiv.reply = reply;
  	return replyDiv;
   }//makeDiv

  
  function viewUpdateForm(no){//수정버튼 클릭시 댓글 아래에 수정폼 출력
	   
  	var replyUpdate = document.getElementById('replyUpdate');
	var upDiv = document.getElementById("r"+no);
	upDiv.appendChild(replyUpdate);
	document.updateForm.no.value=upDiv.reply.no;
	document.updateForm.content.value=upDiv.reply.content;    	 
	document.updateForm.name.value=upDiv.reply.name;    	 
	replyUpdate.style.display='';
   }//viewUpdateForm

 
   function replyDelete(no){
		if(!confirm('댓글을 삭제하시겠습니까?'))return;
	 	var param = 'comment_no='+no;
	    new ajax.xhr.Request('/iessvn/board/reply.do?action=delete',param,
	     replyDeleteResult,'POST');
  }//replyDelete
 
   function replyDeleteResult(xhr){
   	if(xhr.readyState==4 && xhr.status==200){
   	$('#replyList').empty();
   	var replyList = document.getElementById('replyList');
   	setReplyList();
   		} 
   }
	     
  
window.onload=function(){
	 setReplyList();
}
</script>
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
					<table class="listtop">
						<tr>
							<th height="36px" valign="bottom" style="padding-top:10px;"><h3>${board.title }</h3></th>
							<td width="15%"><fm:formatDate value="${board.input_dt }" pattern="yyyy-MM-dd HH:mm" /></td>
						</tr>
					</table>
					<form name ="frmBoard" >
					<input type="hidden" name="board_no" value="${param.board_no}">
					<table cellpadding="0" cellspacing="0" class="contentTab">
						<tr>
							<c:if test="${board.board_gb == 10 }">
							<th width="15%">${board.user_no }</th>
							<td><a href = "#">${user.user_no }</a></td>
							<th width="10%">조회수</th>
							<td width="10%">${board.view_cnt }</td>
							</c:if>
							<c:if test="${board.board_gb == 30 }">
							<th width="15%">조회수</th>
							<td width="85%">${board.view_cnt }</td>
							</c:if>
						</tr>
						<tr>
							<th width ="15%" style="height: 300px">내용</th>
							<td colspan="5" valign="top" class="left"><div>${board.contents }</div></td>
						</tr>
					</table>
					<br>
					<span style="font-size: 80%; font-weight: bolder; float: right;">
						<c:if test="${(user.user_no==board.user_no)||manage.manage_yn==1}">
							<a class="link1" onclick="delConfirm()" >삭제</a> | 
						</c:if>
						<c:if test="${user.user_no==board.user_no }">
							<a class="link1" onclick="location.href='/iessvn/board/updateForm.do?no=${board.board_no }&board_gb=${param.board_gb }';">수정</a> | 
						</c:if>
						<a class="link1" onclick="location.href='/iessvn/board/list.do?board_gb=${board.board_gb}';">목록으로</a>
					</span>	
				</form>
					<!-- 댓글 -->
	 				<br>
					 <table class="replyBorder">
						 <tr>
							 <td class="left">
							 	<div id="replyList">
							 	</div>
							 </td>
						 </tr>
						<tr>
							<td>
	   							<div id="replyAdd">
								   <form name="addForm">
								      <textarea rows="3" cols="20" name="content" class="replyText" placeholder="댓글 작성 시 타인에 대한 배려와 책임을 담아주세요"></textarea>
								     <input type="button" value="등록" onclick="replyAdd()" class="css_btn_class">
								   </form>
								</div>
							</td>
						</tr>
					</table>
				<div id="replyUpdate" style="display:none;">
					<form name="updateForm">
						<input type="hidden" name="no">
						<input type="hidden" name="name">
						수정내용: <textarea rows="3" cols="20" name="content"></textarea><br>
						<input type="button" value="등록" onclick="replyUpdate()" class="css_btn_class">
					</form>
				</div>
<!-- 다음글/이전글 -->
				<table class="moveTab">
					<tr>
						<td width="20%"><img src='/iessvn/images/up.png' /> 이전글</td>
						<td width="50%" class="left">
						<c:choose>
							<c:when test="${board.pre_idx==0 }">
							이전글이 없습니다
							</c:when>
							<c:otherwise>
							<a href="/iessvn/board/view.do?board_gb=${board.board_gb}&no=${board.pre_idx }">${board.pre_title }</a>
							</c:otherwise>
						</c:choose>
						</td>
						<td width="30%">
						<c:choose>
							<c:when test="${board.pre_dt=='Sat Nov 11 00:00:00 KST 1111' }">
							</c:when>
							<c:otherwise>
							<fm:formatDate value="${board.pre_dt }" pattern="yyyy-MM-dd'<br>'a hh:mm"/>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
					<tr>
						<td><img src='/iessvn/images/down.png' /> 다음글</td>
						<td width="50%" class="left">
						<c:choose>
							<c:when test="${board.next_idx==0 }">
							다음글이 없습니다
							</c:when>
							<c:otherwise>
							<a href="/iessvn/board/view.do?board_gb=${board.board_gb}&no=${board.next_idx }">${board.next_title }</a>
							</c:otherwise>
						</c:choose>
						</td>
						<td width="30%">
						<c:choose>
							<c:when test="${board.next_dt=='Sat Nov 11 00:00:00 KST 1111' }">
							</c:when>
							<c:otherwise>
							<fm:formatDate value="${board.next_dt }" pattern="yyyy-MM-dd'<br>'a hh:mm"/>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</table>
			</div>
		</section>
	</div>
	<jsp:include page="/include/footer" />
</div>
</body>
</html>