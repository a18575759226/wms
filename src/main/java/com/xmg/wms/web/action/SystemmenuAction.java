package com.xmg.wms.web.action;

import com.xmg.wms.domain.Systemmenu;
import com.xmg.wms.page.PageResult;
import com.xmg.wms.query.SystemmenuQueryObject;
import com.xmg.wms.service.ISystemmenuService;
import com.xmg.wms.util.RequiredPermission;
import com.xmg.wms.vo.SystemMenuVO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class SystemmenuAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	@Setter
	private ISystemmenuService systemmenuService;

	@Getter@Setter
	private SystemmenuQueryObject qo=new SystemmenuQueryObject();

	@Setter
	private  String parentName;


	@Getter
	private Systemmenu systemmenu = new Systemmenu();
	
	@RequiredPermission("系统菜单列表")
	public String execute() throws Exception{

		try {
			PageResult pageResult = systemmenuService.pageQuery(qo);
			putContext("result",pageResult);

			List<SystemMenuVO> parentList = systemmenuService.queryParentListbyId(qo.getParentId());
			putContext("parentList",parentList);
		}catch (Exception e){
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return "list";
	}

	@RequiredPermission("系统菜单编辑")
	public String input() throws Exception {
		//这个就是查找qo.parentid查找到父级的菜单
		if (qo.getParentId()!=null&&qo.getParentId()>0 ) {
			//这个就是获取到里面的值元素
			Systemmenu parent = systemmenuService.get(qo.getParentId());
			putContext("parentName",parent.getName());
		}else {
			putContext("parentName","根目录");
		}
		try {
			if (systemmenu.getId() != null) {
                systemmenu = systemmenuService.get(systemmenu.getId());
            }
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return INPUT;
	}

	@RequiredPermission("系统菜单保存/更新")
	public String saveOrUpdate() {
		if(qo.getParentId()!=null&&qo.getParentId()>0 ){
			Systemmenu parent = systemmenuService.get(qo.getParentId());
			systemmenu.setParent(parent);
		}else {
			systemmenu.setParent(null);
		}
		try {
			if (systemmenu.getId() == null) {
                systemmenuService.save(systemmenu);
				addActionMessage("增加成功");
            } else {
                systemmenuService.update(systemmenu);
				addActionMessage("更新成功");
            }
		} catch (Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
		}
		return SUCCESS;
	}

	@RequiredPermission("系统菜单删除")
	public String delete()  throws  Exception {
		try {
			if (systemmenu.getId() != null) {
                systemmenuService.delete(systemmenu.getId());
				putMsg("删除成功");
            }
		} catch (Exception e) {
			e.printStackTrace();
			putMsg(e.getMessage());
		}
		return NONE;
	}

	public String queryMenusByParentSn() throws Exception{
		List<Systemmenu> menus = systemmenuService.queryMenusByParentSn(qo.getParentSn());
		ArrayList<Object> jsonList = new ArrayList<>();
		for (Systemmenu menu : menus) {
			jsonList.add(menu.toJson());

		}
		putJson(jsonList);
		return  NONE;
	}


}
