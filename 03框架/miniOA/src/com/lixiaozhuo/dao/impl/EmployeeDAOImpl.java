package com.lixiaozhuo.dao.impl;

import java.util.List;

import com.lixiaozhuo.dao.IEmployeeDAO;
import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.handle.IResultSetHandler;
import com.lixiaozhuo.handle.impl.BeanHandler;
import com.lixiaozhuo.handle.impl.BeanListHandler;
import com.lixiaozhuo.handle.impl.ScaleHandler;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.QueryObject;
import com.lixiaozhuo.utils.JDBCTemplate;

@SuppressWarnings("all")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private IResultSetHandler<Employee> beanHandler = new BeanHandler<>(
			Employee.class);
	private IResultSetHandler<List<Employee>> beanListHandler = new BeanListHandler<>(
			Employee.class);
	private IResultSetHandler<Long> scaleHandler = new ScaleHandler<>();

	// 插入信息
	@Override
	public void save(Employee obj) {
		String sql = "INSERT INTO t_employee(id,username,password,email,hiredate,salary) "
				+ "VALUES (?,?,?,?,?,?) ";
		Object[] params = new Object[] { null, obj.getUsername(),
				obj.getPassword(), obj.getEmail(), obj.getHiredate(),
				obj.getSalary() };
		JDBCTemplate.update(sql, params);
	}

	// 修改信息
	@Override
	public void update(Employee obj) {
		String sql = "UPDATE t_employee SET username=?,password=?,email=?,"
				+ "hiredate=?,salary=? WHERE id=?";
		Object[] params = new Object[] { obj.getUsername(), obj.getPassword(),
				obj.getEmail(), obj.getHiredate(), obj.getSalary(),
				obj.getId() };
		JDBCTemplate.update(sql, params);
	}

	// 删除信息
	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_employee WHERE id=?";
		JDBCTemplate.update(sql, id);
	}

	// 根据id查询信息
	@Override
	public Employee get(Long id) {
		String sql = "SELECT * FROM t_employee WHERE id=?";
		Employee product = JDBCTemplate.query(beanHandler, sql, id);
		return product;
	}

	// 查询所有信息
	@Override
	public List<Employee> list() {
		String sql = "SELECT * FROM t_employee";
		return JDBCTemplate.query(beanListHandler, sql);
	}

	// 高级查询
	@Override
	public PageResult query(QueryObject qo) {
		// 查询页面数据
		StringBuilder dataSql = new StringBuilder(80);
		dataSql.append("SELECT * FROM t_employee ")
				.append(qo.getWhereAndLimitCase(true));
		List<Object> params = qo.getParams();
		System.out.println(dataSql);
		System.out.println(params);
		List<Employee> data = JDBCTemplate.query(beanListHandler,
				dataSql.toString(), params.toArray());

		// 查询总记录数
		StringBuilder countSql = new StringBuilder(80);
		countSql.append("SELECT COUNT(*) FROM t_employee ")
				.append(qo.getWhereAndLimitCase(false));
		params = qo.getParams();
		Integer totalCount = JDBCTemplate
				.query(scaleHandler, countSql.toString(), params.toArray())
				.intValue();
		System.out.println(countSql);
		System.out.println(params);
		return new PageResult(data, totalCount, qo.getCurrentPage(),
				qo.getPageSize());
	}

	//获取对应用户信息
	@Override
	public Employee checkLogin(String username, String password) {
		String sql = "SELECT * FROM t_employee WHERE username=? AND password=?";	
		return JDBCTemplate.query(beanHandler,sql,username,password);
	}

}
