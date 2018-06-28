package com.example.campushelper.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.campushelper.model.Backlog;
import com.example.campushelper.model.Notice;
import com.example.campushelper.model.Schedule;
import com.example.campushelper.model.Student;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CampusHelperDB {
	public static final String DB_NAME = "CampusHelper.db";
	public static final int VERSION = 1;
	private static CampusHelperDB campusHelperDB;
	private SQLiteDatabase db;

	private CampusHelperDB(Context context) {
		CampusHelperOpenHelper dbHelper = new CampusHelperOpenHelper(context,
				DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
	}

	public synchronized static CampusHelperDB getInstance(Context context) {
		if (campusHelperDB == null) {
			campusHelperDB = new CampusHelperDB(context);
		}
		return campusHelperDB;
	}

	public Boolean searchStuPwd(String stuId, String stuPwd) {
		Student student =new Student();
		Cursor cursor = db.rawQuery("select * from Student where StuId = ?", new String[]{stuId});
		if (cursor.moveToFirst()) {
			do {
				student.setStuId(cursor.getString(cursor.getColumnIndex("StuId")));
				student.setStuPsd(cursor.getString(cursor.getColumnIndex("StuPsd")));
			} while (cursor.moveToNext());
		}
		Log.d(stuId, stuPwd);
		Log.d(student.getStuId(), student.getStuPsd());
		if(student.getStuId().equals(stuId)&&student.getStuPsd().equals(stuPwd)){
			return true;
		}else
			return false;
	}

	public List<Schedule> selectSchedule(String data1, String data2) {
		List<Schedule> list = new ArrayList<Schedule>();
		Cursor cursor = db
				.rawQuery("select * from Schedule where Semester=? and StuId=?", new String[]{data1,data2});
		if (cursor.moveToFirst()) {
			do {
				Schedule schedule = new Schedule();
				schedule.setStuId(cursor.getString(cursor
						.getColumnIndex("StuId")));
				schedule.setSemester(cursor.getString(cursor
						.getColumnIndex("Semester")));
				schedule.setCosName(cursor.getString(cursor
						.getColumnIndex("CosName")));
				schedule.setTeaName(cursor.getString(cursor
						.getColumnIndex("TeaName")));
				schedule.setSchWeek(cursor.getInt(cursor
						.getColumnIndex("SchWeek")));
				schedule.setSchDay(cursor.getInt(cursor
						.getColumnIndex("SchDay")));
				schedule.setSchSection(cursor.getInt(cursor
						.getColumnIndex("SchSection")));
				schedule.setSchAddress(cursor.getString(cursor
						.getColumnIndex("SchAddress")));
				list.add(schedule);
			} while (cursor.moveToNext());
		}

		cursor.close();
		return list;
	}

	public String selectWeekDay(String stuId, String semester, String week, String day) {
		// TODO Auto-generated method stub
		Schedule schedule = new Schedule();
		Cursor cursor = db
				.rawQuery("select * from Schedule where StuId=? and Semester=? and " +
						"SchWeek=? and SchDay=?", new String[]{stuId, semester, week, day});
		if (cursor.moveToFirst()) {
			do {
				schedule.setCosName(cursor.getString(cursor
						.getColumnIndex("CosName")));
			} while (cursor.moveToNext());
		}
		return schedule.getCosName();
	}

	public List<Notice> selectNoticeInfo() {
		// TODO Auto-generated method stub
		List<Notice> list= new ArrayList<Notice>();
		Cursor cursor = db.rawQuery("select * from Notice", null);
		if (cursor.moveToFirst()) {
			do {
				Notice notice = new Notice();
				notice.setNotiId(cursor.getString(cursor
						.getColumnIndex("NotiId")));
				notice.setNotiTitle(cursor.getString(cursor
						.getColumnIndex("NotiTitle")));
				notice.setNotiContent(cursor.getString(cursor
						.getColumnIndex("NotiContent")));
				notice.setNotiTime(cursor.getString(cursor
						.getColumnIndex("NotiTime")));
				notice.setNotiOrgan(cursor.getString(cursor
						.getColumnIndex("NotiOrgan")));
				list.add(notice);
			} while (cursor.moveToNext());
		}
		return list;
	}

	public List<Backlog> selectBacklogInfo() {
		// TODO Auto-generated method stub
		List<Backlog> list= new ArrayList<Backlog>();
		Cursor cursor = db.rawQuery("select * from Backlog", null);
		if (cursor.moveToFirst()) {
			do {
				Backlog backlog = new Backlog();
				backlog.setBagId(cursor.getInt(cursor
						.getColumnIndex("BagId")));
				backlog.setBagContent(cursor.getString(cursor
						.getColumnIndex("BagContent")));
				backlog.setBagTime(cursor.getString(cursor
						.getColumnIndex("BagTime")));
				list.add(backlog);
			} while (cursor.moveToNext());
		}
		return list;
	}

	public void ChangBacklog(String bagId, String bagContent, String bagTime) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put("BagContent", bagContent);
		values.put("BagTime", bagTime);
		db.update("Backlog", values, "BagId=?", new String[]{bagId});
	}

	public void DeleteBacklog(String bagId) {
		// TODO Auto-generated method stub
		db.delete("Backlog", "BagId=?", new String[]{bagId});
	}

	public void addBacklog(String backlogContent, String backlogTime) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put("BagContent", backlogContent);
		values.put("BagTime", backlogTime);
		db.insert("Backlog", null, values);
	}

	public void addStudent(String name, String password) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put("StuId", name);
		values.put("StuPsd", password);
		db.insert("Student", null, values);
	}

}
