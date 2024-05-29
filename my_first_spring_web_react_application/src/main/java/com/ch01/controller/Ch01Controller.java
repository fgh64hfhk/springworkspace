package com.ch01.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ch01.model.Cat;

import jakarta.servlet.ServletContext;

@Controller
public class Ch01Controller {

	ServletContext context;

	@Autowired
	public Ch01Controller(ServletContext context) {
		this.context = context;
	}

	@GetMapping("/")
	public String home() {
		// 請視圖解析器由視圖的邏輯名稱index來找出真正的視圖
		return "index";
	}

	@GetMapping("/ch01/index")
	public String index() {
		// 請視圖解析器由視圖的邏輯名稱ch01/index來找出真正的視圖
		return "ch01/index";
	}

	@GetMapping("/ch01/sayHello")
	public String sayHello(Model model) {
		return "ch01/hello";
	}

	@GetMapping("/ch01/serverTime")
	public String serverTime(Model model) {
		java.util.Date d = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒 SSS豪秒");
		String timeNow = sdf.format(d);
		// 如果Controller有資料要交給View，可以透過Model.addAttribute()方法
		model.addAttribute("now", timeNow + ", Spring MVC版");
		return "ch01/serverTime";
	}

	@GetMapping("/ch02/beanLifeCycle")
	public void beanLifeCycle(Model model) {
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		Cat c1 = wac.getBean(Cat.class);
		model.addAttribute("timeCreating", c1.getTimeCreating());
	}
}
