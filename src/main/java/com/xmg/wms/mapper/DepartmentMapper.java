package com.xmg.wms.mapper;

import com.xmg.wms.domain.Department;
import com.xmg.wms.query.QueryObject;

import java.util.List;

public interface DepartmentMapper {
	void save(Department dept);

	void delete(Long id);

	void update(Department dept);

	Department get(Long id);

	List<Department> list();

	Long getTotalcount(QueryObject qo);

	List<Department> pageQuery(QueryObject qo);

}
