package com.rency.dpf.service.impl;

import java.util.List;

import org.rency.utils.exceptions.CoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.rency.dpf.beans.Loggers;
import com.rency.dpf.beans.User;
import com.rency.dpf.dao.LoggerDao;
import com.rency.dpf.service.LoggerService;

@Service("loggerService")
public class LoggerServiceImpl implements LoggerService{

	@Autowired
	@Qualifier("loggerDao")
	private LoggerDao loggerDao;
	
	@Override
	public List<Loggers> list() throws CoreException {
		return loggerDao.list();
	}

	@Override
	public List<Loggers> queryByAction(String action) throws CoreException {
		Loggers loggers = new Loggers();
		loggers.setAction(action);
		return loggerDao.getByParams(loggers);
	}

	@Override
	public List<Loggers> queryByClient(String client) throws CoreException {
		Loggers loggers = new Loggers();
		loggers.setClientIP(client);
		return loggerDao.getByParams(loggers);
	}

	@Override
	public List<Loggers> queryByLogType(int logType) throws CoreException{
		Loggers loggers = new Loggers();
		loggers.setLogType(logType);
		return loggerDao.getByParams(loggers);
	}
	
	@Override
	public List<Loggers> queryByUser(User user) throws CoreException {
		Loggers loggers = new Loggers();
		loggers.setUser(user);
		return loggerDao.getByParams(loggers);
	}

	@Override
	public List<Loggers> queryByParams(Loggers loggers) throws CoreException {
		return loggerDao.getByParams(loggers);
	}

	@Override
	public boolean add(Loggers loggers) throws CoreException {
		return loggerDao.save(loggers);
	}

}
