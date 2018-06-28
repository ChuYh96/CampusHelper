package com.example.campushelper.activity;

import com.example.campushelper.R;
import com.example.campushelper.dao.CampusHelperDB;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends BaseActivity {
	TextView tv_name,tv_password;
	private CampusHelperDB campusHelperDB;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_register);
		campusHelperDB = CampusHelperDB.getInstance(this);
		tv_name=(TextView)findViewById(R.id.edit_register_stu_id);
	    tv_password=(TextView)findViewById(R.id.edit_register_stu_pwd);
		Button register = (Button)findViewById(R.id.btn_register);
		
		register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name=tv_name.getText().toString();
				String password=tv_password.getText().toString();
				campusHelperDB.addStudent(name,password);
			}
		});
	}
}
