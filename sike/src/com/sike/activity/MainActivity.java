package com.sike.activity;

import java.util.ArrayList;

import com.example.sike.R;
import com.sike.city.cityActivity;
import com.sike.event.updateEvent;
import com.sike.hot.hotActivity;
import com.sike.recommend.recommendActivity;
import com.sike.search.SearchResultActvity;
import com.sike.setting.settingActivity;
import com.sike.subject.subjectActivity;

import de.greenrobot.event.EventBus;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SearchView;


public class MainActivity extends ActivityGroup {
	
	private ViewPager m_vp;//��ҳ����
	private LocalActivityManager manager=null;
	private ArrayList<View> list;//���activity���б�
	PagerAdapter fa;
	private ActionBar  bar = null;
	
    @SuppressWarnings("deprecation")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		bar = getActionBar();
		//bar.setDisplayHomeAsUpEnabled(true);
		//bar.setHomeButtonEnabled(true); //����ʾ��ͷС���ţ�������ʹ��
        
        bar.setTitle(" ");
		
        manager=new LocalActivityManager(this,true);
        manager.dispatchCreate(savedInstanceState);
        
        m_vp=(ViewPager)MainActivity.this.findViewById(R.id.viewpager);
        //��ȡButton����
        final Button bn0= (Button) findViewById(R.id.Button01);
        final Button bn1 = (Button) findViewById(R.id.Button02);
        final Button bn2 = (Button) findViewById(R.id.Button03);
        final Button bn3 = (Button) findViewById(R.id.Button04);
        final Button bn4 = (Button) findViewById(R.id.Button05);
        
        //Ĭ�Ͽ�ʼѡ�е�һ��
        changeText(bn0,bn1,bn2,bn3,bn4,0);
        
        //���ü���
        bn0.setOnClickListener(
				new OnClickListener()
				{
					@Override
					public void onClick(View v) 
					{
						changeText(bn0,bn1,bn2,bn3,bn4,0);
					}
				});
        bn1.setOnClickListener(
				new OnClickListener()
				{
					@Override
					public void onClick(View v) 
					{
						changeText(bn0,bn1,bn2,bn3,bn4,1);
					}
				});
        bn2.setOnClickListener(
				new OnClickListener()
				{
					@Override
					public void onClick(View v) 
					{
						changeText(bn0,bn1,bn2,bn3,bn4,2);
					}
				});
        bn3.setOnClickListener(
				new OnClickListener()
				{
					@Override
					public void onClick(View v) 
					{
						changeText(bn0,bn1,bn2,bn3,bn4,3);
					}
				});
        
        bn4.setOnClickListener(
				new OnClickListener()
				{
					@Override
					public void onClick(View v) 
					{
						changeText(bn0,bn1,bn2,bn3,bn4,4);
					}
				});
        
        
        //����List����
        list=new ArrayList<View>();
        Intent intent1=new Intent(this,recommendActivity.class);
        list.add(getView("recommendActivity",intent1));
        Intent intent2=new Intent(this,hotActivity.class);
        list.add(getView("hotActivity",intent2));
        Intent intent3=new Intent(this,subjectActivity.class);
        list.add(getView("subjectActivity",intent3));
        Intent intent4=new Intent(this,cityActivity.class);
        list.add(getView("cityActivity",intent4));
        Intent intent5=new Intent(this,settingActivity.class);
        list.add(getView("settingActivity",intent5));
        
        //׼��PagerAdapter������
        fa=new PagerAdapter()
        {
        	 @Override
             public void destroyItem(ViewGroup container, int position,Object object) 
        	 {
                 ViewPager pViewPager = ((ViewPager) container);
                 pViewPager.removeView(list.get(position));
             }
			@Override
			public int getCount() 
			{
				// TODO Auto-generated method stub
				return list.size();
			}
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) 
			{
				// TODO Auto-generated method stub
				return arg0==arg1;
			}
			
			 @Override
		     public Object instantiateItem(View arg0, int arg1) 
			 {
		         ViewPager pViewPager = ((ViewPager) arg0);
		         pViewPager.addView(list.get(arg1));
		         return list.get(arg1);
		     }
        };
 
        m_vp.setAdapter(fa);
        m_vp.setCurrentItem(0);
        //��Ӽ���
        m_vp.setOnPageChangeListener(
        		new  OnPageChangeListener()
        		{
        			@Override  
            	    public void onPageScrollStateChanged(int arg0) 
        			{  
            	        // TODO Auto-generated method stub  
            	    }  

            	    @Override  
            	    public void onPageScrolled(int arg0, float arg1, int arg2) 
            	    {  
            	        // TODO Auto-generated method stub 
            	    }  

            	    @Override  
            	    public void onPageSelected(int arg0) 
            	    {  
            	    	changeText(bn0,bn1,bn2,bn3,bn4,arg0);
            	    }
        		});
    }
    
    
	@SuppressWarnings("deprecation")
	private View getView(String string, Intent intent) 
	{
		// TODO Auto-generated method stub
		return manager.startActivity(string, intent).getDecorView();
	}

	//ҳ�淭ת����
	@SuppressWarnings("deprecation")
	public void changeText(Button bn1,Button bn2,Button bn3,Button bn4,Button bn5,int count)
	{
		switch(count)
		{
			case 0:
			{
				bn1.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.gray));
				bn2.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn3.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn4.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn5.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn1.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti));
				bn2.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn3.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn4.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn5.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn1.setTextColor(Color.RED);
				
			}break;
			case 1:
			{
				bn2.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.gray));
				bn1.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));	
				bn3.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn4.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn5.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn2.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti));
				bn1.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn3.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn4.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn5.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn2.setTextColor(Color.RED);
			}break;
			case 2:
			{
				bn3.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.gray));
				bn1.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));	
				bn2.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn4.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn5.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn3.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti));
				bn2.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn1.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn4.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn5.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn3.setTextColor(Color.RED);
			}break;
			case 3:
			{
				bn4.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.gray));
				bn3.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn1.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));	
				bn2.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn5.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn4.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti));
				bn3.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn2.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn1.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn5.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn4.setTextColor(Color.RED);
			}break;
			case 4:
			{
				bn5.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.gray));
				bn4.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn3.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn1.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));	
				bn2.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.title));
				bn5.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti));
				bn4.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn3.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn2.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn1.setTextColor(MainActivity.this.getResources().getColor(R.color.ziti1));
				bn5.setTextColor(Color.RED);
			}break;
		}
		m_vp.setCurrentItem(count);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	// ���뺬��search view�Ĳ˵�   
        MenuInflater inflater = getMenuInflater();   
        inflater.inflate(R.menu.main, menu);   
        // ��ȡSearchView����   
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();   
        if(searchView == null){    
            Log.d("SearchView","Fail to get Search View.");   
            return true;   
        }   
        searchView.setIconifiedByDefault(true); // ȱʡֵ����true�����ܲ�ר�Ž������ã�false��true��Ч��ͼ���£�true����������  
          
       // ��ȡ�������������    
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);   
        // searchable activity��component name���ɴ�ϵͳ��ͨ��intent���л���  
        ComponentName cn = new ComponentName(this,SearchResultActvity.class);   
        // ͨ����������������searchable activity�л�ȡ���������Ϣ������searchable��xml���á��������null����ʾ��activity�����ڣ����߲���searchable  
        SearchableInfo info = searchManager.getSearchableInfo(cn);   
        if(info == null){   
            Log.e("SearchableInfo","Fail to get search info.");   
        }        
        // ��searchable activity��������Ϣ��search view����  
        searchView.setSearchableInfo(info);   
      
        return true;
    }

    private void setUpSearchView(Menu menu) {
		// TODO Auto-generated method stub
		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
		//showInfo("searchView : " + searchView);
		if(searchView == null){
			showInfo("Fail to get Search View.");
			return;
		}
		searchView.setIconifiedByDefault(true);		
		
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		//showInfo("searchManager : " + searchManager);
		
	
		ComponentName cn = new ComponentName(this,SearchResultActvity.class);
		//showInfo("ComponentName : " + cn);
				
		
		SearchableInfo info = searchManager.getSearchableInfo(cn);
		if(info == null){
			showInfo("Fail to get search info.");
		}
		//showInfo(info.toString());
		searchView.setSearchableInfo(info);
	}
   
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    private void showInfo(String string) {
		// TODO Auto-generated method stub
		Log.d(getLocalClassName(),string);
	}
}
