package com.lixiaozhuo.web.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixiaozhuo.domain.Permission;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.PermissionQueryObject;
import com.lixiaozhuo.service.IDepartmentService;
import com.lixiaozhuo.service.IPermissionService;
import com.lixiaozhuo.utils.RequiredPermission;

@Controller
public class PermissionController  extends BaseController{

	@Autowired
	private IPermissionService permissionService;
	@Autowired
	private IDepartmentService departmentService;

	@RequestMapping("/permission")
	public String list(Model model, PermissionQueryObject qo) {
		PageResult<Permission> pageResult = permissionService.query(qo);
		model.addAttribute("pageResult", pageResult);
		model.addAttribute("qo", qo);
		model.addAttribute("depts", departmentService.list());
		return "permission/list";
	}

	@RequiredPermission("权限编辑")
	@RequestMapping("/permission_save")
	public Object save(Permission permission) {
		if (permission.getId() == null) {
			// 增加
			permissionService.save(permission);
		} else {
			// 编辑
			permissionService.update(permission);
		}
		return "redirect:/permission";
	}

	@RequiredPermission("权限删除")
	@RequestMapping("/permission_delete")
	public Object delete(Model model, Permission permission,
			PermissionQueryObject qo) {
		if (permission.getId() != null) {
			permissionService.delete(permission.getId());
		}
		model.addAttribute("qo", qo);
		return "redirect:/permission";
	}

	@RequiredPermission("权限新增/更新")
	@RequestMapping("/permission_input")
	public Object input(Model model, Permission permission) {
		// 保存操作
		if (permission.getId() != null) {
			permission = permissionService.get(permission.getId());
			model.addAttribute("permission", permission);
		}
		return "permission/input";
	}

	// 权限加载
	@RequestMapping("/permission_reload")
	public void reload(HttpServletResponse response) throws Exception {
		permissionService.reload();
	}
}
