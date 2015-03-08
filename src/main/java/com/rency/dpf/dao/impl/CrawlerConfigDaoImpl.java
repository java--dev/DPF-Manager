package com.rency.dpf.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.rency.utils.dao.BasicDao;
import org.rency.utils.exceptions.CoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.rency.dpf.beans.CrawlerConfig;
import com.rency.dpf.dao.CrawlerConfigDao;

@Repository("crawlerConfigDao")
public class CrawlerConfigDaoImpl implements CrawlerConfigDao {

	private static final Logger logger = LoggerFactory.getLogger(CrawlerConfigDaoImpl.class);
	
	@Autowired
	@Qualifier("hibernateDao")
	private BasicDao basicDao;
	
	private final String ENTITY = CrawlerConfig.class.getName();
	
	@Override
	public CrawlerConfig load(String crawlerId) throws CoreException {
		try{
			return basicDao.get(CrawlerConfig.class, crawlerId);
		}catch(CoreException e){
			logger.error("exec load crawler config["+crawlerId+"] error."+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public List<CrawlerConfig> loadAll() throws CoreException {
		try{
			return basicDao.loadAll(CrawlerConfig.class);
		}catch(CoreException e){
			logger.error("exec load all crawler config error."+e);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<CrawlerConfig> getByName(String crawlerName) throws CoreException {
		String queryString = "from "+ENTITY+" as model where model.crawlerName=? order by model.crawlerId";
		try{
			return basicDao.findByHQL(queryString, crawlerName);
		}catch(CoreException e){
			logger.error("exec queryString["+queryString+","+crawlerName+"] error."+e);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<CrawlerConfig> getByParam(CrawlerConfig crawlerConfig) throws CoreException {
		StringBuilder queryString = new StringBuilder();
		try{
			queryString.append("from "+ENTITY+" as model where ");
			if(StringUtils.isNotBlank(crawlerConfig.getCrawlerId())){
				queryString.append("model.crawlerId='"+crawlerConfig.getCrawlerId()+"' and ");
			}
			if(StringUtils.isNotBlank(crawlerConfig.getCrawlerName())){
				queryString.append("model.crawlerName='"+crawlerConfig.getCrawlerName()+"' and ");
			}
			if(StringUtils.isNotBlank(crawlerConfig.getCrawlerDesc())){
				queryString.append("model.crawlerDesc='"+crawlerConfig.getCrawlerDesc()+"' and ");
			}
			if(StringUtils.isNotBlank(crawlerConfig.getRemoteAddr())){
				queryString.append("model.remoteAddr='"+crawlerConfig.getRemoteAddr()+"' and ");
			}
			if(StringUtils.isNotBlank(crawlerConfig.getRemotePort())){
				queryString.append("model.remotePort='"+crawlerConfig.getRemotePort()+"' and ");
			}
			if(crawlerConfig.getPoolSize() > 0){
				queryString.append("model.poolSize="+crawlerConfig.getPoolSize()+" and ");
			}
			if(crawlerConfig.isStatus() == true){
				queryString.append("model.status="+crawlerConfig.isStatus()+" and ");
			}
			queryString.append("1=1  order by model.crawlerId");
			return basicDao.findByHQL(queryString.toString());
		}catch(CoreException e){
			logger.error("exec queryString["+queryString+"] error."+e);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean save(CrawlerConfig crawlerConfig) throws CoreException {
		try{
			return basicDao.save(crawlerConfig);
		}catch(CoreException e){
			logger.error("exec save crawler config error."+e);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean update(CrawlerConfig crawlerConfig) throws CoreException {
		try{
			return basicDao.update(crawlerConfig);
		}catch(CoreException e){
			logger.error("exec update crawler config error."+e);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean delete(CrawlerConfig crawlerConfig) throws CoreException {
		try{
			return basicDao.delete(crawlerConfig);
		}catch(CoreException e){
			logger.error("exec delete crawler config error."+e);
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public boolean deleteById(String crawlerId) throws CoreException {
		try{
			return basicDao.deleteByProperty(ENTITY, "crawlerId", crawlerId);
		}catch(CoreException e){
			logger.error("exec delete crawler config by id["+crawlerId+"] error."+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public boolean updateStatus(CrawlerConfig crawlerConfig) throws CoreException {
		try{
			return basicDao.updateByProperty(ENTITY, "crawlerId", crawlerConfig.getCrawlerId(), "status", crawlerConfig.isStatus());
		}catch(CoreException e){
			logger.error("exec update status["+crawlerConfig.toString()+"] error."+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public boolean updateAddr(CrawlerConfig crawlerConfig) throws CoreException {
		try{
			return basicDao.updateByProperty(ENTITY, "crawlerId", crawlerConfig.getCrawlerId(), "initAddr", crawlerConfig.getInitAddr());
		}catch(CoreException e){
			logger.error("exec update status["+crawlerConfig.toString()+"] error."+e);
			e.printStackTrace();
			throw e;
		}
	}

}
