package com.rency.dpf.dao;

import java.util.List;
import org.rency.utils.exceptions.CoreException;
import com.rency.dpf.beans.Loggers;

public interface LoggerDao {

	public List<Loggers> list() throws CoreException;
	
	public List<Loggers> getByParams(Loggers syslog) throws CoreException;
	
	public boolean save(Loggers syslog) throws CoreException;
	
	public boolean delete(Loggers syslog) throws CoreException;
	
	public boolean deleteById(Integer id) throws CoreException;
	
}