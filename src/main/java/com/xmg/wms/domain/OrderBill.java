package com.xmg.wms.domain;

import generator.ObjectProp;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter@Setter@ObjectProp("采购订单")
public class OrderBill extends BasicDomain {
    @ObjectProp("订单编码")
    private String sn;
    @ObjectProp("业务时间")
    private Date vdata;
    @ObjectProp("审核状态")
    private int status;
    @ObjectProp("采购总金额")
    private BigDecimal totalAmount;
    @ObjectProp("采购总数量")
    private BigDecimal totalNumber;
    @ObjectProp("审核时间")
    private Date auditTime;
    @ObjectProp("录入时间")
    private Date inputTime;
    @ObjectProp("录入人")
    private Employee inputUser;
    @ObjectProp("审核人")
    private Employee auditor;
    @ObjectProp("供应商")
    private Supplier supplier;
    @ObjectProp("订单明细")
    private List<OrderBillItem> items = new ArrayList<>();

}
