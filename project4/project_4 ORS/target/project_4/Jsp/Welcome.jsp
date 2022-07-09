<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="in.co.rays.project4.Ctl.ORSView"%>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html;charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<form action="<%=ORSView.WELCOME_CTL%>">
        <%@ include file="Header.jsp"%>
                    <h1 align="Center">
                    <br>
                      <br>
                        <br>
                          <br>
                            <br>
                        <font size="10px" color="red">Welcome to ORS </font>
                    </h1>
                </form>
        <br><br><br><br><br><br><br>
        <%@ include file="Footer.jsp"%>
</body>
</html>
