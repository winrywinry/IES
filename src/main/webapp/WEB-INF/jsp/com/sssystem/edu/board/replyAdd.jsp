<?xml version='1.0' encoding='UTF-8'?>
<%@page import="com.sssystem.edu.vo.ReplyVO"%> 
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 0722/replyAdd.jsp --%>
<% if(request.getAttribute("reply") != null){%>
<result>
  <code>success</code>
  <data><![CDATA[
    {
       no:<%=   ((ReplyVO)request.getAttribute("reply")).getComment_no() %>,
       name: '${reply.user_nm }',
       user_no: '${reply.user_no }',
       input_dt: '${reply.input_dt }',
       content:'${reply.contents }'
    }
  ]]></data>
</result>
<%}else{ %>
<result>
  <code>fail</code>
  <msg>입력실패!!</msg>
</result>
<%} %>



