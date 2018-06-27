package com.example.campushelper.model;

public class Student {
	private String StuId;   //学生编号
	private String StuName; //学生姓名 
	private String StuPsd;   //学生密码
	public String getStuId() {
		return StuId;
	}
	public void setStuId(String stuId) {
		StuId = stuId;
	}
	public String getStuName() {
		return StuName;
	}
	public void setStuName(String stuName) {
		StuName = stuName;
	}
	public String getStuPsd() {
		return StuPsd;
	}
	public void setStuPsd(String stuPsd) {
		StuPsd = stuPsd;
	}
}
