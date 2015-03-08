package com.rency.dpf.dao;

import java.util.List;

import org.rency.utils.exceptions.CoreException;

import com.rency.dpf.beans.Authority;

public interface AuthorityDao {

	public boolean findAuth(Authority authority) throws CoreException;
	
	public List<Authority> list() throws CoreException;
	
	public List<Authority> getByAddr(String resources) throws CoreException;
	
	public boolean save(Authority authority) throws CoreException;
	
	public boolean update(Authority authority) throws CoreException;
	
	public boolean delete(Authority authority) throws CoreException;
	
	public boolean deleteById(Integer id) throws CoreException;
	
}