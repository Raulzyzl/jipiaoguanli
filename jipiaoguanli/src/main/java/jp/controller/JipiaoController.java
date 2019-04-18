package jp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.entity.Jipiao;
import jp.service.JipiaoService;
import net.sf.json.JSONArray;

@Controller
public class JipiaoController {

	@Resource
	private JipiaoService jipiaoService;

	/**
	 * 获取所有机票信息
	 * @param map
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/getalljipiao", method = RequestMethod.POST)
	public void jipiaoList(Map<String, Object> map, HttpServletResponse response) throws IOException {
		List<Jipiao> jipiaolist = jipiaoService.getAlljipiao();
		JSONArray ja = JSONArray.fromObject(jipiaolist);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(ja.toString());
	}

	/**
	 * 条件搜索机票
	 * @param jipiao
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/findjipiao", method = RequestMethod.POST)
	public void findJipiao(Jipiao jipiao, HttpServletResponse response) throws IOException {
		List<Jipiao> jipiaolist = jipiaoService.getJipiao(jipiao);
		JSONArray ja = JSONArray.fromObject(jipiaolist);
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(ja.toString());
	}
	
}
