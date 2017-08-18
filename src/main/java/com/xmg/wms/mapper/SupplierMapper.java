package com.xmg.wms.mapper;

import com.xmg.wms.domain.Supplier;
import com.xmg.wms.query.SupplierQueryObject;
import java.util.List;

public interface SupplierMapper {
	void save(Supplier entity);
	void update(Supplier entity);
	void delete(Long id);
    Supplier get(Long id);
	List<Supplier> list();
    Long getTotalCount(SupplierQueryObject qo);
    List<Supplier> pageQuery(SupplierQueryObject qo);
}