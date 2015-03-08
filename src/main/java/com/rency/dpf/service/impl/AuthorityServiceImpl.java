package com.rency.dpf.service.impl;

import java.util.List;

import org.rency.utils.exceptions.CoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rency.dpf.beans.Authority;
import com.rency.dpf.dao.AuthorityDao;
import com.rency.dpf.service.AuthorityService;

@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	@Qualifier("authorityDao")
	private AuthorityDao authorityDao;
	
	public boolean findAuth(Authority authority) throws CoreException {
		return authorityDao.findAuth(authority);
	}

	@Override
	public List<Authority> list() throws CoreException {
		return authorityDao.list();
	}
	
	@Override
	public List<Authority> queryByAddr(String resources) throws CoreException{
		return authorityDao.getByAddr(resources);
	}
	
	@Override
	public boolean add(Authority authority) throws CoreException {
		return authorityDao.save(authority);
	}
	
	@Override
	public boolean update(Authority authority) throws CoreException {
		return authorityDao.update(authority);
	}

	@Override
	public boolean delete(Authority authority) throws CoreException {
		return authorityDao.delete(authority);
	}
	
	@Override
	public boolean deleteById(Integer id) throws CoreException {
		return authorityDao.deleteById(id);
	}

}