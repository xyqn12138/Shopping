package Servlet.goods;

import domain.goods.goodBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/good")
public class goodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("goodId");
        String title = req.getParameter("title");
        String price_str = req.getParameter("price").replace("￥","");
        double price = Double.parseDouble(price_str);
        String seller = req.getParameter("seller");

        goodBean good = new goodBean(id,title,price,seller);
        req.setAttribute("good",good);
        req.getRequestDispatcher("cart").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
