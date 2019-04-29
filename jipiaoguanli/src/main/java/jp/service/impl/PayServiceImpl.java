package jp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jp.dao.PayDao;
import jp.entity.Dingdan;
import jp.service.PayService;

@Service("payService")
public class PayServiceImpl implements PayService{

	@Resource
	private PayDao payDao;
	
	public Integer updateUserMoney(String username, int money) {
		return payDao.updateUserMoney(username, money);
	}

	public Integer payJipiao(Dingdan dingdan) {
		return payDao.payJipiao(dingdan);
	}

}
