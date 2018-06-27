package com.example.campushelper.model;

public class Schedule {
	private String StuId;      //学生编号  FK
	private String Semester;    //学期 2017-2018-2
    private String CosName;      //课程编号  FK
    private String TeaName;      //教师编号  FK
    private int SchWeek;    //授课周01,02
	private int SchDay;     //授课日01,02
	private int SchSection; //授课节12,34
    private String SchAddress; //授课地点
	public String getStuId() {
		return StuId;
	}
	public void setStuId(String stuId) {
		StuId = stuId;
	}
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String semester) {
		Semester = semester;
	}
	
	public String getCosName() {
		return CosName;
	}
	public void setCosName(String cosName) {
		CosName = cosName;
	}
	public String getTeaName() {
		return TeaName;
	}
	public void setTeaName(String teaName) {
		TeaName = teaName;
	}
	
	public int getSchWeek() {
		return SchWeek;
	}
	public void setSchWeek(int schWeek) {
		SchWeek = schWeek;
	}
	public int getSchDay() {
		return SchDay;
	}
	public void setSchDay(int schDay) {
		SchDay = schDay;
	}
	public int getSchSection() {
		return SchSection;
	}
	public void setSchSection(int schSection) {
		SchSection = schSection;
	}
	public String getSchAddress() {
		return SchAddress;
	}
	public void setSchAddress(String schAddress) {
		SchAddress = schAddress;
	}
	
	
	
}
