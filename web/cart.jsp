<%@ page import="java.util.HashMap" %>
<%@ page import="domain.goods.goodBean" %>
<%@ page import="domain.goods.cartFormBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap/css/cart.css">
    <title>Document</title>
</head>
<body>
<div class="cart-container">
    <span><a href="main.html">返回首页</a></span>
    <h2>我的购物车</h2>

    <table>
        <thead>
        <tr>
            <th><input type="checkbox" class="select-all" onclick="selectAllItems(this)">全选</th>
            <th>商品信息</th>
            <th>单价</th>
            <th>数量</th>
            <th>小计</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody id="cart-items">
        <%
            HashMap<String, cartFormBean> cart = (HashMap<String, cartFormBean>) request.getAttribute("cart");
            if (cart != null) {
                for (cartFormBean good : cart.values()) {
        %>
        <tr class="item-row">
            <td><input type="checkbox" class="item-checkbox" checked></td>
            <td><%= good.getTitle() %></td>
            <td>￥<%= good.getPrice() %></td>
            <td><input type="number" value="<%= good.getCount() %>" min="1" max="10" class="quantity-input" onchange="updateItemTotal(this)"></td>
            <td>￥<%= good.getPrice() * good.getCount() %></td>
            <td><span class="remove-item" onclick="removeItem(this)">移除</span></td>
        </tr>
        <%
            }
        }
            %>
        </tbody>
    </table>

    <div class="total-section">
        <p>已选商品 <span id="selected-count"></span> 件，总价：<span id="total-price"></span></p>
        <button class="checkout-btn" onclick="checkout()">结算</button>
    </div>
</div>

<script>

    function updateTotal() {
        let total = 0;
        let selectedCount = 0;
        const items = document.querySelectorAll('.item-row');
        items.forEach(item => {
            if (item.querySelector('.item-checkbox').checked) {
                selectedCount++;
                const price = parseFloat(item.querySelector('td:nth-child(3)').textContent.replace('￥', ''));
                const quantity = parseInt(item.querySelector('.quantity-input').value);
                total += price * quantity;
            }
        });
        document.getElementById('total-price').textContent = '￥' + total.toFixed(2);
        document.getElementById('selected-count').textContent = selectedCount;
    }

    function selectAllItems(checkbox) {
        const allCheckboxes = document.querySelectorAll('.item-checkbox');
        allCheckboxes.forEach(cb => cb.checked = checkbox.checked);
        updateTotal();
    }

    function updateItemTotal(input) {
        const row = input.closest('.item-row');
        const price = parseFloat(row.querySelector('td:nth-child(3)').textContent.replace('￥', ''));
        const quantity = parseInt(input.value);
        const subtotal = price * quantity;
        row.querySelector('td:nth-child(5)').textContent = '￥' + subtotal.toFixed(2);
        updateTotal();
    }

    function removeItem(button) {
        button.closest('.item-row').remove();
        updateTotal();
    }

    function checkout() {
        alert('前往结算页面...');
    }

    window.onload = updateTotal;
</script>

</body>
</html>