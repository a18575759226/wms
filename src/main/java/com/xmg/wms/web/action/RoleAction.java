package com.xmg.wms.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.xmg.wms.domain.Permission;
import com.xmg.wms.domain.Role;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.QueryObject;
import com.xmg.wms.service.IPermissionService;
import com.xmg.wms.service.IRoleService;
import com.xmg.wms.service.ISystemmenuService;
import com.xmg.wms.util.RequiredPermission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class RoleAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	@Getter
	private Role r = new Role();
	@Setter
	private IRoleService roleService;
	@Setter
	private IPermissionService permissionService;
	/*@Setter
	private String repassword;*/

	@Setter
	private ISystemmenuService systemmenuService;

	@Getter
	private QueryObject qo = new QueryObject();

	@RequiredPermission("角色列表")
	public String execute() throws Exception {
		PageResult result = roleService.pageQuery(qo);
		//将数据添加到值栈中
		ActionContext.getContext().put("result", result);
		return LIST;
	}

	@RequiredPermission("角色删除")
	public String delete() throws Exception {
		if (r.getId() != null) {
			roleService.delete(r.getId());
		}
		return SUCCESS;
	}

	@RequiredPermission("角色编辑")
	public String input() throws Exception {
		//查询出所有的权限
		List<Permission> permissions = permissionService.list();
		ActionContext.getContext().put("permissions", permissions);
		putContext("menus",systemmenuService.list());
		if (r.getId() != null) {
			r = roleService.get(r.getId());
		}
		return INPUT;
	}

	@RequiredPermission("角色保存或更新")
	public String saveOrUpdate() throws Exception {
		if (r.getId() != null) {
			roleService.update(r);
		} else {
			roleService.save(r);
		}
		return SUCCESS;
	}
}
