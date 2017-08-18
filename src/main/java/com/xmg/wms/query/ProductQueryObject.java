package com.xmg.wms.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class ProductQueryObject extends QueryObject {
    //这个就是高级查询拼接传入sql条件
    private String keyword;//编码/名称

    private  Long brandId= -1L;


}
