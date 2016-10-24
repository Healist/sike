package com.sike.recommend;

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
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import android.app.Activity;
import android.content.Intent;
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

public class recommendActivity extends Activity {

		//获取服务器json的结果
		String res = "";
		private final OkHttpClient client = new OkHttpClient();
		private final int UPDATE_TEXT = 1;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		
		private Handler mHandler = new Handler(){     
	        public void handleMessage(Message msg) {  
	            switch (msg.what) {  
		            case UPDATE_TEXT:  
		            	Bundle b = msg.getData();
		            	String result = b.getString("json");
		            	res = result;
		                try {
		        			JSONObject demoJson = new JSONObject(res);
		        			JSONArray jsonList = demoJson.getJSONArray("source");
		        			for(int i=0;i<jsonList.length();i++) {
		        				map = new HashMap<String, Object>();
		        				JSONObject obj  =  jsonList.getJSONObject(i);
		        				String sourceTitle  =  obj.getString("title");
		        				String sourceDate =  obj.getString("detail_date");
		        				String content =  obj.getString("content");
		        				String subject      =  obj.getString("subject");
		        				String city      =  obj.getString("city");
		        				String place     =  obj.getString("placeWhere");
		        				String author    =  obj.getString("author");
		        				author = "报告人" + "：" + author;
		        				sourceDate = "时间     " + "：" + sourceDate;
		        				city = "地点" + "：" + city;
		        				place = "位置     " + "：" + place;
		        				map.put("title", sourceTitle);
		        				map.put("date", sourceDate);
		        				map.put("img", R.drawable.collect);
		        				map.put("content", content);
		        				map.put("subject", subject);
		        				map.put("city", city);
		        				map.put("place", place);
		        				map.put("author", author);
		        				list.add(map);
		        			}
		        		} catch (JSONException e) {
		        			// TODO Auto-generated catch block
		        			e.printStackTrace();
		        		}
		                break;  
		            default:
		            	break;
	            }  
	        };  
	    }; 
		
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.list);

		    
			SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.listview,
	                new String[]{"title","date","img","content","subject","city","place","author"},
	                new int[]{R.id.list_title,R.id.list_date,R.id.img,R.id.content,R.id.subject,R.id.city,R.id.list_where,R.id.list_author});
			ListView lv = (ListView)recommendActivity.this.findViewById(R.id.listview);
	        lv.setAdapter(adapter); 
	        lv.setOnItemClickListener(
	        		new OnItemClickListener(){
						@Override
						public void onItemClick(AdapterView<?> parent, View view,
								int position, long id) {
							// TODO Auto-generated method stub
							LinearLayout ll = (LinearLayout)view;
							TextView tvn_title = (TextView)ll.findViewById(R.id.list_title);
							TextView tvn_date  = (TextView)ll.findViewById(R.id.list_date);
							TextView tvn_con   = (TextView)ll.findViewById(R.id.content);
							TextView tvn_sub   = (TextView)ll.findViewById(R.id.subject);
							TextView tvn_city   = (TextView)ll.findViewById(R.id.city);
							TextView tvn_author = (TextView)ll.findViewById(R.id.list_author);
							TextView tvn_place  = (TextView)ll.findViewById(R.id.list_where);
							ImageView   iv     = (ImageView)ll.findViewById(R.id.img);
//							StringBuilder sb = new StringBuilder();
//							sb.append(getResources().getText(R.string.ys));
//							sb.append(":");
//							sb.append(tvn_date.getText());
//							String stemp = sb.toString();
//							Toast.makeText(getApplicationContext(), stemp,
//								     Toast.LENGTH_SHORT).show(); 
							Intent intent = new Intent();
							Bundle b = new Bundle();
							//传递图片
							//iv.setDrawingCacheEnabled(Boolean.TRUE); 
							//intent.putExtra("bitmap", iv.getDrawingCache()); //这里可以放一个bitmap
							
							b.putString("title", tvn_title.getText().toString());
							intent.putExtras(b);
							b.putString("date", tvn_date.getText().toString());
							intent.putExtras(b);
							b.putString("content", tvn_con.getText().toString());
							intent.putExtras(b);
							b.putString("subject", tvn_sub.getText().toString());
							intent.putExtras(b);
							b.putString("city", tvn_city.getText().toString());
							intent.putExtras(b);
							b.putString("place", tvn_place.getText().toString());
							intent.putExtras(b);
							b.putString("author", tvn_author.getText().toString());
							intent.putExtras(b);
							b.putInt("position", position);
							intent.putExtras(b);
							intent.setClass(recommendActivity.this,detailActivity.class);
							startActivity(intent);
						}
	        		});
			
		}
		
		public void setRes(String val) {
			this.res = val;
			Log.d("val1", res);
		}
		
		public String getRes(){
			Log.d("val2", res);
			return res;
		}
		
		 private List<Map<String, Object>> getData() {

			String result = "";

		    new Thread(new Runnable(){
		    	@Override
		    	public void run() {
		    		Request request = new Request.Builder()
		            .url("http://itdodo.top/api2/source/1/10")
		            .build();
			   		 try {
						Response response = client.newCall(request).execute();
						Message msg = new Message();
						Bundle b = new Bundle();//存放数据
						b.putString("json", response.body().string());
						msg.setData(b);
						msg.what = UPDATE_TEXT;
						mHandler.sendMessage(msg);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}
		    }).start();

	        return list;
	    }
	
}
