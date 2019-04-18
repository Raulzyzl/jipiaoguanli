package jp.service;

import jp.entity.User;

public interface UserService {

	
	/**
	 * 用户登陆
	 * @param username
	 * @param password
	 */
	public User userLogin(String username);
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public void addUser(User user);
	
	/**
	 * 查询有无与传入的username匹配的结果--注册
	 * @param username
	 * @return
	 */
	public Integer selectName(String username);
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public Integer updateUser(User user);
}
