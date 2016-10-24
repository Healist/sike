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
    /*private String[] beans = new String[] { "���д��������", "ϵͳ�ݴ������", "���ɵ�·��΢����", "Ӳ������ϵ�ṹ", "�����Ӿ���ͼ����", "��ý������������", "��Ȼ���Դ���",  
            "������ֲ�ʽ����", "��Ϣ��ȫ����Ӧ��", "�˹�������ģʽʶ��", "���ݿ�������ݴ���", "CAD��CG", "�������" };*/
    private String[] beans ;
  
  //��ȡ������json�Ľ��
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
  	        				Log.d("Error!!!", "û�л�ȡ��json���ݻ�������Ϊ�գ�");
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
					Bundle b = new Bundle();//�������
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
