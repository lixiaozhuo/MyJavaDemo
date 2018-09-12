package com.lixiaozhuo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixiaozhuo.domain.Role;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.RoleQueryObject;
import com.lixiaozhuo.service.IPermissionService;
import com.lixiaozhuo.service.IRoleService;
import com.lixiaozhuo.utils.RequiredPermission;

@Controller
public class RoleController  extends BaseController{
	@Autowired
	private IPermissionService permissionService;

	@Autowired
	private IRoleService roleService;

	@RequestMapping("/role")
	public String list(Model model, RoleQueryObject qo) {
		PageResult<Role> pageResult = roleService.query(qo);
		model.addAttribute("pageResult",pageResult);
		model.addAttribute("qo",qo);
		return "role/list";
	}

	@RequiredPermission("角色编辑")
	@RequestMapping("/role_save")
	public Object save(Role role,String[] permId) {
		//角色中添加
		
		if (role.getId() == null) {
			// 增加
			roleService.save(role,permId);
		} else {
			// 编辑
			roleService.update(role,permId);
		}
		return "redirect:/role";
	}

	@RequiredPermission("角色删除")
	@RequestMapping("/role_delete")
	public Object delete(Model model,Role role, RoleQueryObject qo) {
		if (role.getId() != null) {
			roleService.delete(role.getId());
		}
		model.addAttribute("qo",qo);
		return "redirect:/role";
	}

	@RequiredPermission("角色新增/更新")
	@RequestMapping("/role_input")
	public Object input(Model model,Role role) {
		// 查询所有权限信息将其放入context中
		model.addAttribute("permissions", permissionService.list());
		// 保存操作
		if (role.getId() != null) {
			role = roleService.get(role.getId());
			model.addAttribute("role", role);
		}
		return "role/input";
	}
}
