package com.lixiaozhuo.smis.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lixiaozhuo.smis.dao.IStudentDAO;
import com.lixiaozhuo.smis.dao.impl.StudentDAOImpl;
import com.lixiaozhuo.smis.domain.Student;

@WebServlet("/student/list")
public class StudentListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	IStudentDAO dao = new StudentDAOImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//接收参数,包装成类
		//调用业务函数,处理参数
		List<Student> list = dao.list();		
		req.setAttribute("LIST_IN_REQ", list);
		//控制页面转发
		req.getRequestDispatcher("/WEB-INF/student/list.jsp").forward(req, resp);
	}
}
