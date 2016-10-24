package com.sike.setting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.sike.R;
import com.sike.adapter.settingAdapter;
import com.sike.admin.loginActivity;
import com.sike.admin.myFocusActivity;
import com.sike.admin.signActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class settingActivity extends Activity {
	
	private Spinner spinner_city;
	private Spinner spinner_city2;
	private Spinner spinner_city3;
	private Spinner spinner_sub;
	private Spinner spinner_sub2;
	private Spinner spinner_sub3;
	private List<String> data_list_city;
	private List<String> data_list_city2;
	private List<String> data_list_city3;
	private List<String> data_list_sub;
	private List<String> data_list_sub2;
	private List<String> data_list_sub3;
	private ArrayAdapter<String> arr_adapter_city;
	private ArrayAdapter<String> arr_adapter_city2;
	private ArrayAdapter<String> arr_adapter_city3;
	private ArrayAdapter<String> arr_adapter_sub;
	private ArrayAdapter<String> arr_adapter_sub2;
	private ArrayAdapter<String> arr_adapter_sub3;
	
	Button loginBtn;
	Button signBtn;
	
	//SharedPreferences存储
	SharedPreferences pref;
    SharedPreferences.Editor editor;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);  
        setContentView(R.layout.setting);
        
        initView();
        
	}
		
	 private void initView() {
		// TODO Auto-generated method stub
		 spinner_city = (Spinner) findViewById(R.id.spinner1);
		 spinner_city2 = (Spinner) findViewById(R.id.spinner11);
		 spinner_city3 = (Spinner) findViewById(R.id.spinner111);
		 
		 spinner_sub = (Spinner) findViewById(R.id.spinner2);
		 spinner_sub2 = (Spinner) findViewById(R.id.spinner22);
		 spinner_sub3 = (Spinner) findViewById(R.id.spinner222);
		 
		 data_list_city = new ArrayList<String>();
		 data_list_city.add("北京");
		 data_list_city.add("上海");
		 data_list_city.add("广州");
		 data_list_city.add("深圳");
		 
		 data_list_city2 = new ArrayList<String>();
		 data_list_city2.add("北京");
		 data_list_city2.add("上海");
		 data_list_city2.add("广州");
		 data_list_city2.add("深圳");
		 
		 data_list_city3 = new ArrayList<String>();
		 data_list_city3.add("北京");
		 data_list_city3.add("上海");
		 data_list_city3.add("广州");
		 data_list_city3.add("深圳");
		 
		 data_list_sub = new ArrayList<String>();
		 data_list_sub.add("计算机科学");
		 data_list_sub.add("软件工程");
		 data_list_sub.add("通信工程");
		 data_list_sub.add("信息安全");
		 data_list_sub.add("计数字媒体");
		 
		 data_list_sub2 = new ArrayList<String>();
		 data_list_sub2.add("计算机科学");
		 data_list_sub2.add("软件工程");
		 data_list_sub2.add("通信工程");
		 data_list_sub2.add("信息安全");
		 data_list_sub2.add("计数字媒体");
		 
		 data_list_sub3 = new ArrayList<String>();
		 data_list_sub3.add("计算机科学");
		 data_list_sub3.add("软件工程");
		 data_list_sub3.add("通信工程");
		 data_list_sub3.add("信息安全");
		 data_list_sub3.add("计数字媒体");
		 
		//适配器
        arr_adapter_city= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_city);
        //设置样式
        arr_adapter_city.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner_city.setAdapter(arr_adapter_city);
        
        arr_adapter_city2= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_city2);
        //设置样式
        arr_adapter_city2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner_city2.setAdapter(arr_adapter_city2);
        
        arr_adapter_city3= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_city3);
        //设置样式
        arr_adapter_city3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner_city3.setAdapter(arr_adapter_city3);
        
        
      //适配器
        arr_adapter_sub= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_sub);
        //设置样式
        arr_adapter_sub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner_sub.setAdapter(arr_adapter_sub);
        
      //适配器
        arr_adapter_sub2= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_sub2);
        //设置样式
        arr_adapter_sub2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner_sub2.setAdapter(arr_adapter_sub2);
        
      //适配器
        arr_adapter_sub3= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_sub3);
        //设置样式
        arr_adapter_sub3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner_sub3.setAdapter(arr_adapter_sub3);
		 
		 
	}
	
}
