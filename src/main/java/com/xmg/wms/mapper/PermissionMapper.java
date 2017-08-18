package com.xmg.wms.mapper;

import com.xmg.wms.domain.Permission;
import com.xmg.wms.query.QueryObject;

import java.util.List;

public interface PermissionMapper {
	void save(Permission dept);

	void delete(Long id);

	List<Permission> list();

	Long getTotalCount(QueryObject qo);

	List<Permission> pageQuery(QueryObject qo);

}
