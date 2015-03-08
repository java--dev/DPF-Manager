package com.rency.dpf.dao.impl;

import java.util.List;

import org.rency.utils.common.CONST;
import org.rency.utils.dao.BasicDao;
import org.rency.utils.exceptions.CoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.rency.dpf.beans.Authority;
import com.rency.dpf.beans.UserType;
import com.rency.dpf.dao.AuthorityDao;

@Repository("authorityDao")
public class AuthorityDaoImpl implements AuthorityDao {

	private static final Logger logger = LoggerFactory.getLogger(AuthorityDaoImpl.class);
	
	@Autowired
	@Qualifier("hibernateDao")
	private BasicDao basicDao;
	
	private final String ENTITY = Authority.class.getName();	
	private final String ID = "id";	
	private final String RESOURCES = "resources";	
	private final String USERTYPE = "userType";
	
	@Override
	public boolean findAuth(Authority authority) throws CoreException {
		String queryString = "from " + ENTITY + " as model where model."+RESOURCES+"=? and model."+USERTYPE+"=?";
		try{
			List<Authority> list = basicDao.findByHQL(queryString, new Object[]{authority.getResources(),authority.getUserType()});
			if(list != null && list.size() > 0){
				return true;
			}else{
				return false;
			}
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Authority> list() throws CoreException {
		String queryString = "from "+ENTITY+" as model where model."+USERTYPE+"=? order by model.id";
		try{
			UserType userType = new UserType();
			userType.setTypeId(CONST.USER_TYPE_SUPER);
			return basicDao.findByHQL(queryString,userType);
		}catch(CoreException e){
			logger.error("exec ["+queryString+"] error."+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public List<Authority> getByAddr(String resources) throws CoreException{
		String queryString = "from "+ENTITY+" as model where model."+RESOURCES+"=? and model."+USERTYPE+"=? order by model.id";
		try{
			UserType userType = new UserType();
			userType.setTypeId(CONST.USER_TYPE_SUPER);
			return basicDao.findByHQL(queryString, new Object[]{resources,userType});
		}catch(CoreException e){
			logger.error("exec ["+queryString+"] error."+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public boolean save(Authority authority) throws CoreException {
		try{
			return basicDao.save(authority);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean update(Authority authority) throws CoreException {
		try{
			return basicDao.update(authority);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean delete(Authority authority) throws CoreException {
		try{
			return basicDao.delete(authority);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@Override
	public boolean deleteById(Integer id) throws CoreException {
		try{
			return basicDao.deleteByProperty(ENTITY, ID, id);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

}