package com.lixiaozhuo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixiaozhuo.domain.Department;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.DepartmentQueryObject;
import com.lixiaozhuo.service.IDepartmentService;
import com.lixiaozhuo.utils.RequiredPermission;


@Controller
public class DepartmentController extends BaseController{
	@Autowired
	private IDepartmentService departmentService;

	@RequestMapping("/department")
	public String list(Model model, DepartmentQueryObject qo) {
		PageResult<Department> pageResult = departmentService.query(qo);
		model.addAttribute("pageResult",pageResult);
		model.addAttribute("qo",qo);
		return "department/list";
	}
	
	@RequiredPermission("部门编辑")
	@RequestMapping("/department_save")
	public Object save(Department department) {
		if (department.getId() == null) {
			// 增加
			departmentService.save(department);
		} else {
			// 编辑
			departmentService.update(department);
		}
		return "redirect:/department";
	}
	
	@RequiredPermission("部门删除")
	@RequestMapping("/department_delete")
	public Object delete(Model model,Department department,DepartmentQueryObject qo) {
		if (department.getId() != null) {
			departmentService.delete(department.getId());
		}
		model.addAttribute("qo",qo);
		return "redirect:/department";
	}

	@RequiredPermission("部门新增/更新")
	@RequestMapping("/department_input")
	public Object input(Model model,Department department) {
		// 保存操作
		if (department.getId() != null) {
			department = departmentService.get(department.getId());
			model.addAttribute("department", department);
		}	
		return "department/input";
	}
}
