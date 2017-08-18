package com.xmg.wms.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.wms.domain.Brand;
import com.xmg.wms.mapper.BrandMapper;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.BrandQueryObject;
import com.xmg.wms.service.IBrandService;
import lombok.Setter;
public class BrandServiceImpl implements IBrandService {
	@Setter
	private BrandMapper brandMapper;
	
	public void  delete(Long id) {
		  brandMapper.delete(id);
	}

	public void save(Brand entity) {
		  brandMapper.save(entity);
	}

	public Brand get(Long id) {
		return brandMapper.get(id);
	}

	public List<Brand> list() {
		return brandMapper.list();
	}

	public void update(Brand entity) {
		  brandMapper.update(entity);
	}

	@Override
	public PageResult pageQuery(BrandQueryObject qo) {
		Long count = brandMapper.getTotalCount(qo);
		if(count<=0){
			return new PageResult(Collections.EMPTY_LIST,0, 1,qo.getPageSize());
		}
		List<Brand> result = brandMapper.pageQuery(qo);
		PageResult pageResult = new PageResult(result,count.intValue(),qo.getCurrentPage(),qo.getPageSize());
		return pageResult;
	}
}
