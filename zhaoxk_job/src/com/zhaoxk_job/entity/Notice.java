package com.zhaoxk_job.entity;

public class Notice {
	
	private Integer noticeID ;
	private String number ;
	private String username;
	private String title ;
	private String noticeContent ;
	private String submitTime ;
	public Integer getNoticeID() {
		return noticeID;
	}
	public void setNoticeID(Integer noticeID) {
		this.noticeID = noticeID;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	@Override
	public String toString() {
		return "Notice [noticeID=" + noticeID + ", number=" + number + ", username=" + username + ", title=" + title
				+ ", noticeContent=" + noticeContent + ", submitTime=" + submitTime + "]";
	}
	
	
}
