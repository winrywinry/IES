<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<title>사내교육시스템 - 이수시험 등록</title>
<script type="text/javascript">
var jsonData = { 
		no : '${testBean.q_no }'
		, test_no : '${testBean.test_no }'
		, question : '${testBean.question }'
};
</script>
<c:if test="${status eq 'insert' }">
<script type="text/javascript">
opener.addTest(jsonData);
if (confirm("계속해서 등록하시겠습니까?")) {
	location.href="write.do"
} else {
	window.close();
}
</script>
</c:if> 
<c:if test="${status eq 'update' }">
<script type="text/javascript">
opener.modTest(jsonData);
window.close();
</script>
</c:if>
<c:if test="${status eq 'delete' }">
	<c:if test="${msg != null }">
		<script type="text/javascript">alert("${msg}");</script>
	</c:if>
<script type="text/javascript">
parent.delTest(jsonData);
</script>
</c:if>
</head>
<body>
</body>
</html>