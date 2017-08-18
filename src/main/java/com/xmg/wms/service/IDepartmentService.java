package com.xmg.wms.service;

import com.xmg.wms.domain.Department;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.QueryObject;

import java.util.List;

public interface IDepartmentService {
	void save(Department dept);

	void delete(Long id);

	void update(Department dept);

	Department get(Long id);

	List<Department> list();

	//定义分页的方法
	PageResult pageQuery(QueryObject qo);
}
