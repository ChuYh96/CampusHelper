package com.example.campushelper.adapter;

import java.util.List;

import com.example.campushelper.R;
import com.example.campushelper.model.Notice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NoticeAdapter extends ArrayAdapter<Notice> {
	private int resourceId;
	public NoticeAdapter(Context context, int textViewResourceId,
			List<Notice> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		resourceId = textViewResourceId;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Notice notice = getItem(position);//µ±Ç°ÊµÀý
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		TextView noticeTitle=(TextView)view.findViewById(R.id.notice_title);
		TextView noticeTime=(TextView)view.findViewById(R.id.notice_time);
		noticeTitle.setText(notice.getNotiTitle());
		noticeTime.setText(notice.getNotiTime());
		return view;
	}
	

}
