package com.xmg.wms.domain;

import generator.ObjectProp;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

@Getter
@Setter
@ObjectProp("商品管理")
public class Product extends BasicDomain {
    @ObjectProp("货品名称")
    private String name;
    @ObjectProp("货品编码")
    private String sn;
    @ObjectProp("成本价格")
    private BigDecimal costPrice;
    @ObjectProp("销售价格")
    private BigDecimal salePrice;
    @ObjectProp("货品图片")
    private String imagePath;
    @ObjectProp("备注")
    private String intro;
    @ObjectProp("货品品牌")
    private Brand brand;

    public String getSmallImagePath() {
        /*从最后的一点开始截取*/
        if (StringUtils.isNotEmpty(imagePath)) {

            int index = imagePath.lastIndexOf(".");
            return imagePath.substring(0, index) + "_small" + imagePath.substring(index);
        }
        return "";

    }


}
