package com.xmg.wms.mapper;

import com.xmg.wms.domain.OrderBill;
import com.xmg.wms.domain.OrderBillItem;
import com.xmg.wms.query.OrderBillQueryObject;
import java.util.List;

public interface OrderBillMapper {
	void save(OrderBill entity);
	void update(OrderBill entity);
	void delete(Long id);
    OrderBill get(Long id);
	List<OrderBill> list();
    Long getTotalCount(OrderBillQueryObject qo);
    List<OrderBill> pageQuery(OrderBillQueryObject qo);
	/*这个就是根据id的bill的id进行把明细查出来*/
	List<OrderBillItem> queryItemsByBillId(Long billId);
}