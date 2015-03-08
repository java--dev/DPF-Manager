package com.rency.dpf.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.rency.crawler.core.CrawlerConfiguration;
import org.rency.crawler.service.CrawlerService;
import org.rency.crawler.service.TaskQueueService;
import org.rency.utils.exceptions.CoreException;
import org.rency.utils.tools.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rency.dpf.beans.CrawlerConfig;
import com.rency.dpf.dao.CrawlerConfigDao;
import com.rency.dpf.service.CrawlerConfigService;

@Service("crawlerConfigService")
public class CrawlerConfigServiceImpl implements CrawlerConfigService {

	private static final Logger logger = LoggerFactory.getLogger(CrawlerConfigServiceImpl.class);
	
	@Autowired
	private CrawlerConfigDao crawlerConfigDao;
	
	@Autowired
	private CrawlerService crawlerService;
	
	@Autowired
	private TaskQueueService taskQueueService;
	
	@Override
 	public List<CrawlerConfig> loadAll() throws CoreException {
		return crawlerConfigDao.loadAll();
	}

	@Override
	public CrawlerConfig load(String crawlerId) throws CoreException {
		return crawlerConfigDao.load(crawlerId);
	}

	@Override
	public List<CrawlerConfig> queryByName(String crawlerName)throws CoreException {
		return crawlerConfigDao.getByName(crawlerName);
	}

	@Override
	public List<CrawlerConfig> queryByParam(CrawlerConfig crawlerConfig)throws CoreException {
		return crawlerConfigDao.getByParam(crawlerConfig);
	}

	@Override
	public boolean add(CrawlerConfig crawlerConfig) throws CoreException {
		if(StringUtils.isBlank(crawlerConfig.getCrawlerId())){
			crawlerConfig.setCrawlerId(Utils.generateString(32));
		}
		return crawlerConfigDao.save(crawlerConfig);
	}

	@Override
	public boolean update(CrawlerConfig crawlerConfig) throws CoreException {
		return crawlerConfigDao.update(crawlerConfig);
	}

	@Override
	public boolean updateStatus(CrawlerConfig crawlerConfig) throws CoreException {
		return crawlerConfigDao.updateStatus(crawlerConfig);
	}

	@Override
	public boolean updateAddr(CrawlerConfig crawlerConfig) throws CoreException {
		return crawlerConfigDao.updateAddr(crawlerConfig);
	}
	
	@Override
	public boolean delete(CrawlerConfig crawlerConfig) throws CoreException {
		return crawlerConfigDao.delete(crawlerConfig);
	}
	
	@Override
	public boolean deleteById(String crawlerId) throws CoreException {
		return crawlerConfigDao.deleteById(crawlerId);
	}

	@Override
	public synchronized boolean start(String crawlerId,String user) throws Exception {
		try{
			CrawlerConfig crawlerConfig = load(crawlerId);
			if(crawlerConfig == null){
				logger.error("crawlerConfig["+crawlerId+"] not exists, and can not be start.");				
				throw new RuntimeException("选择启动的爬虫不存在");
			}
			if(StringUtils.isBlank(crawlerConfig.getInitAddr())){
				logger.error("crawlerConfig["+crawlerId+"] initAddr can not be null.");				
				throw new RuntimeException("爬虫起始地址不能为空");
			}
			if(crawlerConfig.isStatus()){
				logger.error("crawlerConfig["+crawlerId+"] is running, and can not be start.");				
				throw new RuntimeException("爬虫正在运行...");
			}
			/**
			 * 初始化爬虫配置
			 */
			CrawlerConfiguration config = new CrawlerConfiguration(crawlerId, crawlerConfig.getPoolSize(), crawlerConfig.getInitAddr(),user);
			//运行爬虫
			crawlerService.start(config);
			crawlerConfig.setStatus(true);
			updateStatus(crawlerConfig);
			return true;
		}catch(Exception e){
			logger.error("start crawler error.",e);
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public boolean queryCrawlerExecutorsStatus(String crawlerId) throws CoreException{
		try{
			return crawlerService.status(crawlerId);
		}catch(Exception e){
			logger.error("query crawler status error."+e);
			e.printStackTrace();
			throw new CoreException("query crawler status error."+e);
		}
	}

	@Override
	public synchronized boolean stop(String crawlerId) throws Exception {
		try{
			CrawlerConfig crawlerConfig = load(crawlerId);
			if(crawlerConfig == null){
				logger.error("crawlerConfig["+crawlerId+"] not exists, and can not be stop.");				
				throw new RuntimeException("选择停止的爬虫不存在");
			}
			if(!crawlerConfig.isStatus()){
				logger.error("crawlerConfig["+crawlerId+"] not exists, and can not be stop");				
				throw new RuntimeException("爬虫未运行...");
			}
			//停止爬虫
			crawlerService.stop(crawlerId);
			crawlerConfig.setStatus(false);
			updateStatus(crawlerConfig);
			return true;
		}catch(Exception e){
			logger.error("stop crawler error."+e);
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public boolean deleteTaskQueueByCrawlerId(String crawlerId) throws Exception {
		try{
			return taskQueueService.deleteTaskQueueByCrawlerId(crawlerId);
		}catch(Exception e){
			logger.error("delete crawler task queue error."+e);
			e.printStackTrace();
			throw e;
		}
	}

}
