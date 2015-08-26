<?xml version='1.0' encoding='EUC-KR'?>
<%@page import="com.sssystem.edu.vo.ReplyVO"%> 
<%@ page language="java" contentType="text/xml; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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



