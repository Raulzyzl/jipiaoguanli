package jp.dao;

import java.util.List;

import jp.entity.Jipiao;

public interface JipiaoDao {
	
	/**
	 * 获取所有的机票信息
	 * @param 
	 * @return
	 */
	public List<Jipiao> getAlljipiao();
	
	/**
	 * 根据条件搜索
	 * @param jipiao
	 * @return
	 */
	public List<Jipiao> getJipiao(Jipiao jipiao);
	
}
