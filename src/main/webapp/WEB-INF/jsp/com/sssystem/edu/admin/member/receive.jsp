<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    	 request.setCharacterEncoding("UTF-8"); 
       System.out.println(request.getAttribute("result"));
       int result = Integer.parseInt(request.getAttribute("result").toString());
       String phone_no = (String) request.getAttribute("phone_no");
       Date birth_dt = (Date) request.getAttribute("birth");
       String birth = new SimpleDateFormat("yyyy-MM-dd").format(birth_dt);
       System.out.println("p:"+phone_no);
       System.out.println("b:"+birth);
       if (phone_no == null || phone_no.equals("")) phone_no = "unknown";
       if (birth == null || birth.equals("")) birth = "unknown";
       
       StringBuffer str = new StringBuffer();
       str.append("<?xml version='1.0' encoding='UTF-8'?>");
       str.append("<root>");
       if(result == 0) {
           str.append("true");
	       } else {
         	 str.append("false");
       }
       str.append("<phone>" + phone_no + "</phone>");
       str.append("<birth>" + birth + "</birth>");
       str.append("</root>");
       
       response.getWriter().write(str.toString());
%>