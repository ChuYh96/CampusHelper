package com.example.campushelper.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.example.campushelper.R;
import com.example.campushelper.adapter.NoticeAdapter;
import com.example.campushelper.dao.CampusHelperDB;
import com.example.campushelper.model.Notice;

public class NoticeActivity extends BaseActivity {
	private List<Notice> noticeList = new ArrayList<Notice>();
	private CampusHelperDB campusHelperDB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_notice);
		
		campusHelperDB = CampusHelperDB.getInstance(this);
		noticeList=campusHelperDB.selectNoticeInfo();
		
		NoticeAdapter adapter = new NoticeAdapter(
				NoticeActivity.this, R.layout.notice_item, noticeList);
		ListView listViewNotice = (ListView) findViewById(R.id.list_view_notice);
		listViewNotice.setAdapter(adapter);
	}
}
