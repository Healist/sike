package com.sike.myfocus;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.sike.R;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ListView;

public class myCityFocus extends Activity {
	
	private ListView listView;  
    private ListViewCityAdapter adapter;  
    /*private String[] beans = new String[] { "并行处理与计算", "系统容错与测试", "集成电路与微电子", "硬件与体系结构", "机器视觉与图像处理", "多媒体与语音处理", "自然语言处理",  
            "网络与分布式计算", "信息安全及其应用", "人工智能与模式识别", "数据库与大数据处理", "CAD与CG", "软件工程" };*/
    private String[] beans ;
  
  //获取服务器json的结果
  	String res = "";
  	private final OkHttpClient client = new OkHttpClient();
  	private final int UPDATE_TEXT = 1;
  	
  	private Handler mHandler = new Handler(){     
          public void handleMessage(Message msg) {  
              switch (msg.what) {  
  	            case UPDATE_TEXT:  
  	            	Bundle b = msg.getData();
  	            	String result = b.getString("json");
  	            	res = result;
  	                try {
  	        			JSONObject demoJson = new JSONObject(res);
  	        			JSONArray jsonList = demoJson.getJSONArray("cityList");
  	        			if(jsonList.length() == 0) {
  	        				Log.d("Error!!!", "没有获取到json数据或者数据为空！");
  	        				return;
  	        			} else {
  	        				beans = new String[jsonList.length()];
  		        			for(int i=0;i<jsonList.length();i++) {
  		        				JSONObject obj  =  jsonList.getJSONObject(i);
  		        				beans[i] = obj.getString("name");
  		        			}
  		        			listView = (ListView) findViewById(R.id.myFocus_listview);
  	  	        			adapter = new ListViewCityAdapter(myCityFocus.this, beans);
  	  	        			listView.setAdapter(adapter);
  		        	        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
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
    
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.focus_list);  
        getData();
    }  

    private String[] getData() {

	    new Thread(new Runnable(){
	    	@Override
	    	public void run() {
	    		Request request = new Request.Builder()
	            .url("http://itdodo.top/api2/city/list")
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
		
        return beans;
    }

}
