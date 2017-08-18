package com.xmg.wms.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Employee extends BasicDomain {

	private static final long serialVersionUID = -2229490946756316031L;
	private String name;
	private String password;
	private String email;
	private Integer age;
	private Boolean admin;
	//多对以的关系
	private Department dept;

	private List<Role> roles = new ArrayList<>();

	@Override
	public String toString() {
		return "Employee [name=" + name + ", password=" + password + ", email="
				+ email + ", age=" + age + ", admin=" + admin + "]";
	}


	//定义一个方法给页面调用
	public String getRoleNames(){
		//1.这个就是一个管理理员
		if (admin) {
			return "[超级管理员]";
		}
		//再进行判断角色的信息
		if (getRoles().size()==0) {
			return "[暂无角色]";
		}
		//在返回拥有角色的信息
		StringBuffer sb = new StringBuffer();
		//在进行拼接字符串
		sb.append("[");
		//在获取role里面相对应的元素 ,上面提供了get方法 就可以直接获取里面的元素
		for (Role role : getRoles()) {
			//在进行拼接
			sb.append(role.getName()).append(",");
		}
		//然后在删除里面里面最后的一个,号
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return  sb.toString();
	}
}
