package com.xmg.wms.mapper;

import com.xmg.wms.domain.Product;
import com.xmg.wms.query.ProductQueryObject;
import java.util.List;

public interface ProductMapper {
	void save(Product entity);
	void update(Product entity);
	void delete(Long id);
    Product get(Long id);
	List<Product> list();
    Long getTotalCount(ProductQueryObject qo);
    List<Product> pageQuery(ProductQueryObject qo);
}