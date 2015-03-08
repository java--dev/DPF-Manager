package com.rency.dpf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.rency.utils.common.CONST;
import org.rency.utils.exceptions.CoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rency.dpf.beans.UserType;
import com.rency.dpf.dao.UserTypeDao;
import com.rency.dpf.service.UserTypeService;

@Service("userTypeService")
public class UserTypeServiceImpl implements UserTypeService {

	@Autowired
	@Qualifier("userTypeDao")
	private UserTypeDao userTypeDao;

	@Override
	public List<UserType> list() throws CoreException {
		return userTypeDao.list();
	}
	
	@Override
	public List<UserType> listWithoutSuper() throws CoreException {
		List<UserType> allList = userTypeDao.list();
		List<UserType> tempList = new ArrayList<UserType>(allList);
		for(UserType u : tempList){
			if(u.getTypeId() == CONST.USER_TYPE_SUPER){
				allList.remove(u);
			}
		}
		return allList;
	}

	@Override
	public UserType queryById(Integer id) throws CoreException {
		return userTypeDao.getById(id);
	}
	
	@Override
	public boolean add(UserType userType) throws CoreException {
		return userTypeDao.save(userType);
	}

	@Override
	public boolean update(UserType userType) throws CoreException {
		return userTypeDao.update(userType);
	}

	@Override
	public boolean deleteById(int typeId) throws CoreException {
		return userTypeDao.deleteById(typeId);
	}
}
