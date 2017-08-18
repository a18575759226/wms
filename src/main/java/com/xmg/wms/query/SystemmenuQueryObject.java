package com.xmg.wms.query;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class SystemmenuQueryObject extends QueryObject {
    //给上一级的菜单定义id
    private Long parentId=-1L;
    private String parentSn;//根据是你查询对应的子菜单选项

}
