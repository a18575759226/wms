package com.xmg.wms.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.xmg.wms.domain.Department;
import com.xmg.wms.domain.Employee;
import com.xmg.wms.domain.Role;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.EmployeeQueryObject;
import com.xmg.wms.service.IDepartmentService;
import com.xmg.wms.service.IEmployeeService;
import com.xmg.wms.service.IRoleService;
import com.xmg.wms.util.RequiredPermission;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	@Getter
	private Employee e = new Employee();
	@Setter
	private IEmployeeService empService;
	@Setter
	private IDepartmentService deptService;
	@Setter
	private IRoleService roleService;

	//new 出一个集合用来装多个id

	@Getter@Setter
	private List<Long> ids = new ArrayList<>();

	@Setter
	private String repassword;
	@Getter
	@Setter
	private EmployeeQueryObject qo = new EmployeeQueryObject();

	@RequiredPermission("员工列表")
	/*定义跳转的方法  这个也可以跳转到相对应的视图上面*/
	@InputConfig(methodName = "input")
	public String execute() throws Exception {
		try {
			PageResult result = empService.pageQuery(qo);
			//将数据添加到值栈中
			ActionContext.getContext().put("result", result);

			//将页面上需要的部门信息全部查询出来
			List<Department> depts = deptService.list();
			ActionContext.getContext().put("depts", depts);
		} catch (Exception e1) {
			e1.printStackTrace();
			addActionError(e1.getMessage());
			putMsg("删除失败,联系管理员");
		}
		return LIST;
	}

	@RequiredPermission("员工删除")
	public String delete() throws Exception {
		try {
			if (e.getId() != null) {
                empService.delete(e.getId());
                putMsg("删除成功");
            }
		} catch (Exception e1) {
			e1.printStackTrace();
			putMsg("删除失败,联系管理员");
		}
		return NONE;
	}

	@RequiredPermission("员工批量删除")
	public String batchDelete() throws Exception {
		System.out.println(ids);
		try {
			if (ids.size()>0) {
                empService.batchDelete(ids);
                putMsg("删除成功");
            }
		} catch (Exception e1) {
			e1.printStackTrace();
			putMsg("删除失败,联系管理员");
		}
		return NONE;
	}



	@RequiredPermission("员工编辑")
	public String input() throws Exception {
		//将页面上需要的部门信息全部查询出来
		List<Department> depts = deptService.list();
		ActionContext.getContext().put("depts", depts);
		List<Role> roles = roleService.list();
		ActionContext.getContext().put("roles", roles);
		if (e.getId() != null) {
			e = empService.get(e.getId());
		}
		return INPUT;
	}

	@RequiredPermission("员工保存或更新")
	@InputConfig(methodName = "input")
	public String saveOrUpdate() throws Exception {
		try {
			if (e.getId() != null) {
                empService.update(e);
				addActionMessage("修改成功");
            } else {
                empService.save(e);
				addActionMessage("新增成功");
            }
		} catch (Exception e1) {
			e1.printStackTrace();
			addActionError(e1.getMessage());

		}
		return SUCCESS;
	}
}
