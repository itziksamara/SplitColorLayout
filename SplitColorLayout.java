package com.reali.app.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;


/**
 * Created by Itzik Samara on 19/04/2016.
 */
public class SplitColorLayout extends FrameLayout
{

    private int mTopColor;
    private int mBottomColor;

    public SplitColorLayout(Context context)
    {
        super(context);

    }

    public SplitColorLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs);
    }

    public SplitColorLayout(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs)
    {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SplitColorLayout);


        mTopColor = a.getColor(R.styleable.SplitColorLayout_SplitColorLayout_TopColor, context.getResources().getColor(R.color.white));
        mBottomColor = a.getColor(R.styleable.SplitColorLayout_SplitColorLayout_BottomColor, context.getResources().getColor(R.color.white));
        a.recycle();

    }

    @Override
    protected void dispatchDraw(Canvas canvas)
    {
        int center = (getTop() + getBottom()) / 2;
        Rect topRect = new Rect(getLeft(), getTop(), getRight(), center);
        Rect bottomRect = new Rect(getLeft(), center, getRight(), getBottom());

        Paint paint = new Paint();
        paint.setColor(mTopColor);

        canvas.drawRect(topRect, paint);
        paint.setColor(mBottomColor);
        canvas.drawRect(bottomRect, paint);

        super.dispatchDraw(canvas);

    }

    public void setTopColor(int color)
    {
        mBottomColor = color;
    }

    public void setBottomColor(int color)
    {
        mTopColor = color;
    }


}
