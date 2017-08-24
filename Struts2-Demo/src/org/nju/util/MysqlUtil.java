package org.nju.util;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.nju.po.User;


/**
 * 
 * @author zzh
 * @category 数据库操作方法
 *
 */
public class MysqlUtil {
	public Connection conn=null;
	public MysqlUtil(){
		
	}
	
	/**
	 * 
	 * @param conn 数据库链接
	 */
	public MysqlUtil(Connection conn){
		this.conn=conn;
	}
	
	/**
	 * 
	 * @param u 用户属性类
	 * @return  数据库更新列表数量
	 * @throws SQLException
	 */
	public int insert(User u) throws SQLException {
		Connection conn = this.conn;
		String sql = "INSERT struts(account,password) VALUES (?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);


		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, u.getAccount());
		pstmt.setString(2, u.getPassword());

		int flag = pstmt.executeUpdate();
		pstmt.close();
		return flag;
	}
	
	/**
	 * 
	 * @param acc 账户
	 * @return 数据库是否包含指定账户
	 * @throws SQLException
	 */
		public boolean searchUser(String acc) throws SQLException {
			Connection conn = this.conn;
			String sql = "select account from struts";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<String> accountList = new ArrayList<String>();

			while (rs.next()) {
				String account = rs.getString("account");
				accountList.add(account);
			}

			Iterator<String> it = accountList.iterator();

			while (it.hasNext()) {
				String a = (String) it.next();
				if (a.equals(acc)) {
					return true;
				}
			}
			rs.close();
			return false;
		}
		
		/**
		 * 
		 * @param user 用户名
		 * @return 账户对应密码
		 * @throws SQLException
		 */
		public String searchPassword(String acc) throws SQLException {
			String pass = null;
			Connection conn = this.conn;
			String sql = "select password from struts where account = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pass = rs.getString("password");
			}
			return pass;
		}
	

	/**
	 * @category 关闭连接
	 */
	public void connectionClose(){
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

