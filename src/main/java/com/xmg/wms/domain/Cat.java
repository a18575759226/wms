package com.xmg.wms.domain;

import generator.ObjectProp;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter@ObjectProp("小小")
public class Cat extends BasicDomain {
    @ObjectProp("编码")
    private String sn;
    @ObjectProp("名字")
    private  String name;



}
