package com.example.campushelper.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class CampusHelperOpenHelper extends SQLiteOpenHelper {
	// 学生表
	public static final String CREATE_STUDENT = "create table Student ("
			+ "StuId text primary key, " + "StuName text, " + "StuPsd text, "
			+ "StuMajor text," + "StuClass text," + "StuGrade text)";
	// 教师表
	public static final String CREATE_TEACHER = "create table Teacher ("
			+ "TeaId text primary key, " + "TeaName text, " + "StuPsd text)";
	// 课程表
	public static final String CREATE_COURSE = "create table Course ("
			+ "CosId text primary key, " + "CosNam text, " + "StuPsd text)";
	// 成绩表
	public static final String CREATE_REPORT = "create table Report ("
			+ "StuId text, " + "CosId text, " + "RepNum text, "
			//+ "RepTerm text)";
			+ "RepTerm text, "
			+ "foreign key (StuId) references Student (StuId), "
			+ "foreign key (CosId) references Course (CosId))";
	// 课程表
	public static final String CREATE_SYLLABUS = "create table Syllabus ("
			+ "StuId text, "
			+ "CosId text, "
			+ "TeaId text, "
			+ "SylWeek text, "// 第几周
			+ "SylTime text, "// 星期几，几几节
			//+ "SylAddress text)";// 2206
			+ "SylAddress text, "// 2206
			+ "foreign key (StuId) references Student (StuId), "
			+ "foreign key (TeaId) references Teacher (TeaId), "
			+ "foreign key (CosId) references Course (CosId))";

	//private Context mContext;
	public CampusHelperOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		//mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_STUDENT);
		db.execSQL(CREATE_TEACHER);
		db.execSQL(CREATE_COURSE);
		db.execSQL(CREATE_REPORT);
		db.execSQL(CREATE_SYLLABUS);
		//Toast.makeText(mContext, "Create", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
