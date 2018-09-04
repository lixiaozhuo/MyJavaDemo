package com.lixiaozhuo.web.action;

import com.lixiaozhuo.domain.Permission;
import com.lixiaozhuo.page.PageResult;
import com.lixiaozhuo.query.PermissionQueryObject;
import com.lixiaozhuo.service.IPermissionService;
import com.lixiaozhuo.utils.RequiredPermission;

import lombok.Getter;
import lombok.Setter;

//权限Action
public class PermissionAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Setter
	private IPermissionService permissionService;

	@Getter
	private PermissionQueryObject qo = new PermissionQueryObject();

	@Getter
	private Permission permission = new Permission();

	// 显示
	@Override
	public String execute() throws Exception {
		PageResult<Permission> pageResult = permissionService.query(qo);
		put("pageResult", pageResult);
		return LIST;
	}

	@RequiredPermission("权限编辑")
	public String save() throws Exception {
		if (permission.getId() == null) {
			// 增加
			permissionService.save(permission);
		} else {
			// 编辑
			permissionService.update(permission);
		}
		return SUCCESS;
	}

	@RequiredPermission("权限删除")
	public String delete() throws Exception {
		if (permission.getId() != null) {
			permissionService.delete(permission);
		}
		return SUCCESS;
	}

	@RequiredPermission("权限新增/更新")
	public String input() throws Exception {
		// 保存操作
		if (permission.getId() != null) {
			permission = permissionService.get(permission.getId());
		}
		return INPUT;
	}

	// 权限加载
	public String reload() throws Exception {
		permissionService.reload();
		return NONE;
	}

	// 预处理
	public void prepareSave() throws Exception {
		if (permission.getId() != null) {
			permission = permissionService.get(permission.getId());
		}
	}

}
