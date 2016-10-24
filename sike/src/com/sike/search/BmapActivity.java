package com.sike.search;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

public class BmapActivity extends Activity {
	@Override   
    protected void onCreate(Bundle savedInstanceState) {         
		doSearchQuery(getIntent());   
    }   
  
    @Override   
    protected void onNewIntent(Intent intent) {  //activity�����ö�  
        super.onNewIntent(intent);   
        doSearchQuery(intent);   
    }   
  
    // ��searchable activity�ĵ������Ǳ�׼��intent�����ǿ��Դ�intent�л�ȡ��Ϣ����Ҫ����������  
    private void doSearchQuery(Intent intent){    
        if(intent == null)   
            return;   
  
        String queryAction = intent.getAction();   
        if( Intent.ACTION_SEARCH.equals( intent.getAction())){  //�����ͨ��ACTION_SEARCH�����ã������ͨ����������   
            String queryString = intent.getStringExtra(SearchManager.QUERY); //��ȡ��������  
            
        }    
           
    }
}
