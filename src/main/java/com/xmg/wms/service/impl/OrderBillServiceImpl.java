package com.xmg.wms.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmg.wms.domain.OrderBill;
import com.xmg.wms.mapper.OrderBillMapper;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.OrderBillQueryObject;
import com.xmg.wms.service.IOrderBillService;
import lombok.Setter;
public class OrderBillServiceImpl implements IOrderBillService {
	@Setter
	private OrderBillMapper orderBillMapper;
	
	public void  delete(Long id) {
		  orderBillMapper.delete(id);
	}

	public void save(OrderBill entity) {
		  orderBillMapper.save(entity);
	}

	public OrderBill get(Long id) {
		return orderBillMapper.get(id);
	}

	public List<OrderBill> list() {
		return orderBillMapper.list();
	}

	public void update(OrderBill entity) {
		  orderBillMapper.update(entity);
	}

	@Override
	public PageResult pageQuery(OrderBillQueryObject qo) {
		Long count = orderBillMapper.getTotalCount(qo);
		if(count<=0){
			return new PageResult(Collections.EMPTY_LIST,0, 1,qo.getPageSize());
		}
		List<OrderBill> result = orderBillMapper.pageQuery(qo);
		PageResult pageResult = new PageResult(result,count.intValue(),qo.getCurrentPage(),qo.getPageSize());
		return pageResult;
	}
}
