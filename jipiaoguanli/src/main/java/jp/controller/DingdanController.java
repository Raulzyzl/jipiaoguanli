package jp.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.entity.Dingdan;
import jp.entity.User;
import jp.service.DingdanService;
import jp.service.PayService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class DingdanController {

	@Resource
	private DingdanService dingdanService;
	@Resource
	private PayService payService;
	
	//正常状态
	public static int STATUS_ZHENGCHANG = 0;
	//改签状态
	public static int STATUS_GAIQIAN = 1;
	//退票状态
	public static int STATUS_TUIPIAO = 2;

	/**
	 * 获取订单
	 * 
	 * @param httpSession
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/getdingdan", method = RequestMethod.POST)
	public void getDingdan(HttpSession httpSession, HttpServletResponse response) throws IOException {
		User user = (User) httpSession.getAttribute("loginid");
		List<Dingdan> list = dingdanService.getdingdan(user.getUsername());
		JSONArray ja = JSONArray.fromObject(list);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(ja.toString());
	}

	/**
	 * 退票
	 * 
	 * @param shouxufei
	 * @param httpSession
	 * @param response
	 * @throws IOException
	 */
	public void refundTicket(int jipiaomoney, HttpSession httpSession, HttpServletResponse response)
			throws IOException {
		User user = (User) httpSession.getAttribute("loginid");
		JSONObject jo = new JSONObject();
		int updatemoney = (int) (user.getMoney() + (jipiaomoney * 0.8));
		int status = STATUS_TUIPIAO;
		payService.updateUserMoney(user.getUsername(), updatemoney);
		dingdanService.updateStatus(status);
		jo.put("msg", "退票成功");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jo.toString());
	}
	
	public void changeTicket(int changejipiaoid, HttpSession httpSession, HttpServletResponse response) {
		User user = (User) httpSession.getAttribute("loginid");
		
	}

}
