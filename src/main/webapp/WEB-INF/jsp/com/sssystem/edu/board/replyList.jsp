<%@page import="com.sssystem.edu.vo.ReplyVO"%> 
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   List<ReplyVO> list = (List<ReplyVO>)request.getAttribute("list");

   out.print("[");
   for(int i=0; i<list.size(); i++){
	   ReplyVO reply = list.get(i);
	   out.print("{no:"+ reply.getComment_no()+
		     ",name:'"+reply.getUser_nm()+"',"+
		     "user_no:'"+reply.getUser_no()+"',"+
		     "input_dt:'"+reply.getInput_dt()+"',"+
		     "content:'"+reply.getContents()+"'}");
	   if(i<list.size()-1)out.print(",");    
   }
   out.print("]");
%>





