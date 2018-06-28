package com.example.campushelper.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.campushelper.R;
import com.example.campushelper.R.id;
import com.example.campushelper.adapter.BacklogAdapter;
import com.example.campushelper.dao.CampusHelperDB;
import com.example.campushelper.model.*;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class BacklogActivity extends BaseActivity {
	private TextView btn_new_backlog;
	private List<Backlog> backlogList = new ArrayList<Backlog>();
	private CampusHelperDB campusHelperDB;
	private AlertDialog.Builder builder;
	EditText backlog_content,backlog_time;
	private static String backlog_id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_backlog);
		
		campusHelperDB = CampusHelperDB.getInstance(this);
		backlogList=campusHelperDB.selectBacklogInfo();
		BacklogAdapter adapter = new BacklogAdapter(
				BacklogActivity.this, R.layout.backlog_item, backlogList);
		ListView listViewBacklog = (ListView) findViewById(R.id.list_view_backlog);
		listViewBacklog.setAdapter(adapter);
		/*listViewBacklog.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Backlog backlog = backlogList.get(position);
				Toast.makeText(BacklogActivity.this, backlog.getBagContent(),
						Toast.LENGTH_SHORT).show();
				
			}
		});*/
		listViewBacklog.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {
			
			@Override
			public void onCreateContextMenu(ContextMenu menu, View v,
					ContextMenuInfo menuInfo) {
				// TODO Auto-generated method stub
				menu.add(0, 0, 0, "更新");
				menu.add(0, 1, 0, "删除");
			}
		});
		btn_new_backlog=(TextView)findViewById(R.id.btn_new_backlog);
		btn_new_backlog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				addBacklogDialog();
			}
		});

	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		AdapterContextMenuInfo info = (AdapterContextMenuInfo)item.getMenuInfo();
		Backlog backlog = new Backlog();
		backlog = backlogList.get((int)info.id);
		int bagId = backlog.getBagId();
		backlog_id = String.valueOf(bagId);
		switch (item.getItemId()){
		case 0:
			changBacklogDialog(backlog.getBagContent(),backlog.getBagTime());
			//refresh();提示框会一闪而逝
			break;
		case 1:
			campusHelperDB.DeleteBacklog(backlog_id);
			refresh();
			break;
		default:
			break;
		}
		return super.onContextItemSelected(item);
	}

	private void addBacklogDialog(){
		builder= new AlertDialog.Builder(BacklogActivity.this);
		LayoutInflater inflater = LayoutInflater.from(BacklogActivity.this);
		View view = inflater.inflate(R.layout.layout_dialog, null);
    	backlog_content=(EditText)view.findViewById(R.id.text_backlog_content);
    	backlog_time=(EditText)view.findViewById(R.id.text_backlog_time);
		builder.setView(view);
		//添加一个确定按钮
		builder.setPositiveButton("保存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String backlogContent = backlog_content.getText().toString();
                String backlogTime = backlog_time.getText().toString();
                campusHelperDB.addBacklog(backlogContent,backlogTime);
            }
        });
		//添加一个取消按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Main","用户点击了取消按钮");
                Log.d("Main","用户点击了取消按钮"+i);
            }
        });
		builder.show();
	}

	private void changBacklogDialog(String content,String time) {
		// TODO Auto-generated method stub
		builder= new AlertDialog.Builder(BacklogActivity.this);
		LayoutInflater inflater = LayoutInflater.from(BacklogActivity.this);
		View view = inflater.inflate(R.layout.layout_dialog, null);
		backlog_content=(EditText)view.findViewById(R.id.text_backlog_content);
		backlog_time=(EditText)view.findViewById(R.id.text_backlog_time);
    	backlog_content.setText(content);
    	backlog_time.setText(time);
		builder.setView(view);
		//添加一个确定按钮
		builder.setPositiveButton("保存", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String backlogContent = backlog_content.getText().toString();
                String backlogTime = backlog_time.getText().toString();
                campusHelperDB.ChangBacklog(backlog_id,backlogContent,backlogTime);
            }
        });
		//添加一个取消按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Main","用户点击了取消按钮");
                Log.d("Main","用户点击了取消按钮"+i);
            }
        });
		builder.show();
	}
	private void refresh() {
		// TODO Auto-generated method stub
		finish();
	}
}
