package com.zhaoxk_job.action;


import java.util.List;

import org.springframework.web.bind.annotation.SessionAttributes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zhaoxk_job.entity.News;
import com.zhaoxk_job.entity.Notice;
import com.zhaoxk_job.service.NewsService;
import com.zhaoxk_job.service.NoticeService;


@SessionAttributes
public class ShowIndexAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    NewsService newsService;
    NoticeService noticeService;
    private String msg;


    @Override
    public String execute() throws Exception {
        // System.out.println("count�?" +
        // ActionContext.getContext().getSession().get("count"));
        List<News> news_list = newsService.findAll();
        List<Notice> notices_list = noticeService.findAll();
        if (news_list.size() > 0 && notices_list.size() > 0) {
            if (news_list.size() >= 10)
                news_list = news_list.subList(0, 10);
            if (notices_list.size() >= 10)
                notices_list = notices_list.subList(0, 10);
            ActionContext.getContext().getSession().put("news_list", news_list);
            ActionContext.getContext().getSession().put("notice_list", notices_list);
            msg = "信息查询成功�?";
        } else {
            msg = "信息查询失败！数据库没有此内容�??";

        }

        return SUCCESS;
    }


    public NewsService getNewsService() {
        return newsService;
    }


    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }





    public NoticeService getNoticeService() {
        return noticeService;
    }


    public void setNoticeService(NoticeService noticeService) {
        this.noticeService = noticeService;
    }


    public String getMsg() {
        return msg;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }


}
