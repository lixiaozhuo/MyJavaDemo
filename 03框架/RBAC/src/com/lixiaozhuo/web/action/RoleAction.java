package com.lixiaozhuo.web.action;

import com.lixiaozhuo.domain.Role;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.RoleQueryObject;
import com.lixiaozhuo.service.IPermissionService;
import com.lixiaozhuo.service.IRoleService;
import com.lixiaozhuo.utils.RequiredPermission;

import lombok.Getter;
import lombok.Setter;

//角色Action
public class RoleAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Setter
	private IRoleService roleService;

	@Setter
	private IPermissionService permissionService;

	@Getter
	private RoleQueryObject qo = new RoleQueryObject();

	@Getter
	private Role role = new Role();

	// 显示
	@Override
	public String execute() throws Exception {
		PageResult<Role> pageResult = roleService.query(qo);
		put("pageResult", pageResult);
		return LIST;
	}

	@RequiredPermission("角色编辑")
	public String save() throws Exception {
		if (role.getId() == null) {
			// 增加
			roleService.save(role);
		} else {
			// 编辑
			roleService.update(role);
		}
		return SUCCESS;
	}

	@RequiredPermission("角色删除")
	public String delete() throws Exception {
		if (role.getId() != null) {
			roleService.delete(role);
		}
		return SUCCESS;
	}

	@RequiredPermission("角色新增/更新")
	public String input() throws Exception {
		//查询所有权限信息将其放入context中
		put("permissions", permissionService.list());
		// 保存操作
		if (role.getId() != null) {
			role = roleService.get(role.getId());
		}
		return INPUT;
	}

	// 预处理
	public void prepareSave() throws Exception {
		if (role.getId() != null) {
			role = roleService.get(role.getId());
			// 清除集合
		}
		role.setPermissions(null);
	}

}
