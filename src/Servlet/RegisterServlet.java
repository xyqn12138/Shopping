package Servlet;

import domain.DBUtil;
import domain.RegisterFromBean;
import domain.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String phoneNumber = req.getParameter("phoneNumber");

        RegisterFromBean fromBean = new RegisterFromBean(username, password, confirmPassword, phoneNumber);
        boolean validate = fromBean.validate();
        if (validate) {
            // 注册成功
            UserBean user = new UserBean(fromBean.getUsername(), fromBean.getPassword());
            boolean result = DBUtil.getInstance().insertUser(user);
            if (result) {
                // 注册成功
                req.setAttribute("username", user.getUsername());
                req.getRequestDispatcher("/login.jsp").forward(req, resp);

            }
            else{
                // 注册失败
                req.setAttribute("reError", "该用户名已经存在");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        }
        else {
            // 注册失败
            req.setAttribute("fromBean", fromBean);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
