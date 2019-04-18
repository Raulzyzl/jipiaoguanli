package jp.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

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
	
}
