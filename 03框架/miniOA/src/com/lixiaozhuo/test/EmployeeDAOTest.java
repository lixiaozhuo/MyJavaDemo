package com.lixiaozhuo.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.lixiaozhuo.dao.IEmployeeDAO;
import com.lixiaozhuo.dao.impl.EmployeeDAOImpl;
import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.utils.JDBCTemplate;
import com.lixiaozhuo.utils.MD5;

//测试类
public class EmployeeDAOTest {
	IEmployeeDAO dao = new EmployeeDAOImpl();

	// 测试插入信息
	@Test
	public void testSave() {
		// for (int i = 0; i < 20; i++) {
		// Employee obj = new Employee(null, "test_" + i, "root",
		// "test_" + i + "@email", new Date(), new BigDecimal("1000"));
		// dao.save(obj);
		// }
		Employee obj = new Employee(null, "root", "root", "root@email",
				new Date(), new BigDecimal("1000"));
		dao.save(obj);
	}

	// 测试更新信息
	@Test
	public void testUpdate() {
		Employee obj = new Employee(3L, "admin", "admin", "root@email",
				new Date(), new BigDecimal("1000"));
		dao.update(obj);
	}

	// 测试删除信息
	@Test
	public void testDelete() {
		dao.delete(3L);
	}

	// 测试根据id查询信息
	@Test
	public void testGet() {
		Employee obj = dao.get(1L);
		System.out.println(obj);
	}

	// 测试高级查询
	@Test
	public void testQuery() {
		List<Employee> objs = dao.list();
		for (Employee obj : objs) {
			System.out.println(obj);
		}
	}
	
	@Test
	public void testMD5(){
		String str = "admin";
		System.out.println(MD5.encode(str));
		String sql = "UPDATE t_employee SET password='21232F297A57A5A743894A0E4A801FC3'";
		JDBCTemplate.update(sql);
	}

}
