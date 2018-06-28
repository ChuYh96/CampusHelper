package com.example.campushelper.activity;

import com.example.campushelper.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NoticeShowActivity extends BaseActivity{
	private TextView notice_title,notice_time,notice_content,notice_organiz;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_notice_show);
		Intent intent = getIntent();
		String noticeTitle=intent.getStringExtra("noticeTitle");
		String noticeTime=intent.getStringExtra("noticeTime");
		String noticeContent=intent.getStringExtra("noticeContent");
		String noticeOrganiz=intent.getStringExtra("noticeOrganizn");
		
		notice_title = (TextView)findViewById(R.id.text_notice_title);
		notice_time = (TextView)findViewById(R.id.text_notice_time);
		notice_content = (TextView)findViewById(R.id.text_notice_content);
		notice_organiz = (TextView)findViewById(R.id.text_notice_organiz);
		
		notice_title.setText(noticeTitle);
		notice_time.setText(noticeTime);
		notice_content.setText(noticeContent);
		notice_organiz.setText(noticeOrganiz);
	}
}
