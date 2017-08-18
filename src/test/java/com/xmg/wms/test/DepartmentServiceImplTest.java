package com.xmg.wms.test;

import com.xmg.wms.domain.Department;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.DepartmentQueryObject;
import com.xmg.wms.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentServiceImplTest {

	@Autowired
	private IDepartmentService deptService;

	@Test
	public void testSave() throws Exception {
		Department dept = new Department();
		dept.setName("市场部");
		dept.setSn("DEPT001");
		deptService.save(dept);
	}

	@Test
	public void testDelete() throws Exception {
		deptService.delete(18L);
	}

	@Test
	public void testUpdate() throws Exception {
		Department dept = new Department();
		dept.setName("XXX");
		dept.setSn("xxx01");
		dept.setId(19L);
		deptService.update(dept);
	}

	@Test
	public void testGet() throws Exception {
		Department dept = deptService.get(19L);
		System.out.println(dept);
	}

	@Test
	public void testList() throws Exception {
		List<Department> list = deptService.list();
		for (Department dept : list) {
			System.out.println(dept);

		}
	}

	@Test
	public void name1() throws Exception {
		DepartmentQueryObject qo = new DepartmentQueryObject();
		PageResult pageResult = deptService.pageQuery(qo);
		System.out.println(pageResult);

	}
}
