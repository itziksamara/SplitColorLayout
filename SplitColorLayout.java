package application.sportm.com.sportm.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import application.sportm.com.sportm.R;


/**
 * Created by use on 19/04/2016.
 */
public class SplitColorLayout extends FrameLayout {

    private int mTopColor;
    private int mBottomColor;

    private View mTopView;
    private View mBottomView;

    public SplitColorLayout(Context context) {
        super(context);
        initViews(context);
    }

    public SplitColorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
        initViews(context);
    }

    public SplitColorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        initViews(context);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        mTopView.setBackgroundColor(mTopColor);
        mBottomView.setBackgroundColor(mBottomColor);
        super.dispatchDraw(canvas);


    }

    private void initViews(Context context) {

        View root = LayoutInflater.from(context).inflate(R.layout.view_split_color_layout, this, false);

        mTopView = root.findViewById(R.id.view_split_color_top);
        mBottomView = root.findViewById(R.id.view_split_color_bottom);
        addView(root);
    }


    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SplitColorLayout);


        mTopColor = a.getColor(R.styleable.SplitColorLayout_SplitColorLayout_TopColor,getResources().getColor(R.color.white));
        mBottomColor = a.getColor(R.styleable.SplitColorLayout_SplitColorLayout_BottomColor, getResources().getColor(R.color.white));
        a.recycle();

    }


    public void setTopColor(int color) {
        mTopColor = color;
    }

    public void setBottomColor(int color) {
        mBottomColor = color;
    }


}
