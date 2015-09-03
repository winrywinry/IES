<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.sssystem.edu.vo.LearnVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="custom" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>
    <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
 	<script type="text/javascript" src="${initParam.root }/js/jquery.navgoco.js"></script>
	<link rel="stylesheet" type="text/css" href="${initParam.root}/admin/css/jquery.navgoco.css" />
	<script type="text/javascript" id="demo2-javascript">
	$(document).ready(function() {
		// Initialize navgoco with default options
		$("#eduMenuList").navgoco({
			caretHtml: '',
			accordion: false,
			openClass: 'open',
			save: true,
			cookie: {
				name: 'navgoco',
				expires: false,
				path: '/'
			},
			slide: {
				duration: 400,
				easing: 'swing'
			},
			// Add Active class to clicked menu item
			onClickAfter: function(e, submenu) {
				e.preventDefault();
				$('#eduMenuList').find('li').removeClass('active');
				var li =  $(this).parent();
				var lis = li.parents('li');
				li.addClass('active');
				lis.addClass('active');
			},
		});

		$("#collapseAll").click(function(e) {
			e.preventDefault();
			$("#eduMenuList").navgoco('toggle', false);
		});

		$("#expandAll").click(function(e) {
			e.preventDefault();
			$("#eduMenuList").navgoco('toggle', true);
		});
	});
	</script>

<aside id="left">
	<h3>����</h3>
	<ul id="eduMenuList" class="nav">
		<li><a href="#"> �μ�</a>
			<ul>
			<c:forEach items="${list }" var="li">
				<li><a href="/IES/learn/list?dept_no=1000"> ${li.dept_nm}</a></li><br>			
			</c:forEach>
				<ul>
					<c:forEach items="${li }" var="li">
						<li><a href="#"> ${li.category_nm }</a></li><br>
					</c:forEach>
				</ul>
<!-- 				<li><a href="/IES/learn/list?dept_no=2000"> ������</a></li><br>
				<li><a href="/IES/learn/list?dept_no=3000"> ������</a></li><br>
				<li><a href="/IES/learn/list?dept_no=4000"> ��ȹ��</a></li><br>
				<li><a href="/IES/learn/list?dept_no=5000"> �����</a></li><br>
				<li><a href="/IES/learn/list?dept_no=6000"> �λ��</a></li><br> -->
				<li><a href="/IES/learn/list?dept_no=7000"> �����</a>
					<ul>
						<li><a href="#"> ������</a></li><br>
						<li><a href="#"> �λ繮��</a></li><br>
						<li><a href="#"> �繫�μ�</a></li><br>
						<li><a href="#"> ����</a></li><br>
					</ul>
				</li>
			</ul>
		</li>
	</ul>				
</aside>