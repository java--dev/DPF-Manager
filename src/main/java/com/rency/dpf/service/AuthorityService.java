package com.rency.dpf.service;

import java.util.List;

import org.rency.utils.exceptions.CoreException;

import com.rency.dpf.beans.Authority;

public interface AuthorityService {

	public boolean findAuth(Authority authority) throws CoreException;
	
	public List<Authority> list() throws CoreException;
	
	public List<Authority> queryByAddr(String resources) throws CoreException;
	
	public boolean add(Authority authority) throws CoreException;
	
	public boolean update(Authority authority) throws CoreException;
	
	public boolean delete(Authority authority) throws CoreException;
	
	public boolean deleteById(Integer id) throws CoreException;
	
}