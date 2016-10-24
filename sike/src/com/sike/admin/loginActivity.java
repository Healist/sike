package com.sike.admin;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.sike.R;
import com.sike.activity.MainActivity;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends Activity {

	SharedPreferences pref;
	SharedPreferences.Editor editor;
	EditText userNameText;
	EditText passwdText;
	CheckBox rememberPass;
	Button bnLogin;
	Button jumpBtn;
	
	UserService uService;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //用户操作
        uService=new UserService(this.getApplicationContext());
        
        userNameText = (EditText)findViewById(R.id.userNameText);
        passwdText   = (EditText)findViewById(R.id.passwdText);
        rememberPass = (CheckBox)findViewById(R.id.remember_pass);
        bnLogin      = (Button)findViewById(R.id.bnLogin); 
        jumpBtn      = (Button)findViewById(R.id.jumpBtn);
        
        bnLogin.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String account = userNameText.getText().toString();
				String password = passwdText.getText().toString();
				//验证请求
				boolean flag = uService.login(account, password);
				if(flag){
					Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(loginActivity.this, MainActivity.class);
					startActivity(intent);
		            Log.d("TAG","登录成功");
		        }else{
		        	Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
		            Log.d("TAG","登录失败");
		        }
			}
        });
        
        jumpBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(loginActivity.this,MainActivity.class);
				startActivity(intent);
			}
        });
        
	}
	
}
