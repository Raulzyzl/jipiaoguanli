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
//设置session，名字叫loginid
@SessionAttributes(value={"loginid"})
public class UserController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 登陆功能
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
		//创建一个json对象
		JSONObject jo = new JSONObject();
		//如果传过来的登陆名为空
		if(username == null && "".equals(username)){
			//添加一个信息到json对象中,
			jo.put("msg", "404");
		}
		else {
			//从数据库中获取与前台传过来的用户名一样的用户的数据
			User user = userService.userLogin(username);
			//如果用户数据中密码与传过来的密码一致
			if (user.getPassword().equals(password)) {
				jo.put("msg", "200");
				//将user放到session中（因为springmvc中可以在方法定义一个map对象，然后用map将数据放到session中）
				map.put("loginid", user);
			}else {
				//如果不一样
				jo.put("msg", "500");
			}
		}
		//将json数据传到前台
		response.getWriter().write(jo.toString());
	}
	
	/**
	 * 获取用户信息功能
	 * @param httpSession
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/getuser", method = RequestMethod.POST)
	@ResponseBody
	public void getuser(HttpSession httpSession, HttpServletResponse response) throws IOException {
		//将session中的user信息取出来
		User user = (User) httpSession.getAttribute("loginid");
		JSONObject jo = new JSONObject();
		//判断user是否有数据，没有则为没登陆，登陆了才有数据
		if(user == null || user.getUsername().isEmpty()) {
			jo.put("msg", "nologin");
		}else {
			System.out.println(user.getUseraccount());
			jo.put("msg", user);
			//以utf-8编码将json数据传到前台
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(jo.toString());
		}
		
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public void register(User user, HttpSession httpSession, HttpServletResponse response,Map<String,Object> map) throws IOException {
		System.out.println(user.toString());
		JSONObject jo = new JSONObject();
		//从数据库中查找有无与注册用户名一样的数据
		Integer isGetName = userService.selectName(user.getUsername());
		if(isGetName != null) {
			//有重复
			jo.put("msg", "repeat");
		}else {
			//无重复
			userService.addUser(user);
			map.put("loginid", user);
			jo.put("msg", "ok");
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jo.toString());
	}
	
}
