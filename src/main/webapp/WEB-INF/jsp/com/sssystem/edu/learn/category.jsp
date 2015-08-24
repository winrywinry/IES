<%@ page language="java" contentType="text/plain; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces ="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
{
	  msg:'<html:messages id="msg" message="true"><bean:write name="msg"/></html:messages>'
	, data:[
	<c:forEach var="category" items="${categorylist }" varStatus="status">
	${status.count != 1 ? ', ' : '' }{no:${category.category_no }, nm:'${category.category_nm }'}
	</c:forEach>
	]
}