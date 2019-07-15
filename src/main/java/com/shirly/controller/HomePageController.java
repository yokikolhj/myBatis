package com.shirly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shirly.data.base.User;
import com.shirly.data.base.UserExample;
import com.shirly.data.base.UserExample.Criteria;
import com.shirly.data.mapper.UserMapper;
import com.shirly.data.model.DataResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/homePage")
@Api(tags = "首页相关接口")
public class HomePageController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value = "/getAllUser", produces = "application/json; charset=utf-8", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "获取所有用户")
	public DataResponse getAllDeviceList(HttpServletRequest req) {
		UserExample example = new UserExample();
		Criteria c1 = example.createCriteria();
		c1.andUseridBetween(1, 5);
		c1.andPasswordEqualTo("123456");
		/*Criteria c2 = example.createCriteria();
		c2.andPasswordEqualTo("123321");
		example.or(c2);*/
		example.setOrderByClause("updateTime");
		String s = example.getOrderByClause();
		List<User> user = userMapper.selectByExample(example);
		DataResponse response = new DataResponse();
		response.setData(user);
		response.setMsg(s);
		return response;
	}
	
}
