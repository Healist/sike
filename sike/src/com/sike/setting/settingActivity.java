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
	
	//SharedPreferences�洢
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
		 data_list_city.add("����");
		 data_list_city.add("�Ϻ�");
		 data_list_city.add("����");
		 data_list_city.add("����");
		 
		 data_list_city2 = new ArrayList<String>();
		 data_list_city2.add("����");
		 data_list_city2.add("�Ϻ�");
		 data_list_city2.add("����");
		 data_list_city2.add("����");
		 
		 data_list_city3 = new ArrayList<String>();
		 data_list_city3.add("����");
		 data_list_city3.add("�Ϻ�");
		 data_list_city3.add("����");
		 data_list_city3.add("����");
		 
		 data_list_sub = new ArrayList<String>();
		 data_list_sub.add("�������ѧ");
		 data_list_sub.add("�������");
		 data_list_sub.add("ͨ�Ź���");
		 data_list_sub.add("��Ϣ��ȫ");
		 data_list_sub.add("������ý��");
		 
		 data_list_sub2 = new ArrayList<String>();
		 data_list_sub2.add("�������ѧ");
		 data_list_sub2.add("�������");
		 data_list_sub2.add("ͨ�Ź���");
		 data_list_sub2.add("��Ϣ��ȫ");
		 data_list_sub2.add("������ý��");
		 
		 data_list_sub3 = new ArrayList<String>();
		 data_list_sub3.add("�������ѧ");
		 data_list_sub3.add("�������");
		 data_list_sub3.add("ͨ�Ź���");
		 data_list_sub3.add("��Ϣ��ȫ");
		 data_list_sub3.add("������ý��");
		 
		//������
        arr_adapter_city= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_city);
        //������ʽ
        arr_adapter_city.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //����������
        spinner_city.setAdapter(arr_adapter_city);
        
        arr_adapter_city2= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_city2);
        //������ʽ
        arr_adapter_city2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //����������
        spinner_city2.setAdapter(arr_adapter_city2);
        
        arr_adapter_city3= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_city3);
        //������ʽ
        arr_adapter_city3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //����������
        spinner_city3.setAdapter(arr_adapter_city3);
        
        
      //������
        arr_adapter_sub= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_sub);
        //������ʽ
        arr_adapter_sub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //����������
        spinner_sub.setAdapter(arr_adapter_sub);
        
      //������
        arr_adapter_sub2= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_sub2);
        //������ʽ
        arr_adapter_sub2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //����������
        spinner_sub2.setAdapter(arr_adapter_sub2);
        
      //������
        arr_adapter_sub3= new ArrayAdapter<String>(this, R.layout.spinner_item, data_list_sub3);
        //������ʽ
        arr_adapter_sub3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //����������
        spinner_sub3.setAdapter(arr_adapter_sub3);
		 
		 
	}
	
}
