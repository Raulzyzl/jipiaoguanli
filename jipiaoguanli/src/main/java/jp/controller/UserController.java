package jp.controller;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSONObject;

import jp.entity.User;
import jp.service.UserService;

/**
 *  用户模块
 * @author admin
 *
 */
@Controller
@SessionAttributes(value={"loginid"})
public class UserController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 登陆模块
	 * @param username
	 * @param password
	 * @param request
	 * @param map
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value = "/login" , method = RequestMethod.POST)
	@ResponseBody
	public void login(String username,
			String password,
			HttpServletRequest request,
			Map<String,Object> map,
			HttpServletResponse response) throws IOException {
		JSONObject jo = new JSONObject();
		if(username == null && "".equals(username)){
			jo.put("msg", "null");
		}
		else {
			User user = userService.userLogin(username); 
			if (user.getPassword().equals(password)) {
				jo.put("msg", "yes");
				map.put("loginid", user);
			}else {
				jo.put("msg", "no");
			}
		}
		response.getWriter().write(jo.toString());
	}
	
	
	
	

}
