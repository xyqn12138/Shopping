package Servlet.goods;

import domain.goods.DBCart;
import domain.goods.cartFormBean;
import domain.goods.goodBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/cart")
public class cartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        goodBean good =(goodBean)req.getAttribute("good");
        String goodId = good.getGoodId();
        String title = good.getTitle();
        double price = good.getPrice();
        //获取购物车
        cartFormBean cartForm = new cartFormBean(goodId, title, price);
        DBCart.getInstance().addGood(cartForm);
        HashMap<String, cartFormBean> cart = DBCart.getInstance().getCart();
        req.setAttribute("cart",cart);
        req.getRequestDispatcher("/cart.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
