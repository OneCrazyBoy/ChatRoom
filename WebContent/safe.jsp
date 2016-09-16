<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%if (null==session.getAttribute("username") || "".equals(session.getAttribute("username")))//判断session是否超期
{
	out.println("<script language='javascript'>alert('您的账户已经过期，请重新登录!');window.location.href='index.jsp';</script>");
	return;
}%>

<!-- 验证用户是不是已经登录，这里要注意“window.location.href='index.jsp'”的的用法 -->