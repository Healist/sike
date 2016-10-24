package com.sike.admin;

import com.example.sike.R;
import com.sike.activity.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signActivity extends Activity {
	
	SharedPreferences pref;
	SharedPreferences.Editor editor;
	EditText userNameText;
	EditText passwdText;
	EditText emailText;
	Button bnSign;
	Button jumpBtn;
	
	UserService uService;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        //用户操作
        uService=new UserService(this.getApplicationContext());
        
        userNameText = (EditText)findViewById(R.id.userNameTextSign);
        passwdText   = (EditText)findViewById(R.id.passwdTextSign);
        emailText    = (EditText)findViewById(R.id.emailTextSign);
        bnSign      =  (Button)findViewById(R.id.bnSign); 
        jumpBtn      = (Button)findViewById(R.id.jumpBtnSign);
        //??????????????????????????????????????????????????????????????????????????????
        bnSign.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String account = userNameText.getText().toString();
				String password = passwdText.getText().toString();
				String email   = emailText.getText().toString();
				String cityFocus = "";
				String subjectFocus = "";
				if(account.equals("") || password.equals("") || email.equals("")) {
					Toast.makeText(getApplicationContext(), "输入不能有空值，请重试", Toast.LENGTH_SHORT).show();
				}
				//验证请求
				User user = new User();
				user.setUsername(account);
				user.setPassword(password);
				user.setEmail(email);
				user.setCityFocus(cityFocus);
				user.setSubjectFocus(subjectFocus);
				boolean flag = uService.register(user);
				if(flag){
					Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(signActivity.this, MainActivity.class);
					Log.d("TAG","注册成功");
					pref = getSharedPreferences("user", Activity.MODE_PRIVATE);
					editor = pref.edit();
					editor.putString("account", user.getUserName());
					editor.putString("password", user.getPassword());
					editor.putString("email", user.getEmail());
					editor.putString("subjectFocus", user.getSubjectFocus());
					editor.putString("cityFocus", user.getCityFocus());
					editor.commit();
					startActivity(intent);
		            
		        }else{
		        	Toast.makeText(getApplicationContext(), "注册失败", Toast.LENGTH_SHORT).show();
		            Log.d("TAG","注册失败");
		        }
			}
        });
        
        jumpBtn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(signActivity.this,MainActivity.class);
				startActivity(intent);
			}
        });
        
	}

}
