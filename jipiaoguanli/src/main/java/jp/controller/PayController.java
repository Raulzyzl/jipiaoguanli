package jp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import jp.entity.Dingdan;
import jp.entity.Jipiao;
import jp.entity.User;
import jp.service.PayService;

@Controller
public class PayController {

	@Resource
	private PayService payService;

	/**
	 * 充值
	 * @param money
	 * @param httpSession
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value = "/updatemoney", method = RequestMethod.POST)
	@ResponseBody
	public void updateMoney(int money, HttpSession httpSession, HttpServletResponse response) throws IOException {
		User user = (User) httpSession.getAttribute("loginid");
		int result = payService.updateUserMoney(user.getUsername(), money);
		JSONObject jo = new JSONObject();
		if (result == 1) {
			jo.put("msg", "ok");
		}else {
			jo.put("msg", "no");
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jo.toString());
	}
	
	/**
	 * 购买机票
	 * @param jipiao
	 * @param yiwaixian
	 * @param yanwuxian
	 * @param httpSession
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/payjipiao", method = RequestMethod.POST)
	@ResponseBody
	public void payJipiao(Jipiao jipiao, int yiwaixian, int yanwuxian, HttpSession httpSession, HttpServletResponse response) throws IOException {
		User user = (User) httpSession.getAttribute("loginid");
		JSONObject jo = new JSONObject();
		if(user.getMoney() < (jipiao.getPiaojia() + yiwaixian + yanwuxian)) {
			jo.put("msg", "余额不足，请充值");
		}else {
			Date dNow = new Date( );
		    SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		    String date = ft.format(dNow);
		    Dingdan dingdan = new Dingdan();
		    dingdan.setUser_id(user);
		    dingdan.setJipiao_id(jipiao);
		    dingdan.setYanwuxian(yanwuxian);
		    dingdan.setYiwaixian(yiwaixian);
		    dingdan.setGoumairiqi(date);
		    int payresult = payService.payJipiao(dingdan);
		    if (payresult != 0) {
		    	jo.put("msg", "购买成功！");
			}else {
				jo.put("msg", "购买失败");
			}
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jo.toString());
	}
	
}
