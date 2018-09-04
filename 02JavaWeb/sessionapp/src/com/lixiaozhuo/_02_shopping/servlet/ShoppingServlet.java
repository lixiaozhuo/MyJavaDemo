package com.lixiaozhuo._02_shopping.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lixiaozhuo._02_shopping.domain.CartItem;
import com.lixiaozhuo._02_shopping.domain.ShoppingCart;
import com.mysql.jdbc.StringUtils;

@WebServlet("/shopping")
public class ShoppingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取存放在session中的shoppingCart
		ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute("shoppingCart");
		if(shoppingCart == null){
			shoppingCart = new ShoppingCart();
			req.getSession().setAttribute("shoppingCart", shoppingCart);
		}		
		String cmd = req.getParameter("cmd");
		if ("save".equals(cmd)) {
			save(req, resp);
		} else if ("delete".equals(cmd)) {
			delete(req, resp);
		} else {
			list(req, resp);
		}
		
	}

	private void save(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		String num = req.getParameter("num");
		ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute("shoppingCart");
		if ("111".equals(id)) {
			shoppingCart.add(new CartItem(Long.valueOf(id), "苹果电脑",
					new BigDecimal("12000"), Integer.valueOf(num)));
		} else if ("222".equals(id)) {
			shoppingCart.add(new CartItem(Long.valueOf(id), "微软",
					new BigDecimal("18000"), Integer.valueOf(num)));
		}
		resp.sendRedirect("/shopping");
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute("shoppingCart");
		if(!StringUtils.isEmptyOrWhitespaceOnly(id)){
			shoppingCart.remove(Long.valueOf(id));
		}
		resp.sendRedirect("/shopping");
	}

	private void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute("shoppingCart");
		req.setAttribute("shoppingCart", shoppingCart);
		req.getRequestDispatcher("/shopping/shoppingCart.jsp").forward(req, resp);
	}

}
