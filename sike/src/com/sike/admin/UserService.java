package com.sike.admin;

import com.sike.database.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserService {

	private DatabaseHelper dbHelper;
	
    public UserService(Context context){
        dbHelper=new DatabaseHelper(context);
    }
    
    //��¼��
    public boolean login(String username,String password){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="select * from user where username=? and password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});        
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
    //ע����
    public boolean register(User user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="insert into user(username,password,email,subjectFocus,cityFocus) values(?,?,?,?,?)";
        Object obj[]={user.getUserName(),user.getPassword(),user.getEmail(),user.getSubjectFocus(),user.getCityFocus()};
        sdb.execSQL(sql, obj);    
        return true;
    }
    
  //������
    public boolean update(String focus,String account,int flag){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        if(flag == 1){
        	values.put("cityFocus", focus);
        	sdb.update("user", values, "username=?", new String[]{account});
        } else if(flag == 0){
        	values.put("subjectFocus", focus);
        	sdb.update("user", values, "username=?", new String[]{account});
        }
        return true;
    }
	
}
