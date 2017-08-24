package org.nju.Action;

import java.sql.Connection;
import java.sql.SQLException;

import org.nju.po.User;
import org.nju.util.MysqlConn;
import org.nju.util.MysqlUtil;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport  implements ModelDriven<User> {

	private static final long serialVersionUID = 8663845929563129493L;
	
	User user=new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception{
		return super.execute();
	}
	
	public String register() throws SQLException{
		Connection conn=MysqlConn.getConnection();
		MysqlUtil util=new MysqlUtil(conn);
		
		if(util.searchUser(user.getAccount())){
			this.addFieldError("AccountRepeat", "The account is repeated!");
			return INPUT;
		}
		
		if(user.getPassword().length()<6){
			this.addFieldError("PasswordLength", "Password is too short!");
			return INPUT;
		}
		
		if(util.insert(user)>0){
			util.connectionClose();
			System.out.println("submit success!");
			return LOGIN;
		}else{
			util.connectionClose();
			System.out.println("submit error!");
			this.addFieldError("SystemError", "System Error!");
			return INPUT;
		}
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
	}

	@Override
	public User getModel() {
		return user;
	}
	

}
