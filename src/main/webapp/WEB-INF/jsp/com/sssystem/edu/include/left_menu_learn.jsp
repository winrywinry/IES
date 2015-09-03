<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page trimDirectiveWhitespaces ="true" %>
<%@page import="com.sssystem.edu.vo.LearnVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script type="text/javascript" src="${initParam.root }/tefra-navgoco-66ef209/jquery.navgoco.js"></script>
<link rel="stylesheet" type="text/css" href="${initParam.root }/tefra-navgoco-66ef209/jquery.navgoco.css" media="screen" />
<script type="text/javascript">
$(function() {
	// Initialize navgoco with default options
	$("#eduMenuList").navgoco({accordion: true});
});
</script>

<aside id="left">
	<h3>±³À°</h3>
	<div style="width:100%; padding:0;">
	<ul id="eduMenuList" class="nav">
		<c:set var="lev" value="-1" />
		<c:forEach var="li" items="${list }" varStatus="status">
			<c:if test="${li.LEV != '1' and li.LEV != lev }">
			<ul>
			</c:if>
			<li><a href="/IES/learn/list?dept=${li.DEPT_NO }&category=${li.CATEGORY_NO > -1 ? li.CATEGORY_NO : ''}" > ${li.REF_NO == 0 ?li.DEPT_NM:li.CATEGORY_NM }</a>
			<c:if test="${li.LEV == '1' and li.LEV != lev }">
			<ul>
				<li><a href="/IES/learn/list?dept=${li.DEPT_NO }&category=${li.CATEGORY_NO > -1 ? li.CATEGORY_NO : ''}">${li.CATEGORY_NM }</a>
			</c:if>
			<c:set var="lev" value="${li.LEV }" />
			<c:if test="${fn:length(list) == status.count }"></ul></c:if>
		</c:forEach>
	</ul>
	</div>
</aside>