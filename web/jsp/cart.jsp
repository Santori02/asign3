<%@ page import="shop.user.User" %>
<%@ page import="shop.user.Order" %>
<%--
  Created by IntelliJ IDEA.
  User: DAMIR
  Date: 15.10.2020
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%
    Cookie c1 = new Cookie("C1", "empty");

    c1.setMaxAge(10);
    response.addCookie(c1);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/ShopServlet" method="post">
    <fieldset>
        <%if (session.getAttribute("user")!=null){

            User user = (User) session.getAttribute("user");
            for (Order order :user.getOrders()) {
                if(order.getItem()!=null){
                    %>
                    <div class="items">
                        <input type="text" hidden="hidden" readonly="readonly" id="<%=order.getId()%>" value="<%=order.getId()%>" name="scales">

                        <h3>
                            Name: <label for="<%=order.getItem().getId()%>"><%=order.getItem().getItemName()%></label><br>
                            Amount: <label for="<%=order.getItem().getId()%>"><%=order.getAmount()%></label><br>
                            Price: <label for="<%=order.getItem().getId()%>"><%=order.getAmount()*order.getItem().getPrice()%></label>$<br><hr>
                        </h3>
                    </div>
        <%          }
                }if(user.getCounter()==0){
        %>
                    <%= c1.getValue()%>
        <%
                }
        }%>

    </fieldset>
    <br>

    <%
    if (session.getAttribute("user")!=null){
    User user =(User) session.getAttribute("user");
    if (user.getCounter()>0){
    %>
    <input type="submit" name="buy" value="Pay"><br><br>
   <%
           }
    }
    %>

</form>

<a href="<%=request.getContextPath()%>/index.jsp">Back to the Shop</a>
</body>
</html>