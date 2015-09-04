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
			<li class="${li.DEPT_NO == param.dept_no? 'active' : '' }"><a href="/IES/learn/list?dept_no=${li.DEPT_NO }" > ${li.DEPT_NM }</a>
		</c:forEach>
	</ul>
	</div>
</aside>