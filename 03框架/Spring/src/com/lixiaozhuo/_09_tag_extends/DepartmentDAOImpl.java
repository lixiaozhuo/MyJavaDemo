package com.lixiaozhuo._09_tag_extends;

public class DepartmentDAOImpl extends BaseDAO {

	public void save(Department depat) {
		System.out.println("------" + sessionFactory);
		System.out.println("保存部门对象");
	}
}
