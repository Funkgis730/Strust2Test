package org.nju.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * @author ZZH
 * @category 计算Action花费的时间
 *
 */
public class TimeInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1377845530837186276L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long start=System.currentTimeMillis();
		String result=invocation.invoke();
		long end=System.currentTimeMillis();
		System.out.println("Action time:"+(end-start));
		return result;
	}
}
