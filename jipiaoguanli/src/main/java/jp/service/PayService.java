package jp.service;

import jp.entity.Dingdan;

public interface PayService {
	
	/**
	 * 账号充值
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
