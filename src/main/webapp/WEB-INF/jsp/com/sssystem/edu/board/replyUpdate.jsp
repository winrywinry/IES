<?xml version='1.0' encoding='EUC-KR'?>
<%@page import="com.sssystem.edu.vo.ReplyVO"%> 
<%@ page language="java" contentType="text/xml; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%-- 0724/replyUpdate.jsp --%>
<% 
if(request.getAttribute("reply") != null){%>
<result>
  <code>success</code>
  <data><![CDATA[
    {
       name:'${reply.user_nm }',
       no:${reply.comment_no},
       user_no:${reply.user_no},
       input_dt:${reply.input_dt},
       content:'${reply.contents }'
    }
  ]]></data>
</result>
<%}else{ %>
<result>
  <code>fail</code>
  <msg>수정에 실패했습니다</msg>
</result>
<%} %>



