package com.example.campushelper.activity;

import com.example.campushelper.R;
import com.example.campushelper.dao.CampusHelperDB;
import com.example.campushelper.service.DBService;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
	private Button btn_login;
	private EditText editStuId, editStuPwd;
	private DBService service;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.layout_login);
		btn_login=(Button)findViewById(R.id.btn_login);
		editStuId=(EditText)findViewById(R.id.edit_login_stu_id);
		editStuPwd=(EditText)findViewById(R.id.edit_login_stu_pwd);
		btn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String stuId= editStuId.getText().toString();
				String stuPwd= editStuPwd.getText().toString();
				
				service= new DBService();
				Boolean result = service.loginVerify(stuId, stuPwd);
				
				if(result){
					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
				}
				else{
					Toast.makeText(LoginActivity.this, "√‹¬Î¥ÌŒÛ", Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
