package com.rency.dpf.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.rency.utils.common.CONST;
import org.rency.utils.exceptions.CoreException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.rency.dpf.beans.User;
import com.rency.dpf.beans.UserType;
import com.rency.dpf.service.UserService;

public class UserServiceImplTest {
	
	private UserService userService;
	
	@Before
	public void before(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/test/resources/applicationContext.xml");
		userService = ctx.getBean(UserService.class);
	}
	
	@Test
	public void testAdd() throws CoreException {
		UserType userType = new UserType();
		userType.setTypeId(CONST.USER_TYPE_SUPER);
		userType.setTypeName("超级管理员");

		User queryUser = userService.queryByName("rency");
		if(queryUser == null){
			User user = new User();
			user.setUsername("rency");
			user.setPassword("888");
			user.setEmail("user_rcy@163.com");
			user.setMobilePhone("13585740802");
			user.setUserType(userType);
			userService.add(user);
			System.out.println("save "+user.toString()+" success.");
		}
		
	}

}
