package com.xmg.wms.service.impl;

import com.opensymphony.xwork2.ActionContext;
import com.xmg.wms.domain.Employee;
import com.xmg.wms.domain.Permission;
import com.xmg.wms.domain.Role;
import com.xmg.wms.mapper.EmployeeMapper;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.QueryObject;
import com.xmg.wms.service.IEmployeeService;
import com.xmg.wms.util.MD5;
import com.xmg.wms.util.UserContext;
import lombok.Setter;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeServiceImpl implements IEmployeeService {

	@Setter
	private EmployeeMapper empMapper;

	@Override
	public void save(Employee e) {
		e.setPassword(MD5.encode(e.getPassword()));
		empMapper.save(e);
		
		//这里是保存对应的关系是进行添加
		List<Role> roles = e.getRoles();
		for (Role role : roles) { 
			empMapper.updateRelation(e.getId(), role.getId());
		}
	}

	@Override
	public void delete(Long id) {
		empMapper.deleteRelation(id);
		empMapper.delete(id);
	}

	@Override
	public void update(Employee e) {
		empMapper.update(e);

		empMapper.deleteRelation(e.getId());

		List<Role> roles = e.getRoles();
		for (Role role : roles) {
			empMapper.updateRelation(e.getId(), role.getId());
		}
	}

	@Override
	public Employee get(Long id) {
		return empMapper.get(id);
	}

	@Override
	public List<Employee> list() {
		return empMapper.list();
	}

	@Override
	public PageResult pageQuery(QueryObject qo) {
		Long totalCount = empMapper.getTotalCount(qo);
		if (totalCount == 0) {
			return new PageResult(Collections.EMPTY_LIST, 0, 1,
					qo.getPageSize());
		}
		List<Employee> listData = empMapper.pageQuery(qo);
		return new PageResult(listData, totalCount.intValue(),
				qo.getCurrentPage(), qo.getPageSize());
	}

	@Override
	public void batchDelete(List<Long> ids) {
		//先删除关联关系的表
		empMapper.batchDeleteRelation(ids);
		//然后在删除单个员工的表
		empMapper.batchDelete(ids);


	}

	@Override
	public Employee checkLogin(String username, String password) {
		Employee e = empMapper.checkLogin(username, MD5.encode(password));
		if (e == null) {
			throw new RuntimeException("用户名或者密码错误!");
		}
		//登陆成功,将用户信息添加到session中
		//ActionContext.getContext().getSession().put("EMPLOYEE_IN_SESSION", e);
		UserContext.setCurrentUser(e);

		Set<String> expressionSet = new HashSet<>();
		List<Role> roles = e.getRoles();
		for (Role role : roles) {
			List<Permission> permissions = role.getPermissions();
			for (Permission permission : permissions) {
				//将所有的权限表达式存到set集合中
				expressionSet.add(permission.getExpression());
			}
		}
		//获取到用户所有的权限,将其添加到session中:为权限的校验做准备
		ActionContext.getContext().getSession()
				.put("EXPRESSIONSET_IN_SESSION", expressionSet);
		//这个就在方法执行的时候直接调用session里面的值
		UserContext.setCurrentPermissionSet(expressionSet);
		return e;
	}
}
