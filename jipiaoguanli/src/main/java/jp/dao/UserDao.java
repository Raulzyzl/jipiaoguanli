package jp.dao;

import jp.entity.User;

/**
 * 用户功能接口
 * @author admin
 *
 */
public interface UserDao {

	/**
	 * 用户登陆
	 * @param username
	 * @param password
	 */
	public User userLogin(String username);
	
}
