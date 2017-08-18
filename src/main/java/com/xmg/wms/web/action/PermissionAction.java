package com.xmg.wms.web.action;

import lombok.Getter;
import lombok.Setter;

import com.opensymphony.xwork2.ActionContext;
import com.xmg.wms.domain.Permission;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.QueryObject;
import com.xmg.wms.service.IPermissionService;

public class PermissionAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	@Getter
	private Permission permission = new Permission();
	@Setter
	private IPermissionService permissionService;
	/*@Setter
	private String repassword;*/
	@Getter
	private QueryObject qo = new QueryObject();

	@Override
	public String execute() throws Exception {
		PageResult result = permissionService.pageQuery(qo);
		//将数据添加到值栈中
		ActionContext.getContext().put("result", result);
		return LIST;
	}

	public String delete() throws Exception {
		try {
			if (permission.getId() != null) {
                permissionService.delete(permission.getId());
            }
		} catch (Exception e) {
			e.printStackTrace();
			addActionMessage("删除成功");
		}
		return SUCCESS;
	}

	public String reload() {
		permissionService.reload();
		return NONE;
	}

}
