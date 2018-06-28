package com.example.campushelper.service;

import java.util.List;

import android.content.Context;
import com.example.campushelper.model.*;
import com.example.campushelper.util.MyApplication;
import com.example.campushelper.dao.CampusHelperDB;

public class DBService {
	public static final Context CONTEXT = MyApplication.getContext();
	private CampusHelperDB campusHelperDB = CampusHelperDB.getInstance(CONTEXT);
	public DBService() {
		// TODO Auto-generated constructor stub
	}
	public Boolean loginVerify(String stuId,String stuPwd){
		Boolean verifyResult = campusHelperDB.searchStuPwd(stuId,stuPwd);
		return verifyResult;
	}
	public String courseSearch(String stuId, String Semester, String Week,String Day){
		String weekDay = campusHelperDB.selectWeekDay(stuId, Semester, Week,Day);
		return weekDay;
	}
	public List<Schedule> searchScheduleInfo(String semester, String stuId){
		List<Schedule> dataList=campusHelperDB.selectSchedule(semester, stuId);
		return dataList;
	}
	public List<Notice> searchNoticeInfo(){
		List<Notice> dataList=campusHelperDB.selectNoticeInfo();
		return dataList;
	}
	public List<Backlog> selectBacklogInfo(){
		List<Backlog> dataList=campusHelperDB.selectBacklogInfo();
		return dataList;
	}
	public void DeleteBacklog(String backlog_id){
		campusHelperDB.DeleteBacklog(backlog_id);
	}
	public void addBacklog(String backlogContent,String backlogTime){
		campusHelperDB.addBacklog(backlogContent,backlogTime);
	}
	public void ChangBacklog(String backlog_id, String backlogContent,String backlogTime){
		campusHelperDB.ChangBacklog(backlog_id,backlogContent,backlogTime);
	}
}
