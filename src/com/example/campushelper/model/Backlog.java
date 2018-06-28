package com.example.campushelper.model;

public class Backlog {
	private int BagId; // 事项编号
	private String BagContent; // 事项内容
	private String BagTime; // 事项提醒时间
	
	public int getBagId() {
		return BagId;
	}
	public void setBagId(int bagId) {
		BagId = bagId;
	}
	public String getBagContent() {
		return BagContent;
	}
	public void setBagContent(String bagContent) {
		BagContent = bagContent;
	}
	public String getBagTime() {
		return BagTime;
	}
	public void setBagTime(String bagTime) {
		BagTime = bagTime;
	}
	
}
