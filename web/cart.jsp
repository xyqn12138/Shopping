<%@ page import="java.util.HashMap" %>
<%@ page import="domain.goods.goodBean" %>
<%@ page import="domain.goods.cartFormBean" %><%--
  Created by IntelliJ IDEA.
  User: MJOEN
  Date: 2024/12/8
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    HashMap<String, cartFormBean>cart = (HashMap<String, cartFormBean>)request.getAttribute("cart");
    for (String key : cart.keySet()) {
        cartFormBean good = cart.get(key);
%>
    <p>商品id：<%=good.getGoodId() %></p>
    <p>商品名称：<%=good.getTitle() %></p>
    <p>商品价格：<%=good.getPrice() %></p>
    <p>商品数量：<%=good.getCount() %></p>
    <p>商品小计：<%=good.getPrice()*good.getCount() %></p>
    <hr>
<%
    }
%>
</body>
</html>
