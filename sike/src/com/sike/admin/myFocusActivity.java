package com.sike.admin;

import java.util.ArrayList;

import com.example.sike.R;
import com.sike.myfocus.myCityFocus;
import com.sike.myfocus.mySubjectFocus;

import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressWarnings("deprecation")
public class myFocusActivity extends ActivityGroup {
	
	private ViewPager m_vp;//分页对象
	private LocalActivityManager manager=null;
	
	private ArrayList<View> list;//存放activity的列表
	
	@SuppressWarnings("unused")
	private boolean mIsEngineInitSuccess = false;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfocus); 
       
		//用自定义的字体方法
 	    //FontManager.changeFonts(FontManager.getContentView(this),this);
 	   
        manager=new LocalActivityManager(this,true);
        manager.dispatchCreate(savedInstanceState);
        
        m_vp=(ViewPager)myFocusActivity.this.findViewById(R.id.myfocus_viewpager);
        //获取Button对象
        final Button bn0= (Button) findViewById(R.id.myfocus_Button01);
        final Button bn1 = (Button) findViewById(R.id.myfocus_Button02);
        
        //默认开始选中第一个
        changeText(bn0,bn1,0);
        
        //设置监听
        bn0.setOnClickListener(
				new OnClickListener()
				{
					@Override
					public void onClick(View v) 
					{
						changeText(bn0,bn1,0);
					}
				});
        bn1.setOnClickListener(
				new OnClickListener()
				{
					@Override
					public void onClick(View v) 
					{
						changeText(bn0,bn1,1);
					}
				});
        
        //创建List对象
        list=new ArrayList<View>();
        Intent intent1=new Intent(this,myCityFocus.class);
        list.add(getView("myCityFocus",intent1));
        Intent intent2=new Intent(this,mySubjectFocus.class);
        list.add(getView("mySubjectFocus",intent2));
        
        //准备PagerAdapter适配器
        PagerAdapter fa=new PagerAdapter()
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
        //添加监听
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
            	    	changeText(bn0,bn1,arg0);
            	    }
        		});
    }
	private View getView(String string, Intent intent) 
	{
		// TODO Auto-generated method stub
		return manager.startActivity(string, intent).getDecorView();
	}

	//页面翻转方法
	public void changeText(Button bn1,Button bn2,int count)
	{
		switch(count)
		{
			case 0:
			{
				bn1.setBackgroundColor(myFocusActivity.this.getResources().getColor(R.color.gray));
				bn2.setBackgroundColor(myFocusActivity.this.getResources().getColor(R.color.title));
				bn1.setTextColor(myFocusActivity.this.getResources().getColor(R.color.ziti));
				bn2.setTextColor(myFocusActivity.this.getResources().getColor(R.color.ziti1));
			}break;
			case 1:
			{
				bn2.setBackgroundColor(myFocusActivity.this.getResources().getColor(R.color.gray));
				bn1.setBackgroundColor(myFocusActivity.this.getResources().getColor(R.color.title));	
				bn2.setTextColor(myFocusActivity.this.getResources().getColor(R.color.ziti));
				bn1.setTextColor(myFocusActivity.this.getResources().getColor(R.color.ziti1));
			}break;
			case 2:
			{
				bn1.setBackgroundColor(myFocusActivity.this.getResources().getColor(R.color.title));	
				bn2.setBackgroundColor(myFocusActivity.this.getResources().getColor(R.color.title));
				bn2.setTextColor(myFocusActivity.this.getResources().getColor(R.color.ziti1));
				bn1.setTextColor(myFocusActivity.this.getResources().getColor(R.color.ziti1));
			}break;
		}
		m_vp.setCurrentItem(count);
	}

}
