<%@ page language="java" contentType="text/plain; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces ="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
{
	  msg:''
	, data:[
	<c:forEach var="category" items="${categorylist }" varStatus="status">
	${status.count != 1 ? ', ' : '' }{no:${category.category_no }, nm:'${category.category_nm }'}
	</c:forEach>
	]
}
<%--<html:messages id="msg" message="true"><bean:write name="msg"/></html:messages>--%>