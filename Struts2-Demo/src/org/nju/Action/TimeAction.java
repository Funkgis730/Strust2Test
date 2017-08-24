package org.nju.Action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author ZZH
 *
 */
public class TimeAction extends ActionSupport {

	private static final long serialVersionUID = -5216295401113686818L;

	@Override
	public String execute() throws Exception {
		for(int i=0;i<10000;i++)
			System.out.println("NJU!");
		return SUCCESS;
	}

}
