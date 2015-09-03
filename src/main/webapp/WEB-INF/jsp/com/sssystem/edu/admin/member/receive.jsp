<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    	 request.setCharacterEncoding("UTF-8"); 
       System.out.print(request.getAttribute("result"));
       int result = Integer.parseInt(request.getAttribute("result").toString());
       String user_nm = (String) request.getAttribute("user_nm");
       Date birth_dt = (Date) request.getAttribute("birth");
       String birth = new SimpleDateFormat("yyyy-MM-dd").format(birth_dt);
       System.out.println(user_nm);
       System.out.println(birth);
       if (user_nm == null || user_nm.equals("")) user_nm = "unknown";
       if (birth == null || birth.equals("")) birth = "unknown";
       
       StringBuffer str = new StringBuffer();
       str.append("<?xml version='1.0' encoding='UTF-8'?>");
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