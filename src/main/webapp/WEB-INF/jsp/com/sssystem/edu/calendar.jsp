<%@ page language="java" contentType="text/plain; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
[
		
		<c:forEach var="cale" items="${cal }" varStatus="status">
		<fmt:formatDate var="start_dt" value="${cale.period_st }" pattern="yyyy-MM-dd" />
		<fmt:formatDate var="end_dt" value="${cale.period_ed }" pattern="yyyy-MM-dd" />
		{
		  title: '${cale.title}'
		, start: '${start_dt}'
		, url: '/IES/learn/contentsView?no=${cale.edu_no}&page=1&dept_no=0&searchWord='
		<c:if test="${end_dt != null }">, end: '${end_dt}'</c:if>
		}${fn:length(cal) > status.count? ',' : ''}
		</c:forEach>
]