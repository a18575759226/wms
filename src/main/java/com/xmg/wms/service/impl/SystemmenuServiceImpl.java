package com.xmg.wms.service.impl;

import com.xmg.wms.domain.Employee;
import com.xmg.wms.domain.Systemmenu;
import com.xmg.wms.mapper.SystemmenuMapper;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.SystemmenuQueryObject;
import com.xmg.wms.service.ISystemmenuService;
import com.xmg.wms.util.UserContext;
import com.xmg.wms.vo.SystemMenuVO;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SystemmenuServiceImpl implements ISystemmenuService {
    @Setter
    private SystemmenuMapper systemmenuMapper;

    public void delete(Long id) {
        systemmenuMapper.delete(id);
    }

    public void save(Systemmenu entity) {
        systemmenuMapper.save(entity);
    }

    public Systemmenu get(Long id) {
        return systemmenuMapper.get(id);
    }

    public List<Systemmenu> list() {
        return systemmenuMapper.list();
    }

    public void update(Systemmenu entity) {
        systemmenuMapper.update(entity);
    }

    @Override
    public PageResult pageQuery(SystemmenuQueryObject qo) {
        Long count = systemmenuMapper.getTotalCount(qo);
        if (count <= 0) {
            return new PageResult(Collections.EMPTY_LIST, 0, 1, qo.getPageSize());
        }
        List<Systemmenu> result = systemmenuMapper.pageQuery(qo);
        PageResult pageResult = new PageResult(result, count.intValue(), qo.getCurrentPage(), qo.getPageSize());
        return pageResult;
    }

    @Override
    public List<SystemMenuVO> queryParentListbyId(Long parentId) {
        List<SystemMenuVO> parentList = new ArrayList<>();
        //当前的对象
        Systemmenu cuttert = systemmenuMapper.get(parentId);
        while (cuttert != null) {
            SystemMenuVO vo = new SystemMenuVO();
            vo.setName(cuttert.getName());
            vo.setId(cuttert.getId());
            parentList.add(vo);
            /*获取到上一级的菜单*/
            cuttert = cuttert.getParent();
        }
		/* 就是下面开始拿值栈里面的值    reverse反转指定列表中元素的顺序。*/
        Collections.reverse(parentList);
        return parentList;
    }

    @Override
    public List<Systemmenu> queryMenusByParentSn(String parentSn) {
        //获取根据用户的权限进行菜单查询
        //1.获取到当前的登录信息
        Employee employee = UserContext.getCurrentUser();
        System.out.println(employee.getAdmin());
        if (employee.getAdmin()) {
        System.out.println("=============================");

			//这个就是会是管理员直接放行
            return systemmenuMapper.queryMenusByParentSn(parentSn);
        } else {
            return systemmenuMapper.queryMenusByParentSnAndEmpId(parentSn, employee.getId());
        }


    }
}
