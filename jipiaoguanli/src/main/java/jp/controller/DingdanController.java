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
import net.sf.json.JSONArray;

@Controller
public class DingdanController {

	@Resource
	private DingdanService dingdanService;

	/**
	 * 获取订单
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
	
	public void refundTicket() {
		
	}

}
