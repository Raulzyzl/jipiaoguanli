package jp.service;

public interface PayService {
	
	/**
	 * 账号充值
	 * @param username
	 * @return
	 */
	public Integer updateUserMoney(String username, int money);

}
