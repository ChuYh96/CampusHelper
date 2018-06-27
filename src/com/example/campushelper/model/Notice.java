package com.example.campushelper.model;

public class Notice {
	private String NotiId; //  通知编号
	private String NotiTitle; // 通知标题
	private String NotiContent; // 通知内容
	private String NotiTime; // 通知时间
	private String NotiOrgan; // 通知机构
	public String getNotiId() {
		return NotiId;
	}
	public void setNotiId(String notiId) {
		NotiId = notiId;
	}
	public String getNotiTitle() {
		return NotiTitle;
	}
	public void setNotiTitle(String notiTitle) {
		NotiTitle = notiTitle;
	}
	public String getNotiContent() {
		return NotiContent;
	}
	public void setNotiContent(String notiContent) {
		NotiContent = notiContent;
	}
	public String getNotiTime() {
		return NotiTime;
	}
	public void setNotiTime(String notiTime) {
		NotiTime = notiTime;
	}
	public String getNotiOrgan() {
		return NotiOrgan;
	}
	public void setNotiOrgan(String notiOrgan) {
		NotiOrgan = notiOrgan;
	}
	
}
