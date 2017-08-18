package com.xmg.wms.web.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.xmg.wms.domain.Employee;
import com.xmg.wms.util.UserContext;

public class CheckLoginInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/*Object currentEmp = invocation.getInvocationContext().getSession()
				.get("EMPLOYEE_IN_SESSION");*/
		Employee currentEmp = UserContext.getCurrentUser();

		if (currentEmp == null) {
			return Action.LOGIN;
		}
		return invocation.invoke();
	}

}
