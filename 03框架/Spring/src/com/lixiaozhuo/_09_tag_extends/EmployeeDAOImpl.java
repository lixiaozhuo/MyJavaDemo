package com.lixiaozhuo._09_tag_extends;

public class EmployeeDAOImpl extends BaseDAO {

	public void save(Employee depat) {
		System.out.println("------" + sessionFactory);
		System.out.println("保存员工对象");
	}
}
