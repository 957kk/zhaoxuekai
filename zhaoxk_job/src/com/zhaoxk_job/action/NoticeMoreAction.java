package com.zhaoxk_job.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhaoxk_job.bean.PageBean;
import com.zhaoxk_job.entity.Notice;
import com.zhaoxk_job.service.NoticeService;

public class NoticeMoreAction extends ActionSupport implements ModelDriven<Notice>,ServletRequestAware{
	 
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService;
	    private Notice notice=new Notice();
	    HttpServletRequest request;
	    private String flag;
	    
		private int page;
		private int totalPage;
	    /**
	     * 展示�?有商�?
	     * @return
	     */
	   
	    
	    @Override
		public String execute() throws Exception {
	    	if(flag!=null) {
	    	System.out.println("pagebeanAction-000:"+page+","+flag);
	    	if(flag.equals("add")) {
	    		page=page+1;
	    		System.out.println("pagebeanAction-add:"+page+","+flag);
	    		}
	    	else if(flag.equals("sub")){
	    		page=page-1;
	    		System.out.println("pagebeanAction-sub:"+page+","+flag);
	    	}
//	    	else if(flag.equals("exit"))
//	    		     return "noticeMore";	
	    	}
	    	if(page<=0)
	    		page=1;
	    	else {
	    		if(page>totalPage) {
	    			page=totalPage;
	    			System.out.println("pagebeanAction-flag:"+page+","+flag);
	    			}
	    	}
	    	System.out.println("pagebeanAction-page:"+page);
	        PageBean<Notice> pagebean=noticeService.findByPage(page);
	        totalPage=pagebean.getTotalPage();
	        ActionContext.getContext().getValueStack().set("pageBean", pagebean);
	        return "noticeMore";
		}

		public void setNoticeService(NoticeService noticeService) {
	        this.noticeService = noticeService;
	    }


	    @Override
	    public Notice getModel() {
	        return notice;
	    }

	    @Override
	    public void setServletRequest(HttpServletRequest request) {
	        this.request=request;
	    }
	    public void setPage(int page) {
	        this.page = page;
	    }
	    public int getPage() {
	        return page;
	    }
	    public String getFlag() {
			return flag;
		}

		public void setFlag(String flag) {
			this.flag = flag;
		}

	
}
