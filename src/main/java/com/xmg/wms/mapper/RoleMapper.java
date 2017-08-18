package com.xmg.wms.mapper;

import com.xmg.wms.domain.Role;
import com.xmg.wms.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
	void save(Role r);

	void delete(Long id);

	void update(Role r);

	Role get(Long id);

	List<Role> list();

	Long getTotalCount(QueryObject qo);

	List<Role> pageQuery(QueryObject qo);

	/**
	 * 维护角色和权限的关系
	 * @param id  角色主键
	 * @param id2  权限的主键
	 *
	 */
	void updateRelation(@Param("rid") Long id, @Param("pid") Long id2);


	void updateMenuRelation(@Param("rId") Long rid, @Param("mId") Long mid);

	/**
	 * 根据角色将中间表中的数据删除
	 * @param id
	 */
	void deleteRelation(Long id);

	void  deleteMenuRelation(Long id);

}
