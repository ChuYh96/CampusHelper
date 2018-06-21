package com.example.campushelper.model;

public class Report {
	private String StuId;// 学生编号  FK 
	private String CosId;// 课程      FK
	private String RepNum;// 成绩
	private String RepTerm;// 学期(第一学期）
	public String getStuId() {
		return StuId;
	}
	public void setStuId(String stuId) {
		StuId = stuId;
	}
	public String getCosId() {
		return CosId;
	}
	public void setCosId(String cosId) {
		CosId = cosId;
	}
	public String getRepNum() {
		return RepNum;
	}
	public void setRepNum(String repNum) {
		RepNum = repNum;
	}
	public String getRepTerm() {
		return RepTerm;
	}
	public void setRepTerm(String repTerm) {
		RepTerm = repTerm;
	}
	
}
