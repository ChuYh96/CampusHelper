package com.example.campushelper.activity;

import java.util.Calendar;
import java.util.TimeZone;

import com.example.campushelper.R;
import com.example.campushelper.R.id;
import com.example.campushelper.dao.CampusHelperDB;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	private DrawerLayout mDrawerLayout = null;
	private CampusHelperDB campusHelperDB;
	private TextView btn_open_draw;
	private TextView text_course;
	private TextView btn_class_schedule;// 课程表
	private TextView btn_notice;// 成绩单
	private TextView btn_backlog;
	private String[] data = { "Apple", "Banana" };
	private static String mWay;
	private String Semester = "2017-2018-2";
	private String Week = "10";
	private String stuId = "15175102";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		campusHelperDB = CampusHelperDB.getInstance(this);
		String Day = getData();
		String weekDay = campusHelperDB.selectWeekDay(stuId, Semester, Week,
				Day);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, data);
		ListView listView = (ListView) findViewById(R.id.list_left_drawer);
		listView.setAdapter(adapter);
		//打开左菜单
		btn_open_draw = (TextView) findViewById(R.id.btn_open_draw);
		btn_open_draw.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mDrawerLayout.openDrawer(Gravity.LEFT);
			}
		});
		//查询课表
		text_course = (TextView) findViewById(id.text_notice);
		if (weekDay == null) {
			text_course.setText("今天无课");
		} else {
			text_course.setText("今天有" + weekDay + "课");
		}
		//查询课程表
		btn_class_schedule = (TextView) findViewById(R.id.btn_class_schedule);
		btn_class_schedule.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,
						ScheduleActivity.class);
				startActivity(intent);
			}
		});
		//查询通知
		btn_notice=(TextView)findViewById(R.id.btn_notice);
		btn_notice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,NoticeActivity.class);
				startActivity(intent);
			}
		});
		btn_backlog=(TextView)findViewById(R.id.btn_backlog);
		btn_backlog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,BacklogActivity.class);
				startActivity(intent);
			}
		});
	}
	//获取系统时间
	private String getData() {
		// TODO Auto-generated method stub
		final Calendar c = Calendar.getInstance();
		c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
		return mWay;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
