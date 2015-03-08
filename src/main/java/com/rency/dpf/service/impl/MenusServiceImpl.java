package com.rency.dpf.service.impl;

import java.util.List;

import org.rency.utils.exceptions.CoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rency.dpf.beans.Menus;
import com.rency.dpf.beans.UserType;
import com.rency.dpf.dao.MenusDao;
import com.rency.dpf.service.MenusService;

@Service("menusService")
public class MenusServiceImpl implements MenusService{

	@Autowired
	@Qualifier("menusDao")
	private MenusDao menusDao;
	
	@Override
	public List<Menus> queryMenus(UserType userType) throws CoreException {
		return menusDao.getMenus(userType);
	}

	@Override
	public List<Menus> list() throws CoreException {
		return menusDao.loadAll();
	}
	
	@Override
	public boolean add(Menus menus) throws CoreException {
		Menus re = menusDao.getByResId(menus.getParentResId());
		menus.setParentResName(re.getResName());
		return menusDao.save(menus);
	}
	
	@Override
	public boolean update(Menus menus) throws CoreException {
		Menus re = menusDao.getByResId(menus.getParentResId());
		menus.setParentResName(re.getResName());
		return menusDao.update(menus);
	}

	@Override
	public boolean delete(Menus menus) throws CoreException {
		return menusDao.delete(menus);
	}

	@Override
	public boolean deleteById(String resId) throws CoreException {
		return menusDao.deleteById(resId);
	}

	@Override
	public Menus queryByResId(String resId) throws CoreException {
		return menusDao.getByResId(resId);
	}
	
	public List<Menus> queryByResName(String resName) throws CoreException{
		return menusDao.getByResName(resName);
	}

}
