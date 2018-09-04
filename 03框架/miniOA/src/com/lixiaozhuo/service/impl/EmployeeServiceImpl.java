package com.lixiaozhuo.service.impl;

import java.util.List;

import com.lixiaozhuo.dao.IEmployeeDAO;
import com.lixiaozhuo.dao.impl.EmployeeDAOImpl;
import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;
import com.lixiaozhuo.service.IEmployeeService;
import com.lixiaozhuo.utils.MD5;

@SuppressWarnings("all")
public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDAO dao = new EmployeeDAOImpl();
	// 插入信息
	@Override
	public void save(Employee obj) {
		obj.setPassword(MD5.encode(obj.getPassword()));
		dao.save(obj);
	}

	// 修改信息
	@Override
	public void update(Employee obj) {
		dao.update(obj);
	}

	// 删除信息
	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	// 根据id查询信息
	@Override
	public Employee get(Long id) {
		 return dao.get(id);
	}

	// 查询所有信息
	@Override
	public List<Employee> list() {
		return dao.list();
	}

	// 高级查询
	@Override
	public PageResult query(QueryObject qo) {
		return dao.query(qo);
	}

	//获取对应用户信息
	@Override
	public Employee checkLogin(String username, String password) {
		return dao.checkLogin(username,MD5.encode(password) );
		
	}

}
