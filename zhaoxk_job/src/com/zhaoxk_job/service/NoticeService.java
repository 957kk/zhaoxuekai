package com.zhaoxk_job.service;

import java.util.List;

import com.zhaoxk_job.bean.PageBean;
import com.zhaoxk_job.entity.Notice;



public interface NoticeService {
	public boolean save(Notice notice); // 添加客户	
	public void delete(int id);// 删除客户
	public void update(Notice notice); // 更新客户
	public Notice findById(int id);// 按id查找客户
	public List<Notice> findAll();// 查找全部客户
	public Notice findByTitle(String title);
	public PageBean<Notice> findByPage(int page);
	
}
