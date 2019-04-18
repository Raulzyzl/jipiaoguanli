package jp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jp.dao.UserDao;
import jp.entity.User;
import jp.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	public User userLogin(String username) {
		return userDao.userLogin(username);
	}

	public void addUser(User user) {
		userDao.addUser(user);
	}

	public Integer selectName(String username) {
		return userDao.selectName(username);
	}

	public Integer updateUser(User user) {
		return userDao.updateUser(user);
	}

}
