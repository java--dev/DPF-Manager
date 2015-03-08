package com.rency.dpf.service;

import java.util.List;

import org.rency.utils.exceptions.CoreException;

import com.rency.dpf.beans.Loggers;
import com.rency.dpf.beans.User;

public interface LoggerService {

	public List<Loggers> list() throws CoreException;
	
	public List<Loggers> queryByAction(String action) throws CoreException;
	
	public List<Loggers> queryByClient(String client) throws CoreException;

	public List<Loggers> queryByLogType(int logType) throws CoreException;
	
	public List<Loggers> queryByUser(User user) throws CoreException;
	
	public List<Loggers> queryByParams(Loggers syslog) throws CoreException;
	
	public boolean add(Loggers syslog) throws CoreException;
	
}