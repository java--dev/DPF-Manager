package com.rency.dpf.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.rency.utils.dao.BasicDao;
import org.rency.utils.exceptions.CoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.rency.dpf.beans.User;
import com.rency.dpf.beans.UserType;
import com.rency.dpf.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	@Qualifier("hibernateDao")
	private BasicDao basicDao;
	
	private final String ENTITY = User.class.getName();	
	private final String GUID = "guid";	
	private final String LASTLOGIN = "lastLogin";	
	private final String LOGINIP = "loginIP";	
	private final String PASSWORD = "password";	
	private final String ONLINE = "online";
	
	@Override
	public User login(User user) throws CoreException {
		String queryString = "from " + ENTITY + " as model where model.username=? and model.password=?";
		try{
			List<User> list = basicDao.findByHQL(queryString, new Object[]{user.getUsername(),user.getPassword()});
			if(list != null && list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<User> load() throws CoreException {
		try{
			return basicDao.loadAll(User.class);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public User getByName(String userName) throws CoreException {
		String queryString = "from " + ENTITY + " as model where model.username=?";
		try{
			List<User> list = basicDao.findByHQL(queryString, userName);
			if(list != null && list.size() > 0){
				return list.get(0);
			}else{
				return null;
			}
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public List<User> getByType(UserType userType) throws CoreException {
		String queryString = "from " + ENTITY + " as model where model.userType=?  order by model.createTime";
		try{
			return basicDao.findByHQL(queryString, userType);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean save(User user) throws CoreException {
		try{
			return basicDao.save(user);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	@Deprecated
	public boolean update(User user) throws CoreException {
		try{
			return basicDao.update(user);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public boolean updateLoginInfo(String guid,Date lastLogin, String loginIP,boolean online)throws CoreException {
		try{
			HashMap<String, Object> where = new HashMap<String,Object>();
			where.put(GUID, guid);
			HashMap<String, Object> set = new HashMap<String,Object>();
			if(lastLogin != null){
				set.put(LASTLOGIN, lastLogin);
			}
			if(StringUtils.isNotBlank(loginIP)){
				set.put(LOGINIP, loginIP);
			}
			set.put(ONLINE, online);
			return basicDao.updateByProperty(ENTITY, where, set);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	public boolean updatePassword(String guid,String password) throws CoreException{
		try{
			return basicDao.updateByProperty(ENTITY, GUID, guid, PASSWORD, password);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public boolean delete(User user) throws CoreException {
		try{
			return basicDao.delete(user);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean deleteByGuid(String guid) throws CoreException {
		try{
			return basicDao.deleteByProperty(ENTITY, GUID, guid);
		}catch(CoreException e){
			logger.error(e.toString());
			e.printStackTrace();
			throw e;
		}
	}

}
