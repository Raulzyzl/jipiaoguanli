package jp.dao;

public interface PayDao {
	
	/**
	 * 账号金额变更
	 * @param username
	 * @return
	 */
	public Integer updateUserMoney(String username, int money);
	
	

}
