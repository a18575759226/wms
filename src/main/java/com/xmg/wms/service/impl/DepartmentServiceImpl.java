package com.xmg.wms.service.impl;

import com.xmg.wms.domain.Department;
import com.xmg.wms.mapper.DepartmentMapper;
import com.xmg.wms.mapper.EmployeeMapper;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.QueryObject;
import com.xmg.wms.service.IDepartmentService;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {

    @Setter
    private DepartmentMapper deptMapper;

    @Setter
    private EmployeeMapper empMapper;

    @Override
    public void save(Department dept) {
        deptMapper.save(dept);
    }

    @Override
    public void delete(Long id) {
        //在删除对应部门之前,需要将其关联的数据先删掉或者是将其外键列设置null
        empMapper.updateByDeptId(id);

        deptMapper.delete(id);
    }

    @Override
    public void update(Department dept) {
        deptMapper.update(dept);
    }

    @Override
    public Department get(Long id) {
        return deptMapper.get(id);
    }

    @Override
    public List<Department> list() {
        return deptMapper.list();
    }

    @Override
    public PageResult pageQuery(QueryObject qo) {
        //查询总记录数
        Long count = deptMapper.getTotalcount(qo);
        if(count ==0 ){
            return new PageResult(Collections.EMPTY_LIST, 0, 1,
                    qo.getPageSize());
        }
        /*然后在查询里面的集合里面的元素*/
        List<Department> listData = deptMapper.pageQuery(qo);
        return new PageResult(listData,count.intValue(),qo.getCurrentPage(),qo.getPageSize());
    }

}
