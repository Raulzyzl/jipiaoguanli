package jp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import jp.entity.Admin;
import jp.entity.Jipiao;
import jp.entity.User;

public interface AdminDao {
	
	/**
	 * 管理员登陆
	 * @param username
	 * @return
	 */
	public Admin adminLogin(String adminname);

	/**
	 * 管理员获取所有用户
	 * @return
	 */
	public List<User> getAllUser();
	
	/**
	 * 查询需删除用户有多少未完成订单
	 * @param userid
	 * @return
	 */
	public int countdingdan(String username);
	
	/**
	 * 管理员删除用户
	 * @param username
	 * @return
	 */
	public int deleteUser(String username);
	
	/**
	 * 获取所有机票
	 * @return
	 */
	public List<Jipiao> getAllJipiao();
	
	/**
	 * 添加机票
	 * @param jipiao
	 * @return
	 */
	public int addJipiao(@Param("jp")Jipiao jipiao, @Param("hkgs")String hangkonggongsi);
	
	/**
	 * 删除机票
	 * @param id
	 * @return
	 */
	public int deleteJipiao(int id);
}
