package com.example.campushelper.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
		listViewNotice.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Notice notice = noticeList.get(position);
				Intent intent = new Intent(NoticeActivity.this,NoticeShowActivity.class);
				intent.putExtra("noticeTitle", notice.getNotiTitle());
				intent.putExtra("noticeTime", notice.getNotiTime());
				intent.putExtra("noticeContent", notice.getNotiContent());
				intent.putExtra("noticeOrganizn", notice.getNotiOrgan());
				startActivity(intent);
			}
		});
	}
}
