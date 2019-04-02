package jp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import jp.service.JipiaoService;

@Controller
public class JipiaoController {
	
	@Resource
	private JipiaoService jipiaoService;
	
	

}
