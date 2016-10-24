package com.sike.adapter;

import java.util.List;
import java.util.Map;

import com.example.sike.R;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class settingAdapter extends BaseAdapter {

	private List<Map<String, Object>> data;
    private int resource;
    private LayoutInflater inflater;

    private Map<String, Object> itemData;

    public settingAdapter(Context context,
    		List<Map<String, Object>> data, int resource) {
        // super(context, data, resource, from, to);
        this.data = data;
        this.resource = resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                .findViewById(R.id.title);
        list_title.setText(itemData.get("title").toString());
        list_title.setTextColor(android.graphics.Color.BLACK);
        LinearLayout.LayoutParams layoutParams=
    		    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(50, 0, 0, 0);
        list_title.setLayoutParams(layoutParams);
        
        ImageView iv = (ImageView) convertView
                .findViewById(R.id.about_img);
        int i = Integer.parseInt(itemData.get("img").toString());
        iv.setImageResource(i);
        LinearLayout.LayoutParams layoutParams1=
    		    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams1.setMargins(20, 0, 0, 0);
        iv.setLayoutParams(layoutParams1);

        return convertView;
    }

}
