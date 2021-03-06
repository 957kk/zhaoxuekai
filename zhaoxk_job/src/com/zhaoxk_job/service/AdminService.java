package com.zhaoxk_job.service;

import java.util.List;

import com.zhaoxk_job.entity.Admin;



public interface AdminService {
	public boolean save(Admin admin); // 添加客户
	public List<Admin> findByName(String name);// 按客户名查找客户
	public Admin findByXuehao(String xuehao);// 按客户名查找客户
	public void delete(int id);// 删除客户
	public void update(Admin admin); // 更新客户
	public Admin findById(int id);// 按id查找客户
	public List<Admin> findAll();// 查找全部客户
}
