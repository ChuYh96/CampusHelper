package com.example.campushelper.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class CampusHelperOpenHelper extends SQLiteOpenHelper {
	// 学生表
	public static final String CREATE_STUDENT = "create table Student ("
			+ "StuId text primary key, " + "StuName text, " + "StuPsd text)";
	// 课程表
	public static final String CREATE_SCHEDULE = "create table Schedule ("
			+ "StuId text, " + "Semester text, " + "CosName text, "
			+ "TeaName text, " + "SchWeek int, "// 第几周
			+ "SchDay int, "// 星期几
			+ "SchSection int, "// 几几节
			+ "SchAddress text, "// 地点2206
			+ "PRIMARY KEY(StuId,Semester,SchWeek,SchDay,SchSection))";
	public static final String CREATE_NOTICE = "CREATE TABLE Notice ("
			+ "NotiId      TEXT PRIMARY KEY NOT NULL, "
			+ "NotiTitle   TEXT NOT NULL, " + "NotiContent TEXT NOT NULL, "
			+ "NotiTime    TEXT NOT NULL, " + "NotiOrgan   TEXT NOT NULL)";
	public static final String CREATE_BACKLOG = "CREATE TABLE Backlog ("
			+ "BagId      INTEGER PRIMARY KEY autoincrement,"
			+ "BagContent TEXT    NOT NULL," + "BagTime    TEXT    NOT NULL)";

	// private Context mContext;
	public CampusHelperOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		// mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_STUDENT);
		db.execSQL(CREATE_SCHEDULE);
		db.execSQL(CREATE_NOTICE);
		db.execSQL(CREATE_BACKLOG);
		// Toast.makeText(mContext, "Create", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
