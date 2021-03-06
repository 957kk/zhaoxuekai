package com.zhaoxk_job.service;

import java.util.List;

import com.zhaoxk_job.entity.Student;



public interface StudentService {
	public boolean save(Student student); // 添加客户
	public List<Student> findByName(String name);// 按客户名查找客户
	public Student findByXuehao(String xuehao);// 按客户名查找客户
	public void delete(int id);// 删除客户
	public void update(Student student); // 更新客户
	public Student findById(int id);// 按id查找客户
	public List<Student> findAll();// 查找全部客户
}
