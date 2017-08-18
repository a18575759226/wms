package com.xmg.wms.mapper;

import java.util.List;

import com.xmg.wms.query.QueryObject;

public interface BasicMapper<T> {
	void save(T e);

	void delete(Long id);

	void update(T e);

	//这里定义一个批量删除的操作
	void batchDelete(List<Long> ids);

	T get(Long id);

	List<T> list();

	//高级查询,将对应的结果集查询到
	List<T> pageQuery(QueryObject qo);

	//高级查询,查询到对应的总条数
	Long getTotalCount(QueryObject qo);
}
