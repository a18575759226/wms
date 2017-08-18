package com.xmg.wms.web.action;

import com.xmg.wms.domain.OrderBill;
import com.xmg.wms.query.OrderBillQueryObject;
import com.xmg.wms.service.IOrderBillService;
import com.xmg.wms.util.RequiredPermission;

import lombok.Getter;
import lombok.Setter;

public class OrderBillAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	@Setter
	private IOrderBillService orderBillService;

	@Getter
	private OrderBillQueryObject qo=new OrderBillQueryObject();

	@Getter
	private OrderBill orderBill = new OrderBill();
	
	@RequiredPermission("采购订单列表")
	public String execute(){
		try {
			putContext("result", orderBillService.pageQuery(qo));
		}catch (Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return LIST;
	}

	@RequiredPermission("采购订单编辑")
	public String input() {
		try {
			if (orderBill.getId() != null) {
                orderBill = orderBillService.get(orderBill.getId());
            }
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return INPUT;
	}

	@RequiredPermission("采购订单保存/更新")
	public String saveOrUpdate() {
		try {
			if (orderBill.getId() == null) {
                orderBillService.save(orderBill);
				addActionMessage("增加成功");
            } else {
                orderBillService.update(orderBill);
				addActionMessage("更新成功");
            }
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}

	@RequiredPermission("采购订单删除")
	public String delete()  throws  Exception {
		try {
			if (orderBill.getId() != null) {
                orderBillService.delete(orderBill.getId());
				putMsg("删除成功");
            }
		} catch (Exception e) {
			e.printStackTrace();
			putMsg(e.getMessage());
		}
		return NONE;
	}

}
