package com.lixiaozhou.web.action;

import java.util.List;

import com.lixiaozhou.domain.Employee;
import com.lixiaozhou.service.IEmployeeService;
import com.opensymphony.xwork2.ActionSupport;

import lombok.Setter;

public class EmployeeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	@Setter
	private IEmployeeService employeeService;
	
	@Override
	public String execute() throws Exception {
		System.out.println("EmployeeAction.execute()");
		List<Employee> list = employeeService.list();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		return SUCCESS;
	}
}
