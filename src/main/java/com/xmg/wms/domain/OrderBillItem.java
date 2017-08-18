package com.xmg.wms.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter@Setter
public class OrderBillItem {
    //采购价格
    private BigDecimal costPrice;
    //采购数量
    private BigDecimal number;
    //金额小计
    private BigDecimal amount;
    //备注
    private String remark;
    //产品信息
    private Product product;
    //采购订单
    private OrderBill bill;








}
