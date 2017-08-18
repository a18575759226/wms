package com.xmg.wms.web.action;

import com.xmg.wms.domain.Department;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.DepartmentQueryObject;
import com.xmg.wms.service.IDepartmentService;
import com.xmg.wms.util.RequiredPermission;
import lombok.Getter;
import lombok.Setter;

public class DepartmentAction extends BaseAction {
    private static final long serialVersionUID = 1L;
    @Setter@Getter
   private DepartmentQueryObject qo = new DepartmentQueryObject();

    @Getter
    private Department dept = new Department();
    @Setter
    private IDepartmentService deptService;

    @RequiredPermission("部门列表")
    public String execute() throws Exception {
//        List<Department> list = deptService.list();
        PageResult result = deptService.pageQuery(qo);
        //将数据添加到值栈中 将值共享出来
        putContext("result",result);
        return LIST;
    }

    @RequiredPermission("部门删除")
    public String delete() throws Exception {
        try {
            if (dept.getId() != null) {
                deptService.delete(dept.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            putMsg("删除成功");

        }
        return SUCCESS;
    }

    @RequiredPermission("部门编辑")
    public String input() throws Exception {
        if (dept.getId() != null) {
            dept = deptService.get(dept.getId());

        }
        return INPUT;
    }

    @RequiredPermission("部门保存或更新")
    public String saveOrUpdate() throws Exception {
        try {
            if (dept.getId() != null) {
                deptService.update(dept);
                addActionMessage("修改成功");
            } else {
                deptService.save(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
            addActionMessage("新增成功");
        }
        return SUCCESS;
    }
}
