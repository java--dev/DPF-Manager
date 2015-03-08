package com.rency.dpf.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.rency.utils.dao.BasicDao;
import org.rency.utils.exceptions.CoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.rency.dpf.beans.Loggers;
import com.rency.dpf.dao.LoggerDao;

@Repository("loggerDao")
public class LoggerDaoImpl implements LoggerDao {

	private static final Logger logger = LoggerFactory.getLogger(LoggerDaoImpl.class);
	
	@Autowired
	@Qualifier("hibernateDao")
	private BasicDao basicDao;
	
	private final String ENTITY = Loggers.class.getName();
	private final String ID = "id";
	
	@Override
	public List<Loggers> list() throws CoreException {
		try{
			return basicDao.loadAll(Loggers.class);
		}catch(CoreException e){
			logger.error("load all error.",e);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Loggers> getByParams(Loggers syslog) throws CoreException {
		StringBuilder queryString = new StringBuilder();
		queryString.append("from "+ENTITY+" as model where ");
		try{
			if(StringUtils.isBlank(syslog.getAction())){
				queryString.append("model.action='"+syslog.getAction()+"' and ");
			}
			if(StringUtils.isBlank(syslog.getBrowser())){
				queryString.append("model.browser='"+syslog.getBrowser()+"' and ");
			}
			if(StringUtils.isBlank(syslog.getClientIP())){
				queryString.append("model.clientIP='"+syslog.getClientIP()+"' and ");
			}
			if(StringUtils.isBlank(syslog.getParam())){
				queryString.append("model.param='"+syslog.getParam()+"' and ");
			}
			if(StringUtils.isBlank(syslog.getUseTime())){
				queryString.append("model.useTime='"+syslog.getUseTime()+"' and ");
			}
			if(syslog.getLogType() > 0){
				queryString.append("model.logType="+syslog.getLogType()+" and ");
			}
			if(syslog.getId()>0){
				queryString.append("model.id="+syslog.getId()+" and ");
			}
			if(syslog.getUser() != null){
				queryString.append("model.user='"+syslog.getUser()+"' and ");
			}
			queryString.append("1=1");
			return basicDao.findByHQL(queryString.toString());
		}catch(CoreException e){
			logger.error("exec getByParam["+queryString.toString()+"] error",e);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean save(Loggers syslog) throws CoreException {
		try{
			return basicDao.save(syslog);
		}catch(CoreException e){
			logger.error("save error.",e);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean delete(Loggers syslog) throws CoreException {
		try{
			return basicDao.delete(syslog);
		}catch(CoreException e){
			logger.error("delete error.",e);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean deleteById(Integer id) throws CoreException {
		try{
			return basicDao.deleteByProperty(ENTITY, ID, id);
		}catch(CoreException e){
			logger.error("deleteById error.",e);
			e.printStackTrace();
			throw e;
		}
	}

}
