package com.lixiaozhuo.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lixiaozhuo.dao.IProductDAO;
import com.lixiaozhuo.dao.impl.ProductDAOImpl;
import com.lixiaozhuo.domain.Product;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.ProductQueryObject;
import com.lixiaozhuo.query.QueryObject;
import com.mysql.jdbc.StringUtils;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IProductDAO dao = new ProductDAOImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		// 接收请求参数,封装成对象
		String cmd = req.getParameter("cmd");
		// 调用业务方法处理请求
		if ("save".equals(cmd)) {
			save(req, resp);
		} else if ("edit".equals(cmd)) {
			edit(req, resp);
		} else if ("delete".equals(cmd)) {
			delete(req, resp);
		} else {
			list(req, resp);
		}
		// 控制页面跳转
	}

	private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求参数,封装成对象
		String id = req.getParameter("id");
		String productName = req.getParameter("productName");
		String dir_id = req.getParameter("dir_id");
		String salePrice = req.getParameter("salePrice");
		String supplier = req.getParameter("supplier");
		String brand = req.getParameter("brand");
		String cutoff = req.getParameter("cutoff");
		String costPrice = req.getParameter("costPrice");
		Product obj = new Product(null, productName, Long.valueOf(dir_id),
				new BigDecimal(salePrice), supplier, brand,
				new BigDecimal(cutoff), new BigDecimal(costPrice));
		// 调用业务方法处理请求
		if (StringUtils.isEmptyOrWhitespaceOnly(id)) {
			dao.save(obj);
		} else {
			obj.setId(Long.valueOf(id));
			dao.update(obj);
		}
		// 控制页面跳转
		resp.sendRedirect("/product");
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求参数,封装成对象
		String id = req.getParameter("id");
		// 调用业务方法处理请求
		if (!StringUtils.isEmptyOrWhitespaceOnly(id)) {
			Product obj = dao.get(Long.valueOf(id));
			req.setAttribute("obj", obj);
		}
		// 控制页面跳转
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp")
				.forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求参数,封装成对象
		String id = req.getParameter("id");
		// 调用业务方法处理请求
		dao.delete(new Long(id));
		// 控制页面跳转
		resp.sendRedirect("/product");
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求参数,封装成对象
		QueryObject queryObject = createQueryObject(req);
		// 调用业务方法处理请求
		PageResult result = dao.query(queryObject);
		// 共享数据,数据回显
		req.setAttribute("queryObject", queryObject);
		req.setAttribute("result", result);
		// 控制页面跳转
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp")
				.forward(req, resp);
	}

	// 接收请求参数,封装成QueryObject对象
	private QueryObject createQueryObject(HttpServletRequest req) {
		ProductQueryObject pq = new ProductQueryObject(1,3);

		// 接收分页请求参数
		String currentPage = req.getParameter("currentPage");
		String pageSize = req.getParameter("pageSize");
		if (!StringUtils.isEmptyOrWhitespaceOnly(currentPage)) {
			pq.setCurrentPage(Integer.valueOf(currentPage));
		}
		if (!StringUtils.isEmptyOrWhitespaceOnly(pageSize)) {
			pq.setPageSize(Integer.valueOf(pageSize));
		}
		
		// 接收条件查询请求参数
		String name = req.getParameter("name");
		String minPrice = req.getParameter("minPrice");
		String maxPrice = req.getParameter("maxPrice");
		String dir_id = req.getParameter("dir_id");
		String keyword = req.getParameter("keyword");
		if (!StringUtils.isEmptyOrWhitespaceOnly(name)) {
			pq.setName(name);
		}
		if (!StringUtils.isEmptyOrWhitespaceOnly(minPrice)) {
			pq.setMinPrice(new BigDecimal(minPrice));
		}
		if (!StringUtils.isEmptyOrWhitespaceOnly(maxPrice)) {
			pq.setMaxPrice(new BigDecimal(maxPrice));
		}
		if (!StringUtils.isEmptyOrWhitespaceOnly(dir_id)) {
			pq.setDir_id(new Long(dir_id));
		}
		if (!StringUtils.isEmptyOrWhitespaceOnly(keyword)) {
			pq.setKeyword(keyword);
		}
		return pq;
	}
}
