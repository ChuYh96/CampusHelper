package com.example.campushelper.model;

public class Schedule {
	private String StuId;      //ѧ�����  FK
	private String Semester;    //ѧ�� 2017-2018-2
    private String CosName;      //�γ̱��  FK
    private String TeaName;      //��ʦ���  FK
    private int SchWeek;    //�ڿ���01,02
	private int SchDay;     //�ڿ���01,02
	private int SchSection; //�ڿν�12,34
    private String SchAddress; //�ڿεص�
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
