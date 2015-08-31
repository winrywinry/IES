<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<logic:notPresent scope="session" name="user">
<%-- <c:redirect url="/member/login.do" ></c:redirect> --%>
</logic:notPresent>
<!DOCTYPE html>	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<link href='${initParam.root }/fullcalendar-2.3.2/fullcalendar.css' rel='stylesheet' />
<link href='${initParam.root }/fullcalendar-2.3.2/fullcalendar.print.css' rel='stylesheet' media='print' />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script src='${initParam.root }/fullcalendar-2.3.2/lib/moment.min.js'></script>
<script src='${initParam.root }/fullcalendar-2.3.2/fullcalendar.min.js'></script>
<script type="text/javascript" src="${initParam.root }/js/fullcalendar.js"></script>

<link rel="stylesheet" type="text/css" href="${initParam.root }/css/index.css" />
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
    $( "#summary" ).sortable({
        revert: true
      });
      $( "dl, dd" ).disableSelection();
});
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="/include/header" />
		<div id="content">
			<section id="cen">
				<div id="top">
					<div id="userInfo" class="left">
					<dl>
						<dt class="prfl_thmb">
						<img src="${initParam.root }/images/iu.jpg" />
						<div class="mask"></div>
						</dt>
						<dd><em>${user.user_nm }</em> ��</dd>
						<dd>ȸ���������� | <a href="${initParam.root }/member/login" onclick="return confirm('�α׾ƿ� �Ͻðڽ��ϱ�?');">�α׾ƿ�</a></dd>
					</dl>
					<p>�⼮��<span>${log }</span></p>
					<p>�����̼�<span></span></p>
					<p>��������<span></span></p>
					<p>�Խñۼ�<span>${write }</span></p>
					<p>������<span>${question }</span></p>
					<p>��ۼ�<span>${reply }</span></p>
					</div>
					<div id="imgSection" class="right">
						<img src="${initParam.root }/images/5.png" alt="��������" />
					</div>
				</div>
				<div id="mid">
					<p><span class="title">��������</span>
					${notice } </p>
				</div>
				<div id="bot">
					<div id="calendar" class="left"><div id="calendar"></div></div>
					<div id="summary" class="right">
						<dl>
							<dt>�ֱ� �̼� ����</dt>
							<dd>���� �ʱ� ���� 1</dd>
							<dd>���� �ʱ� ���� 1</dd>
							<dd>���� �ʱ� ���� 1</dd>
							<dd>���� �ʱ� ���� 1</dd>
							<dd>���� �ʱ� ���� 1</dd>
							<dd>���� �ʱ� ���� 1</dd>
						</dl>
						<dl>
							<dt>�̼� ���� ����</dt>
							<dd>���� �ʱ� ���� 1</dd>
							<dd>���� �ʱ� ���� 1</dd>
							<dd>���� �ʱ� ���� 1</dd>
							<dd>���� �ʱ� ���� 1</dd>
							<dd>���� �ʱ� ���� 1</dd>
							<dd>���� �ʱ� ���� 1</dd>
						</dl>
						<dl>
							<dt>���� ����</dt>
							<c:forEach var="title" items="${myWriteView }">
							<dd>${title }</dd>
							</c:forEach>
						</dl>
						<dl>
							<dt>���� �Խñ�</dt>
							<c:forEach var="title" items="${myQuestionView }">
							<dd>${title }</dd>
							</c:forEach>
						</dl>
						<dl>
							<dt>���� ���</dt>
							<c:forEach var="contents" items="${replyContents }">
							<dd>${contents }</dd>
							</c:forEach>
						</dl>
						<dl>
							<dt>���ǻ���</dt>
							<c:forEach var="qnaBoard" items="${recommendView }">
							<dd>${qnaBoard }</dd>
							</c:forEach>
						</dl>
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="/include/footer" />
	</div>
	
</body>
</html>


