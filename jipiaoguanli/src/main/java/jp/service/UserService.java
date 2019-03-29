package jp.service;

import jp.entity.User;

public interface UserService {

	
	/**
	 * 用户登陆
	 * @param username
	 * @param password
	 */
	public User userLogin(String username);
}
