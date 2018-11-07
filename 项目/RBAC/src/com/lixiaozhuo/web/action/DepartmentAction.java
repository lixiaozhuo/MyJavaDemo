package com.lixiaozhuo.web.action;

import com.lixiaozhuo.domain.Department;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.DepartmentQueryObject;
import com.lixiaozhuo.service.IDepartmentService;
import com.lixiaozhuo.utils.RequiredPermission;

import lombok.Getter;
import lombok.Setter;

//部门Action
public class DepartmentAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Setter
	private IDepartmentService departmentService;

	@Getter
	private DepartmentQueryObject qo = new DepartmentQueryObject();

	@Getter
	private Department department = new Department();

	// 显示
	@Override
	public String execute() throws Exception {
		PageResult<Department> pageResult = departmentService.query(qo);
		put("pageResult", pageResult);
		return LIST;
	}

	@RequiredPermission("部门编辑")
	public String save() throws Exception {
		if (department.getId() == null) {
			// 增加
			departmentService.save(department);
		} else {
			// 编辑
			departmentService.update(department);
		}
		return SUCCESS;
	}

	@RequiredPermission("部门删除")
	public String delete() throws Exception {
		if (department.getId() != null) {
			departmentService.delete(department);
		}
		return SUCCESS;
	}

	@RequiredPermission("部门新增/更新")
	public String input() throws Exception {
		// 保存操作
		if (department.getId() != null) {
			department = departmentService.get(department.getId());
		}
		return INPUT;
	}

	// 预处理
	public void prepareSave() throws Exception {
		if (department.getId() != null) {
			department = departmentService.get(department.getId());
		}
	}
}
