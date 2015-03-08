package com.rency.dpf.dao;

import java.util.Date;
import java.util.List;

import org.rency.utils.exceptions.CoreException;

import com.rency.dpf.beans.User;
import com.rency.dpf.beans.UserType;

public interface UserDao {

	public User login(User user) throws CoreException;
	
	public List<User> load() throws CoreException;
	
	public User getByName(String userName) throws CoreException;
	
	public List<User> getByType(UserType userType) throws CoreException;
	
	public boolean save(User user) throws CoreException;
	
	public boolean update(User user) throws CoreException;
	
	public boolean updateLoginInfo(String guid,Date lastLogin, String loginIP,boolean online) throws CoreException;
	
	public boolean updatePassword(String guid,String password) throws CoreException;
	
	public boolean delete(User user) throws CoreException;
	
	public boolean deleteByGuid(String guid) throws CoreException;
	
}