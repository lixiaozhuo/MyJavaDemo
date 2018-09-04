package com.lixiaozhuo._21_jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.lixiaozhuo._21_jdbc.dao.IEmployeeDAO;
import com.lixiaozhuo._21_jdbc.domain.Employee;

public class EmployeeDAOImpl extends JdbcDaoSupport implements IEmployeeDAO {
	@Override
	public void save(Employee obj) {
		getJdbcTemplate().update("INSERT INTO t_employee(name,age) VALUE (?,?)",
				obj.getName(), obj.getAge());
	}

	@Override
	public void update(Employee obj) {
		getJdbcTemplate().update(
				"UPDATE t_employee SET name=?,age=? WHERE id=?", obj.getName(),
				obj.getAge(), obj.getId());
	}

	@Override
	public void delete(Long id) {
		getJdbcTemplate().update("DELETE FROM t_employee WHERE id=?", id);
	}

	@Override
	public Employee get(Long id) {
		List<Employee> list = getJdbcTemplate().query(
				"SELECT * FROM t_employee WHERE id=?", new Object[] { id }, //
				new RowMapper<Employee>() {
					@Override
					public Employee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Employee empl = new Employee();
						empl.setId(rs.getLong("id"));
						empl.setName(rs.getString("name"));
						empl.setAge(rs.getInt("age"));
						return empl;
					}

				});
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public List<Employee> list() {
		List<Employee> list = getJdbcTemplate().query(
				"SELECT * FROM t_employee", //
				new RowMapper<Employee>() {
					@Override
					public Employee mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Employee empl = new Employee();
						empl.setId(rs.getLong("id"));
						empl.setName(rs.getString("name"));
						empl.setAge(rs.getInt("age"));
						return empl;
					}
				});
		return list;
	}

}
