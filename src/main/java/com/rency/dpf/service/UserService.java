package com.rency.dpf.service;

import java.util.Date;
import java.util.List;

import org.rency.utils.exceptions.CoreException;

import com.rency.dpf.beans.User;
import com.rency.dpf.beans.UserType;

public interface UserService {

	public User login(User user) throws CoreException;
	
	public List<User> list() throws CoreException;
	
	public List<User> listWithoutSuper() throws CoreException;
	
	public User queryByName(String userName) throws CoreException;
	
	public List<User> queryByType(UserType userType) throws CoreException;
	
	public boolean add(User user) throws CoreException;
	
	public boolean update(User user) throws CoreException;
	
	/**
	 * @desc 更新用户登陆信息
	 * @date 2014年12月2日 上午11:19:28
	 * @param guid
	 * @param lastLogin
	 * @param loginIP
	 * @param online
	 * @return
	 * @throws CoreException
	 */
	public boolean updateLoginInfo(String guid,Date lastLogin,String loginIP,boolean online) throws CoreException;
	
	public boolean updatePassword(String guid,String password) throws CoreException;
	
	public boolean delete(User user) throws CoreException;
	
	public boolean deleteByGuid(String guid) throws CoreException;
	
}