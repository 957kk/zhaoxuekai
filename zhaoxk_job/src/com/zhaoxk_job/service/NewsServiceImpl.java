package com.zhaoxk_job.service;

import java.util.List;

import com.zhaoxk_job.bean.PageBean;
import com.zhaoxk_job.dao.NewsDAO;
import com.zhaoxk_job.entity.News;

public class NewsServiceImpl implements NewsService {

	private NewsDAO newsDAO;

	public NewsDAO getNewsDAO() {
		return newsDAO;
	}

	// 提供NewsDAO的注入通道
	public void setNewsDAO(NewsDAO newsDAO) {
		this.newsDAO = newsDAO;
	}

	@Override
	public boolean save(News news) {
		boolean flag=false;
		if(newsDAO.findById(news.getNewsID())==null) {
			newsDAO.save(news);//调用DAO对象保存
			flag=true;
			System.out.println("NewsServiceImpl: news为空！");
	       }
		else {
			System.out.println("NewsServiceImpl: news不为空！news.getNewsID()="+news.getNewsID());
		}
		return flag;
	}
	@Override
	public void update(News news) {
//		if(newsDAO.findById(news.getCid())!=null)
			newsDAO.update(news);		//调用DAO组件更新
	}

	@Override
	public List<News> findAll() {
		return newsDAO.findAll();//调用DAO组件查询
	}
	
	@Override
	public News findByTitle(String title) {
		return newsDAO.findByTitle(title); //调用DAO组件查询
	}

	@Override
	public void delete(int id) {
		if(newsDAO.findById(id)!=null)
			newsDAO.delete(id);			//调用DAO组件删除
		
	}
	

	@Override
	public News findById(int id) {
		return newsDAO.findById(id);//调用DAO组件查询
	}

	@Override
	public PageBean<News> findByPage(int page) {
		PageBean<News> pageBean =new PageBean<News>();
        pageBean.setPage(page);
        int limit=10;
        pageBean.setLimit(limit);
        int totalCount=newsDAO.findTotalCount();
        pageBean.setTotalCount(totalCount);
        int totalpage=(int)Math.ceil(totalCount/limit)+1;
        pageBean.setTotalPage(totalpage);
        //每页显示的数据集合
        int begin=(page-1)*limit;
        List<News> list=newsDAO.findByPageId(begin,limit);
        pageBean.setList(list);
        return pageBean;
	}

	

}
