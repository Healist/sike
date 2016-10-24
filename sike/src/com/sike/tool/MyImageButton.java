package com.sike.tool;

import com.example.sike.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.TextView;

public class MyImageButton extends ImageButton {

	private String text = null;  //Ҫ��ʾ������
    private int color;               //���ֵ���ɫ
    private TextView tv_layer;
    private RectF mRectF;  
	
	public MyImageButton(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public MyImageButton(Context context, AttributeSet attrs) {
        super(context,attrs);
    }

	public void setText(String text){
        this.text = text;       //��������
    }
      
    public void setColor(int color){
        this.color = color;    //����������ɫ
    }
    
    
      
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        Paint paint_rec = new Paint();
        paint_rec.setColor(Color.BLACK);
        paint_rec.setAlpha(100);
        mRectF = new RectF(0, 110, 200, 200);  
        canvas.drawRect(mRectF, paint_rec);  
        
        Paint paint=new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(Color.WHITE);
        paint.setTextSize(32);
        canvas.drawText(text, 82, 160, paint);  //��������
        
        
    }
}
