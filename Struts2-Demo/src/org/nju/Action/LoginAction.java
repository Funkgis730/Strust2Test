package org.nju.Action;


import java.sql.Connection;
import java.sql.SQLException;

import org.nju.po.User;
import org.nju.util.MysqlConn;
import org.nju.util.MysqlUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author ZZH
 *
 */
public class LoginAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = -4537988430647443287L;
	private User user= new User();
	
	public String login() throws SQLException{
		Connection conn=MysqlConn.getConnection();
		MysqlUtil util=new MysqlUtil(conn);
		
		if(util.searchUser(user.getAccount())){
			if(util.searchPassword(user.getAccount()).equals(user.getPassword())){
				return SUCCESS;
			}else{
				this.addFieldError("PasswordError", "The password is wrong!");
				return INPUT;
			}
		}else{
			this.addFieldError("AccountNotFound", "The account is not found");
			return INPUT;
		}
	}
	
	@Override
	public User getModel() {
		return user;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}




}
