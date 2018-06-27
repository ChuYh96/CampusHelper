package com.example.campushelper.activity;
import com.example.campushelper.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ScheduleActivity extends BaseActivity {
	private TextView btn_back;
	private EditText edit_semester, edit_stuId;
	private Button btn_search_schedule;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_schedule);

		btn_back = (TextView) findViewById(R.id.title_back);
		btn_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// finish();
				Intent intent = new Intent(ScheduleActivity.this,
						MainActivity.class);
				startActivity(intent);
			}
		});
		edit_semester = (EditText) findViewById(R.id.edit_semester);
		edit_stuId = (EditText) findViewById(R.id.edit_stu_num);
		btn_search_schedule = (Button) findViewById(R.id.btn_search_schedule);
		btn_search_schedule.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String semester = edit_semester.getText().toString();
				String stuNum = edit_stuId.getText().toString();
				ScheduleShowActivity.actionStart(ScheduleActivity.this, semester, stuNum);
			}
		});

	}
	

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ActivityCollector.finishAll();
	}
}
