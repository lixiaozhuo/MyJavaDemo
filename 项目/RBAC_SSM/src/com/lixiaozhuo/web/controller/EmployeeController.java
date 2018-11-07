package com.lixiaozhuo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixiaozhuo.domain.Employee;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.DepartmentQueryObject;
import com.lixiaozhuo.query.EmployeeQueryObject;
import com.lixiaozhuo.service.IDepartmentService;
import com.lixiaozhuo.service.IEmployeeService;
import com.lixiaozhuo.service.IRoleService;
import com.lixiaozhuo.utils.RequiredPermission;

@Controller
public class EmployeeController  extends BaseController {
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IDepartmentService departmentService;

	@Autowired
	private IRoleService roleService;

	@RequestMapping("/employee")
	public String list(Model model, EmployeeQueryObject qo) {
		PageResult<Employee> pageResult = employeeService.query(qo);
		model.addAttribute("pageResult",pageResult);
		System.out.println(qo.getDeptId());
		model.addAttribute("qo",qo);
		model.addAttribute("depts", departmentService.list());
		return "employee/list";
	}

	@RequiredPermission("员工编辑")
	@RequestMapping("/employee_save")
	public Object save(Employee employee,String[] roleId) {
		System.out.println(employee);
		if (employee.getId() == null) {
			// 增加
			employeeService.save(employee,roleId);
		} else {
			// 编辑
			employeeService.update(employee,roleId);
		}
		return "forward:/employee";
	}

	@RequiredPermission("员工删除")
	@RequestMapping("/employee_delete")
	public Object delete(Model model,Employee employee,DepartmentQueryObject qo) {
		if (employee.getId() != null) {
			//employeeService.delete(employee.getId());
		}
		model.addAttribute("qo",qo);
		return "redirect:/employee";
	}

	@RequiredPermission("员工新增/更新")
	@RequestMapping("/employee_input")
	public Object input(Model model, Employee employee) {
		// 查询所有角色信息将其放入context中
		model.addAttribute("roles", roleService.list());
		// 查询所有部门信息将其放入context中
		model.addAttribute("depts", departmentService.list());
		// 保存操作
		if (employee.getId() != null) {
			employee = employeeService.get(employee.getId());
			model.addAttribute("employee", employee);
		}
		return "employee/input";
	}
}
