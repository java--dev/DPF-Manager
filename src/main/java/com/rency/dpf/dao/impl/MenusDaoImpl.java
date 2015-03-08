package com.rency.dpf.dao.impl;

import java.util.List;

import org.rency.utils.dao.BasicDao;
import org.rency.utils.exceptions.CoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.rency.dpf.beans.Menus;
import com.rency.dpf.beans.UserType;
import com.rency.dpf.dao.MenusDao;

@Repository("menusDao")
public class MenusDaoImpl implements MenusDao {
	
	private static final Logger logger = LoggerFactory.getLogger(MenusDaoImpl.class);
	
	@Autowired
	@Qualifier("hibernateDao")
	private BasicDao basicDao;
	
	private final String ENTITY = Menus.class.getName();	
	private final String RESID = "resId";
	
	@Override
	public List<Menus> getMenus(UserType userType) throws CoreException {
		String queryString = "from " + ENTITY + " as model where model.userType=? order by model.priority asc";
		try{
			return basicDao.findByHQL(queryString, userType);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Menus> loadAll() throws CoreException {
		try{
			return basicDao.loadAll(Menus.class);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean save(Menus menus) throws CoreException {
		try{
			return basicDao.save(menus);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean update(Menus menus) throws CoreException {
		try{
			return basicDao.update(menus);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public boolean delete(Menus menus) throws CoreException {
		try{
			return basicDao.delete(menus);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean deleteById(String resId) throws CoreException {
		try{
			return basicDao.deleteByProperty(ENTITY, RESID, resId);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Menus getByResId(String resId) throws CoreException {
		try{
			return basicDao.get(Menus.class, resId);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Menus> getByResName(String resName) throws CoreException{
		String queryString = "from " + ENTITY + " as model where model.resName=? order by model.priority asc";
		try{
			return basicDao.findByHQL(queryString, resName);
		}catch(CoreException e){
			logger.error("exec ["+queryString+"] error."+e);
			e.printStackTrace();
			throw e;
		}
	}
	
}