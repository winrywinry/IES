<%@ page language="java" contentType="text/plain; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
[
		
		<c:forEach var="cale" items="${cal }" varStatus="status">
		<c:set var="start_dt" value="${fn:substring(cale.start_dt, 0, 10) }" />
		<c:set var="end_dt" value="${fn:substring(cale.end_dt, 0, 10) }" />
		{
		  title: '${cale.title}'
		, start: '${start_dt}'
		, url: '/IES/learn/contentsView?no=${cale.edu_no}&page=1&dept_no=0&searchWord='
		<c:if test="${end_dt != '1111-11-11' }">, end: '${end_dt}'</c:if>
		}${fn:length(cal) > status.count? ',' : ''}
		</c:forEach>
]