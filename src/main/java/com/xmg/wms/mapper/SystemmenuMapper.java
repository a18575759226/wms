package com.xmg.wms.mapper;

import com.xmg.wms.domain.Systemmenu;
import com.xmg.wms.query.SystemmenuQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemmenuMapper {
	void save(Systemmenu entity);
	void update(Systemmenu entity);
	void delete(Long id);
    Systemmenu get(Long id);
	List<Systemmenu> list();
    Long getTotalCount(SystemmenuQueryObject qo);
    List<Systemmenu> pageQuery(SystemmenuQueryObject qo);

	List<Systemmenu> queryMenusByParentSn(String parentSn);

    List<Systemmenu> queryMenusByParentSnAndEmpId(@Param("parentId") String parentSn, @Param("empId") Long id);
}