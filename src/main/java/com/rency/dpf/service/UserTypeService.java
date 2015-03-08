package com.rency.dpf.service;

import java.util.List;

import org.rency.utils.exceptions.CoreException;

import com.rency.dpf.beans.UserType;

public interface UserTypeService {

	public List<UserType> list() throws CoreException;
	
	public List<UserType> listWithoutSuper() throws CoreException;
	
	public boolean add(UserType userType) throws CoreException;
	
	public boolean update(UserType userType) throws CoreException;
	
	public boolean deleteById(int typeId) throws CoreException;
	
	public UserType queryById(Integer id) throws CoreException;
	
}