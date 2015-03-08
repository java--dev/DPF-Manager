package com.rency.dpf.dao;

import java.util.List;

import org.rency.utils.exceptions.CoreException;

import com.rency.dpf.beans.UserType;

public interface UserTypeDao {

	public List<UserType> list() throws CoreException;
	
	public UserType getById(Integer id) throws CoreException;
	
	public boolean save(UserType userType) throws CoreException;
	
	public boolean update(UserType userType) throws CoreException;
	
	public boolean delete(UserType userType) throws CoreException;
	
	public boolean deleteById(Integer id) throws CoreException;
	
}