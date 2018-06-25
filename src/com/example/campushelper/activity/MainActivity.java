package com.example.campushelper.activity;

import com.example.campushelper.R;

import android.os.Bundle;
import android.app.Activity;
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
	private TextView btn_open_draw,btn_more;
	
	private String[] data ={"Apple","Banana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_left_drawer);
        listView.setAdapter(adapter);
        
        btn_open_draw = (TextView) findViewById(R.id.btn_open_draw);
        btn_open_draw.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mDrawerLayout.openDrawer(Gravity.LEFT);
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
