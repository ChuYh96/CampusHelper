package com.example.campushelper.model;

public class Syllabus {
	private String StuId;      //ѧ�����  FK 
	private String CosId;      //�γ̱��  FK
	private String TeaId;      //��ʦ���  FK
	private String SylTime;    //�ڿ�ʱ��
	private String SylWeek;    //�ڿ���
	private String SylAddress; //�ڿεص�
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
