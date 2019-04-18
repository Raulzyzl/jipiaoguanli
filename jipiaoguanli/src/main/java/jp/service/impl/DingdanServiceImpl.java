package jp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jp.dao.DingdanDao;
import jp.entity.Dingdan;
import jp.service.DingdanService;

@Service("dingdanService")
public class DingdanServiceImpl implements DingdanService{

	@Resource
	private DingdanDao dingdanDao; 
	
	public List<Dingdan> getdingdan(String username) {
		return dingdanDao.getdingdan(username);
	}

}
