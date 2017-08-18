package com.xmg.wms.test;

import com.xmg.wms.domain.Permission;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.QueryObject;
import com.xmg.wms.service.IPermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PermissionServiceImplTest {

	@Autowired
	private IPermissionService permissionService;

	@Test
	public void testSave() {
		Permission p = new Permission();
		p.setName("员工列表");
		p.setExpression("com.xmg.wms.web.action.DepartmentAction:execute");
		permissionService.save(p);
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testList() {
	}

	@Test
	public void testPageQuery() {
	}

	@Test
	public void testSetPermissionMapper() {
		QueryObject qo = new QueryObject();
		PageResult pageResult = permissionService.pageQuery(qo);
		System.out.println(pageResult);
	}

}
