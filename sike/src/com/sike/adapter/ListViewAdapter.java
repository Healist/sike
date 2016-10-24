package com.sike.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.sike.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewAdapter extends BaseAdapter {

	private List<Map<String, Object>> data;
    private int resource;
    private LayoutInflater inflater;

    private Map<String, Object> itemData;

    public ListViewAdapter(Context context,
    		List<Map<String, Object>> data, int resource) {
        // super(context, data, resource, from, to);
        this.data = data;
        this.resource = resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void refresh(List<Map<String, Object>> data) {
    	this.data = data;
    }
    
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 渲染每一个item的数据，每次上下滑动显示数据时都会调用此方法
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(resource, null);

        }
        // convertView.setTag("abc");
        itemData = data.get(position);
        TextView list_title = (TextView) convertView
                .findViewById(R.id.list_title);
        list_title.setText(itemData.get("title").toString());
        
        TextView list_author = (TextView) convertView
                .findViewById(R.id.list_author);
        list_author.setText(itemData.get("author").toString());
        
        TextView list_date = (TextView) convertView
                .findViewById(R.id.list_date);
        list_date.setText(itemData.get("date").toString());
        
        TextView content = (TextView) convertView
                .findViewById(R.id.content);
        content.setText(itemData.get("content").toString());
        
        TextView subject = (TextView) convertView
                .findViewById(R.id.subject);
        subject.setText(itemData.get("subject").toString());
        
        TextView city = (TextView) convertView
                .findViewById(R.id.city);
        city.setText(itemData.get("city").toString());

        return convertView;
    }

}
