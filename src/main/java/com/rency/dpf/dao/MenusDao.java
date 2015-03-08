package com.rency.dpf.dao;

import java.util.List;

import org.rency.utils.exceptions.CoreException;

import com.rency.dpf.beans.Menus;
import com.rency.dpf.beans.UserType;

public interface MenusDao {

	public List<Menus> getMenus(UserType userType) throws CoreException;
	
	public List<Menus> loadAll() throws CoreException;
	
	public Menus getByResId(String resId) throws CoreException;
	
	public List<Menus> getByResName(String resName) throws CoreException;
	
	public boolean save(Menus menus) throws CoreException;
	
	public boolean update(Menus menus) throws CoreException;
	
	public boolean delete(Menus menus) throws CoreException;
	
	public boolean deleteById(String resId) throws CoreException;
	
}