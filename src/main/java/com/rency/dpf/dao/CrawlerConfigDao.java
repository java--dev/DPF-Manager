package com.rency.dpf.dao;

import java.util.List;

import org.rency.utils.exceptions.CoreException;

import com.rency.dpf.beans.CrawlerConfig;

public interface CrawlerConfigDao {

	public List<CrawlerConfig> loadAll() throws CoreException;
	
	public CrawlerConfig load(String crawlerId) throws CoreException;
	
	public List<CrawlerConfig> getByName(String crawlerName) throws CoreException;
	
	public List<CrawlerConfig> getByParam(CrawlerConfig crawlerConfig) throws CoreException;
	
	public boolean save(CrawlerConfig crawlerConfig) throws CoreException;
	
	public boolean update(CrawlerConfig crawlerConfig) throws CoreException;
	
	public boolean delete(CrawlerConfig crawlerConfig) throws CoreException;
	
	public boolean deleteById(String crawlerId) throws CoreException;
	
	public boolean updateStatus(CrawlerConfig crawlerConfig) throws CoreException;
	
	public boolean updateAddr(CrawlerConfig crawlerConfig) throws CoreException;
	
}