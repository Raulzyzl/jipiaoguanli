package jp.dao;

import java.util.List;

import jp.entity.Dingdan;

public interface DingdanDao {
	
	public List<Dingdan> getdingdan(String username);

}
