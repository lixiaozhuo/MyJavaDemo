package com.lixiaozhuo.web.product.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lixiaozhuo.dao.IProductDAO;
import com.lixiaozhuo.dao.IProductDirDAO;
import com.lixiaozhuo.dao.impl.ProductDAOImpl;
import com.lixiaozhuo.dao.impl.ProductDirDAOImpl;
import com.lixiaozhuo.domain.Product;
import com.lixiaozhuo.domain.ProductDir;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.ProductQueryObject;
import com.lixiaozhuo.query.QueryObject;
import com.mysql.cj.util.StringUtils;

//商品信息处理
@WebServlet("/product")
public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IProductDAO productDao = new ProductDAOImpl();
	private IProductDirDAO productDirDao = new ProductDirDAOImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 接收请求参数,封装成对象
		String cmd = req.getParameter("cmd");
		// 调用业务方法处理请求
		if ("edit".equals(cmd)) {
			edit(req, resp);
		} else if ("save".equals(cmd)) {
			save(req, resp);
		} else if ("delete".equals(cmd)) {
			delete(req, resp);
		} else {
			list(req, resp);
		}
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 接收请求参数,封装成对象
		String id = req.getParameter("id");
		// 调用业务方法处理请求
		if (!StringUtils.isEmptyOrWhitespaceOnly(id)) {
			Product obj = productDao.get(Long.valueOf(id));
			req.setAttribute("data", obj);
		}
		List<ProductDir> dirItems = productDirDao.list();
		req.setAttribute("dirItems", dirItems);
		// 控制页面跳转
		req.getRequestDispatcher("/WEB-INF/views/product/edit.jsp").forward(req,
				resp);
	}

	private void save(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
			productDao.save(obj);
		} else {
			obj.setId(Long.valueOf(id));
			productDao.update(obj);
		}
		// 控制页面跳转
		resp.sendRedirect("product");
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 接收请求参数,封装成对象
		String id = req.getParameter("id");
		// 调用业务方法处理请求
		if (!StringUtils.isEmptyOrWhitespaceOnly(id)) {
			productDao.delete(Long.valueOf(id));
		}
		// 控制页面跳转
		resp.sendRedirect("/product");
	}

	private void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 接收请求参数,封装成对象
		QueryObject query = createQueryObject(req);
		// 调用业务方法处理请求
		PageResult result = productDao.query(query);		
		req.setAttribute("query", query);
		req.setAttribute("result", result);
		List<ProductDir> dirItems = productDirDao.list();
		req.setAttribute("dirItems", dirItems);
		// 控制页面跳转
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(req,
				resp);
	}

	// 接收请求参数,封装成QueryObject对象
	private QueryObject createQueryObject(HttpServletRequest req) {
		ProductQueryObject pq = new ProductQueryObject(1, 3);

		// 接收分页请求参数
		String cuurentPage = req.getParameter("currentPage");
		String pageSize = req.getParameter("pageSize");
		if (!StringUtils.isEmptyOrWhitespaceOnly(cuurentPage)) {
			pq.setCurrentPage(Integer.valueOf(cuurentPage));
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
			pq.setMinPrice(new BigDecimal(maxPrice));
		}
		if (!StringUtils.isEmptyOrWhitespaceOnly(dir_id)) {
			pq.setDir_id(Long.valueOf(dir_id));
		}
		if (!StringUtils.isEmptyOrWhitespaceOnly(keyword)) {
			pq.setKeyword(keyword);
		}
		return pq;
	}

}
