package com.xmg.wms.service;

import com.xmg.wms.domain.Permission;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.QueryObject;

import java.util.List;

public interface IPermissionService {
	void save(Permission p);

	void delete(Long id);

	List<Permission> list();

	//高级查询+分页
	PageResult pageQuery(QueryObject qo);

	/**
	 * 自动加载权限
	 */
	void reload();
}
