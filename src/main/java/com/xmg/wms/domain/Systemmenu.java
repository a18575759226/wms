package com.xmg.wms.domain;


import generator.ObjectProp;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter@Setter@ObjectProp("系统菜单")
public class Systemmenu extends BasicDomain {
    @ObjectProp("菜单名称")
    private String name;
    @ObjectProp("菜单编号")
    private String sn;
    @ObjectProp("URL")
    private  String url;
    @ObjectProp("上级菜单")
    private Systemmenu parent;
    private List<Systemmenu> children;
    public Map<String,Object> toJson(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",getId());
        map.put("pId",getParent().getId());
        map.put("name",getName());
        map.put("action",getUrl());
        return map;
    }
}
