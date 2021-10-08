package com.example.demo3.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
 
@Service
public class HelloService {

	@Autowired
    JdbcTemplate jdbcTemplate;

	public List<Map<String,Object>> getList() {

        List<Map<String,Object>> list;
        list = jdbcTemplate.queryForList("select * from member");
	
		return list;
	}
}