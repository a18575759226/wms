package com.xmg.wms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Role extends BasicDomain {
	private static final long serialVersionUID = 1L;
	private String name;
	private String sn;

	private List<Permission> permissions = new ArrayList<>();
	private  List<Systemmenu> menus = new ArrayList<>();

	@Override
	public String toString() {
		return "Role [name=" + name + ", sn=" + sn + "]";
	}

}
