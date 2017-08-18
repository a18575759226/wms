package com.xmg.wms.service;

import com.xmg.wms.domain.Employee;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.QueryObject;

import java.util.List;

public interface IEmployeeService {
	void save(Employee e);

	void delete(Long id);

	void update(Employee e);

	Employee get(Long id);

	List<Employee> list();

	//高级查询+分页
	PageResult pageQuery(QueryObject qo);

	void batchDelete(List<Long> ids);

	Employee checkLogin(String username,
                        String password);
}
