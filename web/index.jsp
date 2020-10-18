<%@ page import="shop.items.Item" %>
<%@ page import="shop.items.Sport" %>
<%@ page import="shop.items.Furniture" %>
<%@ page import="shop.user.User" %>
<%@ page import="shop.store.ItemStore" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="shop.user.Order" %><%--
  Created by IntelliJ IDEA.
  User: DAMIR
  Date: 13.10.2020
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Index</title>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
</head>
<body>


<%@include file="jsp/header.jsp"%>

<form action="<%=request.getContextPath()%>/ItemServlet" method="post" style="margin: auto; width: 50%; background-color: darkkhaki">
    <div class="button">
        <h2 style="color: black";>Categories:</h2>
        <input type="submit" name="Sport" value="Sport" class="sportBtn">
        <input type="submit" name="Furniture" value="Furniture" class="furnitureBtn">
        <input type="submit" name="Gadgets" value="Gadgets" class="gadgetsBtn">
        <input type="submit" name="Clothes" value="Clothes" class="clothesBtn">
        <input type="submit" name="ALL" value="ALL" class="allBtn">
    </div>
</form>
<div style="display: grid;grid-template-columns: 1fr 1fr 1fr 1fr;" >
    <%
        for (Item item :   ItemStore.getItems()) {
            if (item.getClass().getName().endsWith((String) session.getAttribute("item"))){
    %>
    <div class="itemDiv">
        <form method="post" action="<%=request.getContextPath()%>/ItemServlet">


            <p id="itemName"> <%=item.getItemName()%></p>
            <p id="itemPrice"> <%=item.getPrice()%>&#36;</p>

            <div class="inputs">
                <input type="number" name="amount"  required  placeholder="Amount"> <br><br>
                <input type="text" hidden="hidden" name="item_id"  readonly="readonly" value="<%=item.getId()%>"><br>
                <%
                    if (session.getAttribute("user")!=null){
                %>
                <input type="submit" name="addToCart" value="Add to cart">
                <%

                    }
                %>
            </div>


        </form>
    </div>
    <%

            }
        }
    %>
</div>
</body>

</html>