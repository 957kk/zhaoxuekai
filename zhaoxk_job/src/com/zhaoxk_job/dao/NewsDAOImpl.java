package com.zhaoxk_job.dao;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.zhaoxk_job.bean.PageBean;
import com.zhaoxk_job.bean.PageHibernateCallback;
import com.zhaoxk_job.entity.News;


public class NewsDAOImpl implements NewsDAO {
	private SessionFactory sessionFactory;
	private HibernateTemplate ht;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	// 为注入sessionFactory Bean准备的setter方法
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateTemplate getHt() {
		if (ht == null)
			ht = new HibernateTemplate(sessionFactory);
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	// 添加客户
	@Override
	public void save(News news) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().save(news);
		getHt().flush();
	}

	// 删除客户
	public void delete(int id) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().delete(findById(id));
		getHt().flush();
	}

	// 更新客户
	public void update(News news) {
		ht.getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHt().merge(news);
		getHt().flush();
	}

	// 按id查找客户
	public News findById(int id) {
		News news = (News) getHt().get(News.class, new Integer(id));
		return news;
	}

	// 查找全部客户
	@Override
	@SuppressWarnings("unchecked")
	public List<News> findAll() {
		String queryString = "from News order by submitTime desc";
		List<News> list = (List<News>) getHt().find(queryString);
		return list;
	}

	

	@Override
	public News findByTitle(String title) {
		News news=null;
		String hsql = "from News where title='" + title + "'";
		@SuppressWarnings("unchecked")
		List<News> result = (List<News>) getHt().find(hsql);
		if(result.size()>0) {
			news=result.get(0);
		}
		return news;
	}
	
	 
	     //查询news表中总记录数
	    public int findTotalCount() {
	        String hql="select count(*) from News";
	        @SuppressWarnings("unchecked")
			List<Long> list=(List<Long>) getHt().find(hql);
	        if(list!=null&&list.size()>0){
	            return list.get(0).intValue();
	        }
	        return 0;
	    }

	    //查询当前页面的商品集合
	    public List<News> findByPageId(int begin, int limit) {
	        String hql="from News order by submitTime desc";
	        @SuppressWarnings({ "unchecked", "rawtypes" })
			List<News> list=(List<News>) getHt().execute( new PageHibernateCallback(hql, new Object[]{}, begin, limit));
	        if(list!=null&&list.size()>0){
	            
	            return list;
	        }
	        return null;
	    }

	

		

	
	
	
	
	
}
