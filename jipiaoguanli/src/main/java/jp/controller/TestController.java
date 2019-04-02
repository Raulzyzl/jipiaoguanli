package jp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import jp.entity.User;

@Controller
public class TestController {

	@RequestMapping(value = "/test",method=RequestMethod.POST)
	@ResponseBody
	public void test(HttpSession httpSession, HttpServletResponse response) throws IOException {
		User user = (User) httpSession.getAttribute("loginid");
		if(user == null || user.getUsername().isEmpty()) {
			System.out.println("null");
		}else {
			System.out.println(user.getUseraccount());
			JSONObject jo = new JSONObject();
			jo.put("msg", user);
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(jo.toString());
		}
	}
	
	public static void main(String[] args) {
		Date dNow = new Date( );
	      SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
	      String date = ft.format(dNow);
	      System.out.println("当前时间为: " + date);
	}
	
}
