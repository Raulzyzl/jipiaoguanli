package jp.dao;

import jp.entity.Dingdan;

public interface PayDao {
	
	/**
	 * 账号金额变更
	 * @param username
	 * @return
	 */
	public Integer updateUserMoney(String username, int money);
	
	/**
	 * 购买机票
	 * @param piaojia
	 * @return
	 */
	public Integer payJipiao(Dingdan dingdan);

}
