package jp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jp.dao.AdminDao;
import jp.entity.Admin;
import jp.entity.Jipiao;
import jp.entity.User;
import jp.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Resource
	private AdminDao adminDao;
	
	public List<User> getAllUser() {
		return adminDao.getAllUser();
	}
	
	public Integer countdingdan(String username) {
		return adminDao.countdingdan(username);
	}

	public Integer deleteUser(String username) {
		return adminDao.deleteUser(username);
	}

	public Admin adminLogin(String adminname) {
		return adminDao.adminLogin(adminname);
	}

	public List<Jipiao> getAllJipiao() {
		return adminDao.getAllJipiao();
	}

	public Integer addJipiao(Jipiao jipiao, String hangkonggongsi) {
		return adminDao.addJipiao(jipiao, hangkonggongsi);
	}

	public Integer deleteJipiao(int id) {
		return adminDao.deleteJipiao(id);
	}

	

}
