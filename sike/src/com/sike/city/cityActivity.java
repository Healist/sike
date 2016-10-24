package com.sike.city;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.sike.R;
import com.sike.activity.detailActivity;
import com.sike.adapter.ListViewAdapter;
import com.sike.event.updateEvent;
import com.sike.subject.subjectActivity;
import com.sike.tool.MyImageButton;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import de.greenrobot.event.EventBus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class cityActivity extends Activity {

	MyImageButton button0;
	MyImageButton button1;
	MyImageButton button2;
	MyImageButton button3;
	MyImageButton button4;
	MyImageButton button5;
	MyImageButton button6;
	MyImageButton button7;
	MyImageButton button8;
	MyImageButton button9;
	MyImageButton button10;
	MyImageButton button11;
	MyImageButton button12;

    @Override
	public void onCreate(Bundle savedInstanceState){
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.classification);
		initImageButtonView();
	}
	
	
	private void initImageButtonView() {
		// TODO Auto-generated method stub
		button0 = (MyImageButton) findViewById(R.id.num_0);
		button1 = (MyImageButton) findViewById(R.id.num_1);
		button2 = (MyImageButton) findViewById(R.id.num_2);
		button3 = (MyImageButton) findViewById(R.id.num_3);
		button4 = (MyImageButton) findViewById(R.id.num_4);
		button5 = (MyImageButton) findViewById(R.id.num_5);
		button6 = (MyImageButton) findViewById(R.id.num_6);
		button7 = (MyImageButton) findViewById(R.id.num_7);
		button8 = (MyImageButton) findViewById(R.id.num_8);
		button9 = (MyImageButton) findViewById(R.id.num_9);
		button10 = (MyImageButton) findViewById(R.id.num_10);
		button11 = (MyImageButton) findViewById(R.id.num_11);
		
		button0.setText("北京");
		button0.setColor(android.graphics.Color.WHITE);
		
		button1.setText("上海");
		button1.setColor(android.graphics.Color.WHITE);
		
		button2.setText("广州");
		button2.setColor(android.graphics.Color.WHITE);
		
		button3.setText("西安");
		button3.setColor(android.graphics.Color.WHITE);
		
		button4.setText("杭州");
		button4.setColor(android.graphics.Color.WHITE);
		
		button5.setText("成都");
		button5.setColor(android.graphics.Color.WHITE);
		
		button6.setText("合肥");
		button6.setColor(android.graphics.Color.WHITE);
		
		button7.setText("大连");
		button7.setColor(android.graphics.Color.WHITE);
		
		button8.setText("哈尔滨");
		button8.setColor(android.graphics.Color.WHITE);
		
		button9.setText("重庆");
		button9.setColor(android.graphics.Color.WHITE);
		
		button10.setText("甘肃");
		button10.setColor(android.graphics.Color.WHITE);
		
		button11.setText("青海");
		button11.setColor(android.graphics.Color.WHITE);
		
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("sub", "start");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("sub", "resume");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
	}
}
