package com.example.campushelper.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.campushelper.R;
import com.example.campushelper.adapter.AbsGridAdapter;
import com.example.campushelper.dao.CampusHelperDB;
import com.example.campushelper.model.Schedule;
import com.example.campushelper.service.DBService;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

public class ScheduleShowActivity extends Activity {
	private Spinner spinner;

    private GridView detailCource;

    private String[][] contents;

    private AbsGridAdapter myAdapter;

    private List<String> dataList;

    private ArrayAdapter<String> spinnerAdapter;
    private List<Schedule> scheduleList = new ArrayList<Schedule>();
    private Schedule schedule;
    private DBService service=new DBService();
	public static void actionStart(Context context, String semester,
			String stuId) {
		Intent intent = new Intent(context, ScheduleShowActivity.class);
		intent.putExtra("semester", semester);
		intent.putExtra("stuId", stuId);
		context.startActivity(intent);
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cource);
        spinner = (Spinner)findViewById(R.id.switchWeek);
        detailCource = (GridView)findViewById(R.id.courceDetail);

        fillStringArray();
        myAdapter = new AbsGridAdapter(this);
        myAdapter.setContent(contents, 6, 7);
        detailCource.setAdapter(myAdapter);

        fillDataList();
        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dataList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
        
    }

    public void fillStringArray() {
    	contents = new String[6][7];
    	Intent intent = getIntent();
		String semester = intent.getStringExtra("semester");
		String stuId = intent.getStringExtra("stuId");
		scheduleList = service.searchScheduleInfo(semester, stuId);
		for(int i=0;i<6;i++)
			for(int j=0;j<7;j++)
				contents[i][j]="";
		for(int i=0;i<scheduleList.size();i++){
			schedule = scheduleList.get(i);
			contents[schedule.getSchSection()-1][schedule.getSchDay()-1]=schedule.getCosName();
		}
    }
    
    public void fillDataList() {
        dataList = new ArrayList<String>();
        for(int i = 1; i < 21; i++) {
            dataList.add("µÚ" + i + "ÖÜ");
        }
    }
}
