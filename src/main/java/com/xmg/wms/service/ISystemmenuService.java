package com.xmg.wms.service;
import com.xmg.wms.domain.Systemmenu;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.SystemmenuQueryObject;
import com.xmg.wms.vo.SystemMenuVO;

import java.util.List;

public interface ISystemmenuService {
	void delete(Long id);
	void save(Systemmenu entity);
    Systemmenu get(Long id);
    List<Systemmenu> list();
	void update(Systemmenu entity);
	PageResult pageQuery(SystemmenuQueryObject qo);

    List<SystemMenuVO> queryParentListbyId(Long parentId);

    List<Systemmenu> queryMenusByParentSn(String parentSn);
}
