package com.example.campushelper.model;

public class Report {
	private String StuId;// ѧ�����  FK 
	private String CosId;// �γ�      FK
	private String RepNum;// �ɼ�
	private String RepTerm;// ѧ��(��һѧ�ڣ�
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
