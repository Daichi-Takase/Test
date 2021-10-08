package com.example.demo3.controller;

import java.util.List;
import java.util.Map;

import com.example.demo3.service.HelloService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class HelloController {

	@Autowired
    JdbcTemplate jdbcTemplate;

	@Autowired
    HelloService helloService;

    @RequestMapping("/hello")
	public String index(Model model) {

		List<Map<String,Object>> list = helloService.getList();
		model.addAttribute("list", list);
		return "list";
	}
}