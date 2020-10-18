<%@ page import="shop.store.Message" %>
<%@ page import="shop.user.Order" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: DAMIR
  Date: 16.10.2020
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<%

    Message message = (Message) request.getAttribute("message");
    Date createTime = (Date)request.getAttribute("createTime");
    Date lastAccessTime = (Date)request.getAttribute("lastAccessTime");
%>
<fieldset style="width: 150px; flex-direction: column; align-items: center">
    <legend><h2>Your Cart:</h2></legend>
    <%if (session.getAttribute("user")!=null){

        User user = (User) session.getAttribute("user");
        for (Order order :user.getOrders()) {
    %>
    <h3>Name: <%=order.getItem().getItemName()%></h3>
    Price: <%=order.getItem().getPrice()%>$<br>
    Amount: <%=order.getAmount()%>

    <%}
    }%>

    <hr>
    <p>Total Price: <%=message.getTotal()%>$</p>
</fieldset>

<fieldset>
    <legend><h2>User Information</h2></legend>
    <h3>Number Of Visits: <%=message.getUser().getNumOfSession()%></h3>
    <h3>First Visit: <%=message.getUser().getStartDate()%></h3>
    <h3>Last Visit: <%=message.getUser().getLastDate()%></h3>
</fieldset>
</body>
</html>