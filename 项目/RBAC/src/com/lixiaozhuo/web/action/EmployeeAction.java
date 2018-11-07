package com.lixiaozhuo.web.action;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.EmployeeQueryObject;
import com.lixiaozhuo.service.IDepartmentService;
import com.lixiaozhuo.service.IEmployeeService;
import com.lixiaozhuo.service.IRoleService;
import com.lixiaozhuo.utils.RequiredPermission;

import lombok.Getter;
import lombok.Setter;

//员工Action
public class EmployeeAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Setter
	private IEmployeeService employeeService;

	@Setter
	private IDepartmentService departmentService;
	
	@Setter
	private IRoleService roleService;

	@Getter
	private EmployeeQueryObject qo = new EmployeeQueryObject();

	@Getter
	private Employee employee = new Employee();

	@Override
	public String execute() throws Exception {
		PageResult<Employee> pageResult = employeeService.query(qo);
		put("pageResult", pageResult);
		// 查询所有部门信息将其放入context中
		put("depts", departmentService.list());
		return LIST;
	}

	@RequiredPermission("员工编辑")
	public String save() throws Exception {
		if (employee.getId() == null) {
			employeeService.save(employee);
		} else {
			employeeService.update(employee);
		}
		return SUCCESS;
	}

	@RequiredPermission("员工删除")
	public String delete() throws Exception {
		if (employee.getId() != null) {
			employeeService.delete(employee);
		}
		return SUCCESS;
	}

	@RequiredPermission("员工新增/更新")
	public String input() throws Exception {
		//查询所有角色信息将其放入context中
		put("roles",roleService.list());
		// 查询所有部门信息将其放入context中
		put("depts", departmentService.list());
		if (employee.getId() != null) {
			employee = employeeService.get(employee.getId());
		}
		return INPUT;
	}

	// 预处理 防止密码丢失
	public void prepareSave() throws Exception {
		if (employee.getId() != null) {
			employee = employeeService.get(employee.getId());
			employee.setDept(null);
			employee.setRoles(null);
		}
	}

}
