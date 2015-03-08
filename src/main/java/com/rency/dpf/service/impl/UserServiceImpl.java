package com.rency.dpf.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.rency.utils.common.CONST;
import org.rency.utils.exceptions.CoreException;
import org.rency.utils.tools.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rency.dpf.beans.User;
import com.rency.dpf.beans.UserType;
import com.rency.dpf.dao.UserDao;
import com.rency.dpf.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	
	@Override
	public User login(User user) throws CoreException {
		return userDao.login(user);
	}

	@Override
	public List<User> list() throws CoreException {
		return userDao.load();
	}
	
	@Override
	public List<User> listWithoutSuper() throws CoreException {
		List<User> allList = userDao.load();
		List<User> tempList = new ArrayList<User>(allList);
		for(User u : tempList){
			if(u.getUserType().getTypeId() == CONST.USER_TYPE_SUPER){
				allList.remove(u);
			}
		}
		return allList;
	}
	
	@Override
	public User queryByName(String userName) throws CoreException {
		return userDao.getByName(userName);
	}
	
	@Override
	public List<User> queryByType(UserType userType) throws CoreException {
		return userDao.getByType(userType);
	}

	@Override
	public boolean add(User user) throws CoreException {
		user.setPassword(MD5Utils.getMD5String(user.getPassword()));
		return userDao.save(user);
	}

	@Override
	public boolean update(User user) throws CoreException {
		user.setPassword(MD5Utils.getMD5String(user.getPassword()));
		return userDao.update(user);
		
	}
	
	@Override
	public boolean updateLoginInfo(String guid,Date lastLogin, String loginIP,boolean online) throws CoreException {
		return userDao.updateLoginInfo(guid,lastLogin, loginIP,online);
	}

	@Override
	public boolean updatePassword(String guid,String password) throws CoreException{
		password = MD5Utils.getMD5String(password);
		return userDao.updatePassword(guid, password);
	}
	
	@Override
	public boolean delete(User user) throws CoreException {
		user.setPassword(MD5Utils.getMD5String(user.getPassword()));
		return userDao.delete(user);
	}

	@Override
	public boolean deleteByGuid(String guid) throws CoreException {
		return userDao.deleteByGuid(guid);
	}

}
