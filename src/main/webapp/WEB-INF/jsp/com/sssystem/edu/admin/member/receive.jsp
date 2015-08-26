<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/xml; charset=euc-kr"
    pageEncoding="euc-kr"%>
<%
    	request.setCharacterEncoding("euc-kr");
       System.out.print(request.getAttribute("result"));
       int result = Integer.parseInt(request.getAttribute("result").toString());
       String user_nm = (String) request.getAttribute("user_nm");
       String birth = (String) request.getAttribute("birth");
       System.out.print(birth);
       if (user_nm == null || user_nm.equals("")) user_nm = "unknown";
       if (birth == null || birth.equals("")) birth = "unknown";
       
       StringBuffer str = new StringBuffer();
       str.append("<?xml version='1.0' encoding='euc-kr'?>");
       str.append("<root>");
       if(result == 0) {
           str.append("true");
	       } else {
         	 str.append("false");
       }
       str.append("<name>" + user_nm + "</name>");
       str.append("<birth>" + birth + "</birth>");
       str.append("</root>");
       
       response.getWriter().write(str.toString());
%>