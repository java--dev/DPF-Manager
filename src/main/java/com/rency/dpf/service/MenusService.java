package com.rency.dpf.service;

import java.util.List;

import org.rency.utils.exceptions.CoreException;

import com.rency.dpf.beans.Menus;
import com.rency.dpf.beans.UserType;

public interface MenusService {

	public List<Menus> queryMenus(UserType userType) throws CoreException;
	
	public List<Menus> list() throws CoreException;
	
	public Menus queryByResId(String resId) throws CoreException;
	
	public List<Menus> queryByResName(String resName) throws CoreException;
	
	public boolean add(Menus menus) throws CoreException;
	
	public boolean update(Menus menus) throws CoreException;
	
	public boolean delete(Menus menus) throws CoreException;
	
	public boolean deleteById(String resId) throws CoreException;
	
}