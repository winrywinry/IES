<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src= "//code.jquery.com/jquery-1.11.3.min.js" ></script>
<script src= "//code.jquery.com/jquery-migrate-1.2.1.min.js" ></script>
<script type="text/javascript" src="/iessvn/js/ajax.js"></script>
<title>사내교육시스템 - 이수시험 등록</title>
<script type="text/javascript">
function getData(){
	new ajax.xhr.Request("result.jsp", "", categoryList, "POST");
}
</script>
</head>
<body>

</body>
</html>