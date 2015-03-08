package com.rency.dpf.dao.impl;

import java.util.List;

import org.rency.utils.dao.BasicDao;
import org.rency.utils.exceptions.CoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.rency.dpf.beans.UserType;
import com.rency.dpf.dao.UserTypeDao;

@Repository("userTypeDao")
public class UserTypeDaoImpl implements UserTypeDao {

	private static final Logger logger = LoggerFactory.getLogger(UserTypeDaoImpl.class);
	
	@Autowired
	@Qualifier("hibernateDao")
	private BasicDao basicDao;
	
	private final String ENTITY = UserType.class.getName();	
	private final String TYPEID = "typeId";

	@Override
	public List<UserType> list() throws CoreException {
		try{
			return basicDao.loadAll(UserType.class);
		}catch(CoreException e){
			logger.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public UserType getById(Integer id) throws CoreException {
		String queryString = "from " + ENTITY + " as model where model.typeId=?";
		try{
			List<UserType> list = basicDao.findByHQL(queryString, id);
			if(list != null && list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(CoreException e){
			logger.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean save(UserType userType) throws CoreException {
		try{
			return basicDao.save(userType);
		}catch(CoreException e){
			logger.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean update(UserType userType) throws CoreException {
		try{
			return basicDao.update(userType);
		}catch(CoreException e){
			logger.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean delete(UserType userType) throws CoreException {
		try{
			return basicDao.delete(userType);
		}catch(CoreException e){
			logger.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean deleteById(Integer id) throws CoreException {
		try{
			return basicDao.deleteByProperty(ENTITY, TYPEID, id);
		}catch(CoreException e){
			logger.error(e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

}
