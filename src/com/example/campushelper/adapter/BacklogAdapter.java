package com.example.campushelper.adapter;

import java.util.List;

import com.example.campushelper.R;
import com.example.campushelper.model.Backlog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class BacklogAdapter extends ArrayAdapter<Backlog> {
	private int resourceId;

	public BacklogAdapter(Context context, int textViewResourceId,
			List<Backlog> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Backlog backlog = getItem(position);
		View view;
		ViewHolder viewHolder;
		if(convertView == null){
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder=new ViewHolder();
			viewHolder.backlogContent = (TextView) view
					.findViewById(R.id.backlog_content);
			viewHolder.backlogTime = (TextView) view.findViewById(R.id.backlog_time);
			view.setTag(viewHolder);
		}else{
			view = convertView;
			viewHolder = (ViewHolder)view.getTag();
		}
		viewHolder.backlogContent.setText(backlog.getBagContent());
		viewHolder.backlogTime.setText(backlog.getBagTime());
		return view;
	}
	class ViewHolder{
		TextView backlogContent;
		TextView backlogTime;
	}

}
