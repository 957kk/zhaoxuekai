package com.zhaoxk_job.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.SessionAttributes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhaoxk_job.entity.Notice;
import com.zhaoxk_job.service.NoticeService;



@SuppressWarnings("rawtypes")
@SessionAttributes
public class NoticeAction extends ActionSupport implements ModelDriven {

	private static final long serialVersionUID = 1L;
	NoticeService noticeService;  
	private Notice notice;//数据模型
	private String msg;
	
	
	//**************************************************************************************** 
    public String query()  { 		
		 
		 List<Notice> notice_list=new ArrayList<Notice>();		 
		 notice_list=noticeService.findAll();
		 if(notice_list.size()>0) {
			 ActionContext.getContext().getSession().put("notice_list",notice_list);
			 msg="新闻学生信息查询成功�?"; 			
	  	     
		 }
		 else {
			 msg="新闻学生信息查询失败！数据库没有新闻�?"; 			
	  			
		 }
		 return "notice_gl";
      }
  //**************************************************************************************** 
    public String add()  { 		
		 
    	 boolean flag=false;
  		System.out.println("新闻标题�?" + notice.getTitle() + ",新闻内容�?" + notice.getNoticeContent());
  		//Date today=new Date();
  		Calendar today=Calendar.getInstance();
  		String today_fomat=today.get(Calendar.YEAR)+"-"+(today.get(Calendar.MONTH)+1)+"-"+today.get(Calendar.DAY_OF_MONTH)+"  "+
  				today.get(Calendar.HOUR_OF_DAY)+":"+today.get(Calendar.MINUTE)+":"+today.get(Calendar.SECOND);
  		notice.setSubmitTime(today_fomat);
  		Notice notice2=noticeService.findByTitle(notice.getTitle());
  		if(notice2==null) {
  			flag = noticeService.save(notice);
  			if(flag) {
  			msg="添加成功�?"; 			
  			}
  			else
  			{
  				msg="添加失败�?"; 				
  			}
  		}
  		else {
  			msg="新闻已存在，添加失败�?";  			 			
  		}
  		System.out.println("msg: "+msg);  		
  		query();
 		return "notice_gl";
 }
    //****************************************************************************************
    public String personQuery()  { 		
		System.out.println("新闻编号�?" + notice.getNoticeID());
		Notice notice2=noticeService.findById(notice.getNoticeID());		
				
			List<String> notice_info=new ArrayList<String>();
			notice_info.add(Integer.toString(notice2.getNoticeID()));
			notice_info.add(notice2.getNumber());
			notice_info.add(notice2.getUsername());
			notice_info.add(notice2.getTitle());
			notice_info.add(notice2.getNoticeContent());
			notice_info.add(notice2.getSubmitTime());			
			System.out.println("notice_info�?" + notice_info.get(0)+"," +notice_info.get(1)+ "," + notice_info.get(2)+"," +notice_info.get(3)+ "," + notice_info.get(4));
			ActionContext.getContext().getSession().put("notice_info",notice_info);
			ActionContext.getContext().getSession().put("noticeID",notice_info.get(0));
			msg="单个新闻信息查询成功！请修改下边新闻信息�?"; 			
			return "modifyNotice";	
		
}	  
  //****************************************************************************************
    public String updatePerson()  { 	
			System.out.println("updatePerson-ID�?" + notice.getNoticeID() + ",updatePerson-title�?" + notice.getTitle());
			if(notice!=null) {
				Calendar today=Calendar.getInstance();
		  		String today_fomat=today.get(Calendar.YEAR)+"-"+(today.get(Calendar.MONTH)+1)+"-"+today.get(Calendar.DAY_OF_MONTH)+"  "+
		  				today.get(Calendar.HOUR_OF_DAY)+":"+today.get(Calendar.MINUTE)+":"+today.get(Calendar.SECOND);
		  		notice.setSubmitTime(today_fomat);
				noticeService.update(notice); 
			    msg="通知信息修改成功�?";			    			   
			}
			query();
			return "notice_gl";
			
 }	    
  //****************************************************************************************
    public String delete()  { 		
   	        System.out.println("新闻编号�?" + notice.getNoticeID());		
			Notice notice2=noticeService.findById(notice.getNoticeID());
			if(notice2!=null) {			
			noticeService.delete(notice2.getNoticeID());			
			msg="新闻信息删除成功�?"; 			
			}
			query();
		return "notice_gl";
		
}	      
    
    
    
    
    

    public NoticeService getNoticeService() {
		return noticeService;
	}


	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}


	public Notice getNotice() {
		return notice;
	}


	public void setNotice(Notice notice) {
		this.notice = notice;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	@Override
	public Object getModel() {		 
			  notice= new Notice();
		return notice;
	}


}
