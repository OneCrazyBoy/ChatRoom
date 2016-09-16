<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
session.invalidate();  //注销session,即用户退出
response.sendRedirect("index.jsp");   //跳转到欢迎页面
%>