package com.sike.myfocus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.sike.R;
import com.sike.admin.UserService;
import com.sike.event.updateEvent;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import de.greenrobot.event.EventBus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("InflateParams") 
public class ListViewSubAdapter extends BaseAdapter {
	
	UserService uService;
	
	private Context context;  
    private String[] beans;  
    
    SharedPreferences pref;
    SharedPreferences.Editor editor;
  
    // 用来控制CheckBox的选中状况  
    private static HashMap<Integer, Boolean> isSelected;  
    private final OkHttpClient client = new OkHttpClient();
	private final int UPDATE_TEXT = 1;
	
	private Handler mHandler = new Handler(){     
		public void handleMessage(Message msg) {  
            switch (msg.what) {  
	            case UPDATE_TEXT:  
	            	Bundle b = msg.getData();
	            	String result = b.getString("json");
	                try {
	        			JSONObject demoJson = new JSONObject(result);
	        			String isSucceed = demoJson.getString("isOk");
	        			
	        			if(isSucceed.equals("ok")) {
	        				 //更新成功
	        			} else {
	        				//更新失败
	        				Toast.makeText(context, "更新失败了哦，请重试", Toast.LENGTH_SHORT).show();
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
  
    class ViewHolder {  
  
        TextView tvName;  
        CheckBox cb;  
    }  
  
    public ListViewSubAdapter(Context context, String[] beans) {  
        // TODO Auto-generated constructor stub  
        this.beans = beans;  
        this.context = context;  
        isSelected = new HashMap<Integer, Boolean>();  
        uService = new UserService(context);
        // 初始化数据  
        initDate();  
    }  
  
 // 初始化isSelected的数据  
    private void initDate() {  
    	
    	//从Sharedpreferences获取初始状态
        pref = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        String subjectFocus = pref.getString("subjectFocus", "");
        Log.d("subjectFocus",subjectFocus);
        String tmp[] = subjectFocus.split("\\|");
        List<String> tt = new ArrayList<>();
        int tp[]  =  new int[tmp.length];
        for(int i=0;i<tmp.length;i++){
        	if(tmp[i]!=null) {
        		tt.add(tmp[i]);
        	}
        }
        int size = tt.size();
    	String arr[] = (String[]) tt.toArray(new String[size]);
    	for (int i = 0; i < beans.length; i++) {  
            //初始化为false
        	getIsSelected().put(i, false);
        	for(int j=0;j<arr.length;j++) {
        		int num = i+1;
        		if(arr[j].equals(""+num)) {
        			getIsSelected().put(i, true);
        		}
        	}
        }  
    }  
  
    @Override  
    public int getCount() {  
        // TODO Auto-generated method stub  
        return beans.length;  
    }  
  
    @Override  
    public Object getItem(int position) {  
        // TODO Auto-generated method stub  
        return beans[position];  
    }  
  
    @Override  
    public long getItemId(int position) {  
        // TODO Auto-generated method stub  
        return position;  
    }  
  
    @Override  
    public View getView(final int position, View convertView, ViewGroup parent) {  
        // TODO Auto-generated method stub  
        // 页面  
        ViewHolder holder;  
        String bean = beans[position];  
        LayoutInflater inflater = LayoutInflater.from(context);  
        
        if (convertView == null) {  
            convertView = inflater.inflate(  
                    R.layout.focus_list_detail, null);  
            holder = new ViewHolder();  
            holder.cb = (CheckBox) convertView.findViewById(R.id.checkBox1);  
            holder.tvName = (TextView) convertView  
                    .findViewById(R.id.tv_device_name);  
            convertView.setTag(holder);  
        } else {  
            // 取出holder  
            holder = (ViewHolder) convertView.getTag();  
        }  
  
        holder.tvName.setText(bean);  
        // 监听checkBox并根据原来的状态来设置新的状态  
        holder.cb.setOnClickListener(new View.OnClickListener() {  
  
            public void onClick(View v) {  
  
            	//获取数据
            	pref = context.getSharedPreferences("user", Context.MODE_PRIVATE);
            	String subjectFocus = pref.getString("subjectFocus", "");
            	String account   = pref.getString("account", "");
            	Log.d("before", subjectFocus);
            	String tmp[] = subjectFocus.split("\\|");
                List<String> tt = new ArrayList<>();
                for(int i=0;i<tmp.length;i++){
                	if(tmp[i]!=null) {
                		tt.add(tmp[i]);
                	}
                }
                int size = tt.size();
            	String arr[] = (String[]) tt.toArray(new String[size]);
            	List<String> tt2 = new ArrayList<>();
            	editor = (Editor) context.getSharedPreferences("user", Context.MODE_PRIVATE).edit();
                if (isSelected.get(position)) {  
                	String res;
                    isSelected.put(position, false); 
                    Toast.makeText(context, "你取消关注了" + beans[position], Toast.LENGTH_SHORT).show();
                    for(int i=0;i<arr.length;i++){
                    	int num = position+1;
                    	if(!arr[i].equals(""+num)){
                    		tt2.add(arr[i]);
                    	}
                    }
                    int size2 = tt2.size();
                    if(size2 == 0){
                    	res = "";
                    	editor.putString("subjectFocus", res);
                        editor.commit();
                        updateSubjectFocus(account, res);
                        setIsSelected(isSelected);
                        return;
                    }
                    String t[] = (String[]) tt2.toArray(new String[size2]);
                    res = t[0];
                    for(int j=1;j<t.length;j++){
                    	res = res + "|" + t[j];
                    }
                    Log.d("result", res);
                    editor.putString("subjectFocus", res);
                    editor.commit();
                    updateSubjectFocus(account, res);
                    setIsSelected(isSelected);  
                } else {  
                    isSelected.put(position, true);  
                    Toast.makeText(context, "你关注了" + beans[position], Toast.LENGTH_SHORT).show();
                    String addSubjectFocus[] = new String[arr.length+1];
                    for(int i=0;i<arr.length;i++) {
                    	addSubjectFocus[i] = arr[i];
                    }
                    addSubjectFocus[arr.length] = position + 1 + "";
                    String res = addSubjectFocus[0];
                    for(int j=1;j<addSubjectFocus.length;j++){
                    	if(res.equals("")){
                    		res = res + addSubjectFocus[j];
                    	} else {
                    		res = res + "|" + addSubjectFocus[j];
                    	}
                    }
                    if(res.indexOf("|") == 0){
                    	res = res.substring(1, res.length());
                    }
                    Log.d("result", res);
                    editor.putString("subjectFocus", res);
                    editor.commit();
                    updateSubjectFocus(account, res);
                    setIsSelected(isSelected);
                }  
                
                EventBus.getDefault().post(new updateEvent("updateSubject"));
                
            }  
            
            private void updateSubjectFocus(final String account, String res) {
				//更新本地用户数据
            	Boolean isOk = uService.update(res, account, 1);
            	if(!isOk) {
            		Toast.makeText(context, "更新失败，请重试", Toast.LENGTH_SHORT).show();
            	} else {
            		editor.putString("subjectFocus", res);
            		editor.commit();
            		Log.d("update", "更新学科关注成功");
            	}
			}
            
        });  
  
        // 根据isSelected来设置checkbox的选中状况  
        holder.cb.setChecked(getIsSelected().get(position));  
        return convertView;  
    }  
  
    public static HashMap<Integer, Boolean> getIsSelected() {  
        return isSelected;  
    }  
  
    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {  
        ListViewSubAdapter.isSelected = isSelected;  
    }
}
