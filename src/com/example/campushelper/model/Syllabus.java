package com.example.campushelper.model;

public class Syllabus {
	private String StuId;      //学生编号  FK 
	private String CosId;      //课程编号  FK
	private String TeaId;      //教师编号  FK
	private String SylTime;    //授课时间
	private String SylWeek;    //授课周
	private String SylAddress; //授课地点
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
	public String getTeaId() {
		return TeaId;
	}
	public void setTeaId(String teaId) {
		TeaId = teaId;
	}
	public String getSylTime() {
		return SylTime;
	}
	public void setSylTime(String sylTime) {
		SylTime = sylTime;
	}
	public String getSylWeek() {
		return SylWeek;
	}
	public void setSylWeek(String sylWeek) {
		SylWeek = sylWeek;
	}
	public String getSylAddress() {
		return SylAddress;
	}
	public void setSylAddress(String sylAddress) {
		SylAddress = sylAddress;
	}
	
}
