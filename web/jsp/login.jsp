<%@ page import="shop.user.User" %><%--
  Created by IntelliJ IDEA.
  User: DAMIR
  Date: 15.10.2020
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Login</title>
    <style>
        input[type = submit] {
            background-color: orange;
            text-decoration: none;
            color: white;
            padding: 10px 20px;
            cursor: pointer;
            width: 160px;
        }
        body{
            background: url("https://b2bjewelry.com.ua/assets/images/2019/registration.jpg");
            background-position: center;
            background-size: cover;
            background-repeat: no-repeat;
            height: 100vh;
            min-height: 100vh;
            width: 100%;
            flex-direction: column;
        }

    </style>
</head>
<body>
<div style="display: inline-grid;grid-template-columns: 1fr 1fr; grid-gap: 50px; margin-left: 650px; margin-top: 320px">
    <fieldset style="width: 150px;background-color: mediumpurple">
        <h3 style="color: black;">Authorization</h3>
        <%
            if (session.getAttribute("user")==null){
                User user = (User) session.getAttribute("user");
        %>

        <form method="post" action="<%=request.getContextPath()%>/UserServlet">
            <input type="text" name="login" placeholder="Login"><br><br>
            <input type="password" name="password" placeholder="Password"><br><br>
            <input type="submit" name="logIn" value="Login">
        </form>
        <div>
            <p>
                <%
                    if (session.getAttribute("err")!=null){
                        out.println(session.getAttribute("err"));
                    }
                %>
            </p>
        </div>
        <%}%>
    </fieldset>

    <fieldset style="width: 150px;background-color: mediumpurple;">
        <h3 style="color: black;">Registration</h3>
        <%
            if (session.getAttribute("user")==null){
                User user = (User) session.getAttribute("user");
        %>

        <form action="<%=request.getContextPath()%>/UserServlet" method="post">
            <input type="text" name="login" placeholder="Login"><br><br>
            <input type="password" name="password" placeholder="Password"><br><br>
            <input type="submit" name="register" value="Register">
        </form>

        <%}%>
    </fieldset>
</div>
</body>
</html>