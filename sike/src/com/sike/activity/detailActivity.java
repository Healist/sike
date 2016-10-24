package com.sike.activity;

import com.example.sike.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class detailActivity extends Activity {
	
	TextView tv_title;
	TextView tv_date;
	TextView tv_con;
	TextView tv_city;
	TextView tv_author;
	TextView tv_place;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		//用自定义的字体方法
		//FontManager.changeFonts(FontManager.getContentView(this),this);
		initRecDetails();
	}
	
	public void initRecDetails(){
		
		tv_title = (TextView)findViewById(R.id.detail_title);
		tv_date  = (TextView)findViewById(R.id.detail_date);
		tv_city  = (TextView)findViewById(R.id.detail_city);
		tv_con   = (TextView)findViewById(R.id.detail_content);
		tv_city  = (TextView)findViewById(R.id.detail_city);
		tv_author= (TextView)findViewById(R.id.detail_author);
		tv_place = (TextView)findViewById(R.id.detail_place);
		
		Intent intent = this.getIntent();
		Bundle bundle = intent.getExtras();
		//获取传递的参数值
		String title = bundle.getString("title");
		title.replaceAll(" ", "");
		String date = bundle.getString("date");
		date.replaceAll(" ", "");
		String content = bundle.getString("content");
		String city = bundle.getString("city");
		city.replaceAll(" ", "");
		String author = bundle.getString("author");
		author.replaceAll(" ", "");
		String place = bundle.getString("place");
		
		//Bitmap bitmap = (Bitmap)getIntent().getParcelableExtra("BITMAP");  
		//设置页面的值
	    //mImageViewPortrait.setImageBitmap(bitmap); 
		tv_title.setText(title);
		tv_date.setText(date);
		tv_con.setText(content);
		tv_city.setText(city);
		tv_author.setText(author);
		tv_place.setText(place);
	}
}
