package jp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.entity.Admin;
import jp.entity.Jipiao;
import jp.entity.User;
import jp.service.AdminService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
//设置session，名字叫adminid
@SessionAttributes(value = { "adminid" })
public class AdminController {

	@Resource
	private AdminService adminService;

	@RequestMapping(value = "/adminglogin", method = RequestMethod.POST)
	@ResponseBody
	public void adminlogin(String adminname, String adminpassword, Map<String, Object> map,
			HttpServletResponse response) throws IOException {
		JSONObject jo = new JSONObject();
		Admin admin = adminService.adminLogin(adminname);
		if (admin.getAdminpassword().equals(adminpassword)) {
			jo.put("msg", "200");
			map.put("adminid", admin);
		} else {
			jo.put("msg", "500");
		}
		response.getWriter().write(jo.toString());
	}

	@RequestMapping(value = "/admingetuser", method = RequestMethod.POST)
	@ResponseBody
	public void admingetuser(HttpSession httpSession, HttpServletResponse response) throws IOException {
		List<User> listuser = adminService.getAllUser();
		JSONArray ja = JSONArray.fromObject(listuser);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(ja.toString());
	}
	
	@RequestMapping(value = "/admindeleteuser", method = RequestMethod.POST)
	@ResponseBody
	public void admindeluser(String username, HttpSession httpSession, HttpServletResponse response) throws IOException {
		JSONObject jo = new JSONObject();
		int isdingdannull = adminService.countdingdan(username);
		if(isdingdannull != 0) {
			jo.put("msg", "用户还有未出行订单，不能删除");
		}else {
			adminService.deleteUser(username);
			jo.put("msg", "成功删除用户"+username);
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jo.toString());
	}
	
	@RequestMapping(value = "/admingetjipiao", method = RequestMethod.POST)
	@ResponseBody
	public void admingetjipiao(HttpSession httpSession, HttpServletResponse response) throws IOException {
		List<Jipiao> listjipiao = adminService.getAllJipiao();
		JSONArray ja = JSONArray.fromObject(listjipiao);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(ja.toString());
	}
	
	@RequestMapping(value = "/adminaddjipiao", method = RequestMethod.POST)
	@ResponseBody
	public void adminaddjipiao(Jipiao jipiao, String hangkonggongsi, HttpSession httpSession, HttpServletResponse response) throws IOException {
		int addresult = adminService.addJipiao(jipiao, hangkonggongsi);
		JSONObject jo = new JSONObject();
		if(addresult != 0) {
			jo.put("msg", "添加成功！");
		}else {
			jo.put("msg", "添加失败，请重试。");
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jo.toString());
	}
	
	@RequestMapping(value = "/admindeletejipiao", method = RequestMethod.POST)
	@ResponseBody
	public void admindeletejipiao(int id, HttpSession httpSession, HttpServletResponse response) throws IOException {
		int deleteresult = adminService.deleteJipiao(id);
		JSONObject jo = new JSONObject();
		if(deleteresult != 0) {
			jo.put("msg", "删除成功！");
		}else {
			jo.put("msg", "删除失败，请重试。");
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(jo.toString());
	}
}
