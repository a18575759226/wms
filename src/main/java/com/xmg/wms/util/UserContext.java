package com.xmg.wms.util;


import com.opensymphony.xwork2.ActionContext;
import com.xmg.wms.domain.Employee;

import java.util.Set;

/**
 * Created by Administrator on 2017/5/30.
 */
public class UserContext {

    public static void setCurrentUser(Employee employee) {
        /*把这个放到session里面*/
        ActionContext.getContext().getSession().put("EMPLOYEE_IN_SESSION", employee);
    }
    //从session里面获取到当前用户的值
    public static Employee getCurrentUser(){
        return (Employee) ActionContext.getContext().getSession().get("EMPLOYEE_IN_SESSION");
    }


    /*把权限集放到session作为共享 */
    public static void setCurrentPermissionSet(Set<String> permissionSet) {
        ActionContext.getContext().getSession().put("PERMISSION_IN_SESSION", permissionSet);
    }

    public static Set<String> getCurrentPermissionSet(){
        return(Set<String>) ActionContext.getContext().getSession().get("PERMISSION_IN_SESSION");
    }

}