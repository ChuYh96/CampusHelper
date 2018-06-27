package com.example.campushelper.activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class WeekTitle extends View {

    //���浱ǰ������
    private int day;

    private Paint mPaint;

    private String[] days = {"һ", "��", "��", "��", "��", "��", "��"};

    public WeekTitle(Context context)
    {
        super(context);
    }

    public WeekTitle(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        day = 0;
        mPaint = new Paint();
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setCurrentDay(int day)
    {
        this.day = day;
    }

    public void onDraw(Canvas canvas)
    {
        //��õ�ǰView�Ŀ��
        int width = getWidth();
        int offset = width / 8;
        int currentPosition = offset;
        //����Ҫ���Ƶ�����
        mPaint.setTypeface(Typeface.create(Typeface.DEFAULT_BOLD, Typeface.BOLD));
        mPaint.setTextSize(20);
        mPaint.setColor(Color.rgb(0, 134, 139));
        for(int i = 0; i < 7 ; i++)
        {
            //Ȧ����ǰ������
            if( day == i)
            {
System.out.println("������ǰ������!");

            }
            canvas.drawText(days[i], currentPosition, 30, mPaint);
            currentPosition += offset;
        }
        //���ø���Ļ�ͼ����
        super.onDraw(canvas);
    }

}

