package com.lixiaozhuo.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lixiaozhuo.dao.IStudentDAO;
import com.lixiaozhuo.dao.impl.StudentDAOImpl;
import com.lixiaozhuo.domain.Student;
import com.mysql.jdbc.StringUtils;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IStudentDAO dao = new StudentDAOImpl();

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
		String username = req.getParameter("username");
		String age = req.getParameter("age");
		Student stu = new Student(null, username, Integer.valueOf(age));
		// 调用业务方法处理请求
		if (StringUtils.isEmptyOrWhitespaceOnly(id)) {
			dao.save(stu);
		} else {
			stu.setId(Long.valueOf(id));
			dao.update(stu);
		}
		// 控制页面跳转
		resp.sendRedirect("/student");
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求参数,封装成对象
		String id = req.getParameter("id");
		// 调用业务方法处理请求
		if (!StringUtils.isEmptyOrWhitespaceOnly(id)) {
			Student student = dao.get(Long.valueOf(id));
			req.setAttribute("student", student);
		}
		// 控制页面跳转
		req.getRequestDispatcher("/WEB-INF/student/edit.jsp")
				.forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求参数,封装成对象
		String id = req.getParameter("id");
		// 调用业务方法处理请求
		dao.delete(new Long(id));
		// 控制页面跳转
		resp.sendRedirect("/student");
	}

	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收请求参数,封装成对象
		// 调用业务方法处理请求
		List<Student> list = dao.list();
		req.setAttribute("list", list);
		// 控制页面跳转
		req.getRequestDispatcher("/WEB-INF/student/list.jsp")
				.forward(req, resp);
	}
}
