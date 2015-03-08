package com.rency.dpf.service;

import java.util.List;

import org.rency.utils.exceptions.CoreException;

import com.rency.dpf.beans.CrawlerConfig;

public interface CrawlerConfigService {

	public List<CrawlerConfig> loadAll() throws CoreException;
	
	public CrawlerConfig load(String crawlerId) throws CoreException;
	
	public List<CrawlerConfig> queryByName(String crawlerName) throws CoreException;
	
	public List<CrawlerConfig> queryByParam(CrawlerConfig crawlerConfig) throws CoreException;
	
	public boolean add(CrawlerConfig crawlerConfig) throws CoreException;
	
	public boolean update(CrawlerConfig crawlerConfig) throws CoreException;
	
	public boolean updateStatus(CrawlerConfig crawlerConfig) throws CoreException;
	
	public boolean updateAddr(CrawlerConfig crawlerConfig) throws CoreException;
	
	public boolean delete(CrawlerConfig crawlerConfig) throws CoreException;
	
	public boolean deleteById(String crawlerId) throws CoreException;
	
	/**
	 * @desc 启动爬虫
	 * @date 2014年11月21日 下午3:05:02
	 * @param crawlerId 爬虫ID
	 * @param crawlerId 用户标识
	 * @return
	 * @throws Exception
	 */
	public boolean start(String crawlerId,String user) throws Exception;
	
	/**
	 * @desc 查询爬虫运行状态
	 * @date 2014年11月21日 下午3:05:28
	 * @param crawlerId 爬虫ID
	 * @return
	 * @throws CoreException
	 */
	public boolean queryCrawlerExecutorsStatus(String crawlerId) throws CoreException;
	
	/**
	 * @desc 停止爬虫
	 * @date 2014年11月21日 下午3:05:40
	 * @param crawlerId
	 * @return
	 * @throws Exception
	 */
	public boolean stop(String crawlerId) throws Exception;
	
	/**
	 * @desc 删除爬虫任务队列
	 * @date 2014年11月24日 下午3:29:33
	 * @param crawlerId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteTaskQueueByCrawlerId(String crawlerId) throws Exception;
}