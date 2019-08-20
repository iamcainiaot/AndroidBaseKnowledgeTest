package com.example.taozhu5.baseklg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.*;
import android.media.Image;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * @author taozhu5
 * @date 2019/7/17 15:37
 * @description 环形饼图
 */
public class PieView extends View {

    /**
     * 优秀、良好、合格、不合格的几种颜色
     */
    private int youXiuColor;
    private int liangHaoColor;
    private int heGeColor;
    private int buHeGeColor;

    public void setData(float youXiu, float liangHao, float heGe, float buHeGe) {
        this.youXiu = youXiu;
        this.liangHao = liangHao;
        this.heGe = heGe;
        this.buHeGe = buHeGe;
    }

    /**
     * 优秀、良好、合格、不合格的几种人数
     */
    private float youXiu;
    private float liangHao;
    private float heGe;
    private float buHeGe;

    private Paint mPaint;
    private RectF mRectF;

    private Context mContext;

    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PieViewAttrs);
        if (attrs != null) {
            youXiuColor = typedArray.getColor(R.styleable.PieViewAttrs_YouXiu, 0);
            liangHaoColor = typedArray.getColor(R.styleable.PieViewAttrs_LiangHao, 0);
            heGeColor = typedArray.getColor(R.styleable.PieViewAttrs_HeGe, 0);
            buHeGeColor = typedArray.getColor(R.styleable.PieViewAttrs_BuHeGe, 0);
        }
        mPaint = new Paint();
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        // 线的宽度
        int strokeWidth = 1;
        mPaint.setStrokeWidth(strokeWidth);
        // 抗锯齿
        mPaint.setAntiAlias(true);
        /*
         * Paint.Style.FILL：填充内部
         * Paint.Style.FILL_AND_STROKE  ：填充内部和描边
         * Paint.Style.STROKE  ：描边
         */
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        mRectF = new RectF();
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //定义半径
        float radius;
        float left;
        float top;
        float right;
        float bottom;

        radius = getHeight() / 2;
        left = getWidth() / 2 - radius;
        top = getHeight() / 2 - radius;
        right = getWidth() / 2 + radius;
        bottom = getHeight() / 2 + radius;

        mRectF.set(left, top, right, bottom);
        float sum = youXiu + liangHao + heGe + buHeGe;
        float youXiuPercent = youXiu / sum;
        float liangHaoPercent = liangHao / sum;
        float heGePercent = heGe / sum;
        float buHeGePercent = buHeGe / sum;

        // 画扇面
        mPaint.setColor(youXiuColor);
        // 这里加一个270的意思是，从正中间开始
        canvas.drawArc(mRectF, 270, youXiuPercent * 360,
                true, mPaint);

        // 画扇面
        mPaint.setColor(liangHaoColor);
        canvas.drawArc(mRectF, 270 + youXiuPercent * 360,
                liangHaoPercent * 360, true, mPaint);

        // 画扇面
        mPaint.setColor(heGeColor);
        canvas.drawArc(mRectF, 270 + (youXiuPercent + liangHaoPercent) * 360,
                heGePercent * 360, true, mPaint);

        // 画扇面
        mPaint.setColor(buHeGeColor);
        canvas.drawArc(mRectF, 270 + (youXiuPercent + liangHaoPercent + heGePercent) * 360,
                buHeGePercent * 360, true, mPaint);

        // 画中间的圆形空白区域
        mPaint.setColor(mContext.getColor(R.color.white));
        int boardDpWidth = 23;
        float boardPxWidth = dp2px(boardDpWidth);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius - boardPxWidth, mPaint);
    }

    /**
     * dp 2 px
     *
     * @param dpVal dp值
     */
    protected int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, getResources().getDisplayMetrics());
    }
}