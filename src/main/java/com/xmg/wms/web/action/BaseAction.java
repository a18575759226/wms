package com.xmg.wms.web.action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

//通用的action类
public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	public static final String LIST = "list";

//	抽取代码

	public  void putMsg(String msg) throws  Exception{
		ServletActionContext.getResponse().setContentType("test/html;charsetUTF-8");
		ServletActionContext.getResponse().getWriter().print("删除成功");
	}
	public void putContext(String key,Object value)throws Exception{
		/*这个就是方法的抽取*/
		ActionContext.getContext().put(key,value);
	}

	public void putJson(Object object)throws Exception{
		ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
		//这个就是把里面的取出类转成json对象 然后返回到页面上面去
		ServletActionContext.getResponse().getWriter().print(JSON.toJSONString(object));
	}


}
