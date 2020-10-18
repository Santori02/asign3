<%@ page import="shop.user.User" %><%--
  Created by IntelliJ IDEA.
  User: DAMIR
  Date: 15.10.2020
  Time: 00:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
</head>
<body>

<header>
    <div class="header">
        <a href="#default" class="logo">Shopping mall</a>
        <div class="header-right">
            <a class="active" href="<%=request.getContextPath()%>/index.jsp">Home</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
            <a href="<%=request.getContextPath()%>/jsp/cart.jsp">Shopping Cart</a>
            <%
                if (session.getAttribute("user")!=null){
                    User user = (User) session.getAttribute("user");
            %>
            <h2>Welcome, <%out.println(user.getLogin());%></h2>

            <form method="post" action="<%=request.getContextPath()%>/UserServlet">
                <input type="submit" name="logOut" value="logOut">
            </form>
            <%
            } else {
            %>
            <a href="<%=request.getContextPath()%>/jsp/login.jsp">Login</a>
            <%}%>


        </div>
    </div>
</header>
</body>
</html>