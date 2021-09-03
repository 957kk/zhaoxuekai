package com.zhaoxk_job.dao;

import java.util.List;

import com.zhaoxk_job.entity.News;

public interface NewsDAO {
	
	public void save(News news); // 添加客户	
	public void delete(int id);// 删除客户
	public void update(News news); // 更新客户
	public News findById(int id);// 按id查找客户
	public List<News> findAll();// 查找全部客户
	public News findByTitle(String title);
	public int findTotalCount();
	public List<News> findByPageId(int begin, int limit);
	
}
