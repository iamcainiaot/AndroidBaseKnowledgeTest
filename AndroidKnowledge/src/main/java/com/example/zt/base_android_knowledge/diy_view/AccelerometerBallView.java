package com.example.zt.base_android_knowledge.diy_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.zt.android.knowledge.R;

/**
 * @author zhutao
 * @time 2021/6/28 16:27
 * @describe 重力感应 球
 */
public class AccelerometerBallView extends View implements SensorEventListener {
    private static final String TAG = "AccelerometerBallView";
    private final Matrix mMatrix = new Matrix();

    private SensorManager mSensorManager;

    private float mWidth = 0, mHeight = 0, mOldX = 0, mOldY = 0;
    private int mWidthPx, mHeightPx;
    private float mMoveHorizontalLength;
    private float mMoveVerticalLength;
    /**
     * 图片的顶点位置  x
     */
    private float mImageInitX;
    /**
     * 图片的初始位置  y
     */
    private float mImageInitY;

    private Bitmap mBitmap;

    private Paint mPaint;
    private Paint mTopPaint;
    private Paint mBottomPaint;
    private Paint mLeftPaint;
    private Paint mRightPaint;

    private Paint mTopPaintArc;
    private Paint mBottomPaintArc;
    private Paint mLeftPaintArc;
    private Paint mRightPaintArc;

    private float[] mGrayFloat;

    private RectF mLeftTopRectF;
    private RectF mLeftBottomRectF;
    private RectF mRightTopRectF;
    private RectF mRightBottomRectF;


    private int mColor;

    public AccelerometerBallView(@NonNull Context context) {
        super(context);
    }

    public AccelerometerBallView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AccelerometerBallView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs) {
        // 获取传感器manager
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        // 注册监听
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY),
                SensorManager.SENSOR_DELAY_GAME
        );
//        mWidthPx = DisplayUtils.dp2px(65);
//        mHeightPx = DisplayUtils.dp2px(70);
        mWidthPx = 65;
        mHeightPx = 70;
        // 小球的图片mipmap
        mBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(),
                R.mipmap.ic_launcher),
                mWidthPx,
                mHeightPx,
                true);

        mPaint = new Paint();
        mTopPaint = new Paint();
        mBottomPaint = new Paint();
        mLeftPaint = new Paint();
        mRightPaint = new Paint();

        mLeftTopRectF = new RectF();
        mLeftBottomRectF = new RectF();
        mRightTopRectF = new RectF();
        mRightBottomRectF = new RectF();

        mTopPaintArc = new Paint();
        mBottomPaintArc = new Paint();
        mLeftPaintArc = new Paint();
        mRightPaintArc = new Paint();

        drawFourLines();
    }

    private void drawFourLines() {
        initPaint();
        // 获取当前view的宽高
        float corner = 10;
        // startX, startY, stopX, stopY,  上 横线 下 横线  左 竖线  右竖线
        mGrayFloat = new float[]{corner, 0, mWidth - corner, 0,
                corner, mHeight, mWidth - corner, mHeight,
                0, corner, 0, mHeight - corner,
                mWidth, corner, mWidth, mHeight - corner};

        // 四个圆角的对象  width  879  height  656   corners  53
        float arcCorner = 20;

        float pivot = 1;
        mLeftTopRectF.set(pivot, pivot, arcCorner, arcCorner);
        mLeftBottomRectF.set(pivot, mHeight - arcCorner - pivot, arcCorner, mHeight - pivot);
        mRightTopRectF.set(mWidth - arcCorner - pivot, pivot, mWidth - pivot, arcCorner);
        mRightBottomRectF.set(mWidth - arcCorner - pivot, mHeight - arcCorner - pivot, mWidth - pivot, mHeight - pivot);

        mColor = getResources().getColor(R.color.colorAccent, null);
        invalidate();
    }

    private void initPaint() {
        int strokeWidth = 8;
        mPaint.setStrokeWidth(strokeWidth);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);

        mTopPaint.setStrokeWidth(strokeWidth);
        mTopPaint.setAntiAlias(true);
        mTopPaint.setStyle(Paint.Style.STROKE);
        mTopPaint.setStrokeCap(Paint.Cap.SQUARE);

        mBottomPaint.setStrokeWidth(strokeWidth);
        mBottomPaint.setAntiAlias(true);
        mBottomPaint.setStyle(Paint.Style.STROKE);
        mBottomPaint.setStrokeCap(Paint.Cap.SQUARE);

        mLeftPaint.setStrokeWidth(strokeWidth);
        mLeftPaint.setAntiAlias(true);
        mLeftPaint.setStyle(Paint.Style.STROKE);
        mLeftPaint.setStrokeCap(Paint.Cap.SQUARE);

        mRightPaint.setStrokeWidth(strokeWidth);
        mRightPaint.setAntiAlias(true);
        mRightPaint.setStyle(Paint.Style.STROKE);
        mRightPaint.setStrokeCap(Paint.Cap.SQUARE);

        mTopPaintArc.setStrokeWidth(4);
        mTopPaintArc.setAntiAlias(true);
        mTopPaintArc.setStyle(Paint.Style.STROKE);

        mBottomPaintArc.setStrokeWidth(4);
        mBottomPaintArc.setAntiAlias(true);
        mBottomPaintArc.setStyle(Paint.Style.STROKE);

        mLeftPaintArc.setStrokeWidth(4);
        mLeftPaintArc.setAntiAlias(true);
        mLeftPaintArc.setStyle(Paint.Style.STROKE);

        mRightPaintArc.setStrokeWidth(4);
        mRightPaintArc.setAntiAlias(true);
        mRightPaintArc.setStyle(Paint.Style.STROKE);

        mPaint.setColor(getResources().getColor(R.color.colorPrimary, null));
        mTopPaint.setColor(getResources().getColor(R.color.colorPrimary, null));
        mBottomPaint.setColor(getResources().getColor(R.color.colorPrimary, null));
        mLeftPaint.setColor(getResources().getColor(R.color.colorPrimary, null));
        mRightPaint.setColor(getResources().getColor(R.color.colorPrimary, null));
        mTopPaintArc.setColor(getResources().getColor(R.color.colorPrimary, null));
        mLeftPaintArc.setColor(getResources().getColor(R.color.colorPrimary, null));
        mBottomPaintArc.setColor(getResources().getColor(R.color.colorPrimary, null));
        mRightPaintArc.setColor(getResources().getColor(R.color.colorPrimary, null));
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() != Sensor.TYPE_GRAVITY) {
            return;
        }
        // 默认放平
        if (event.values[0] < 0.5 && -event.values[0] < 0.5 && event.values[1] < 0.5 && -event.values[1] < 0.5) {
            mMatrix.setTranslate(mImageInitX, mImageInitY);
            mMoveHorizontalLength = 0;
            mMoveVerticalLength = 0;
            mOldX = 0;
            mOldY = 0;
            invalidate();
            return;
        }

        // 小球横向移动
        mMoveHorizontalLength += mWidth * ((mOldX - event.values[0]) / 9);
        if (mMoveHorizontalLength + mImageInitX + mWidthPx >= mWidth) {
            mMoveHorizontalLength = mWidth - mImageInitX - mWidthPx;
            // 右边的线变绿
            mRightPaint.setColor(mColor);
            mRightPaintArc.setColor(mColor);
        } else if (mMoveHorizontalLength < -mImageInitX) {
            mMoveHorizontalLength = -mImageInitX;
            // 左边的线变绿
            mLeftPaint.setColor(mColor);
            mLeftPaintArc.setColor(mColor);
        }

        // 小球竖直移动
        mMoveVerticalLength += mHeight * ((mOldY - event.values[1]) / 9);
        if (mMoveVerticalLength >= mImageInitY) {
            mMoveVerticalLength = mImageInitY;
            // 上方的线变绿
            mTopPaint.setColor(mColor);
            mTopPaintArc.setColor(mColor);
        } else if (mMoveVerticalLength < -mImageInitY) {
            mMoveVerticalLength = -mImageInitY;
            // 下方的线变绿
            mBottomPaint.setColor(mColor);
            mBottomPaintArc.setColor(mColor);
        }

        Log.d(TAG, "mMoveHorizontalLength: " + mMoveHorizontalLength + "  mMoveVerticalLength"
                + mMoveVerticalLength + "mImageInitY: " + mImageInitY);
        // 若超过最大值，就给到最大值
        mMatrix.setTranslate(Math.min(mImageInitX + mMoveHorizontalLength, mWidth - mWidthPx),
                Math.min(mImageInitY - mMoveVerticalLength, mHeight - mHeightPx));

        // 保存传感器上次回调的值
        mOldX = event.values[0];
        mOldY = event.values[1];

        invalidate();
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // do nothing
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float rectPercent = (float) 1 / 8;
        // 画 左上角 圆角
        canvas.drawArc(mLeftTopRectF, 180, rectPercent * 360, false, mLeftPaintArc);
        // 画 左上角 圆角
        canvas.drawArc(mLeftTopRectF, 180 + rectPercent * 360, rectPercent * 360, false, mTopPaintArc);

        // 画 右上角 圆角
        canvas.drawArc(mRightTopRectF, 270, rectPercent * 360, false, mTopPaintArc);
        // 画 右上角 圆角
        canvas.drawArc(mRightTopRectF, 270 + rectPercent * 360, rectPercent * 360, false, mRightPaintArc);

        // 画 右下角 圆角
        canvas.drawArc(mRightBottomRectF, 360, rectPercent * 360, false, mRightPaintArc);
        // 画 右下角 圆角
        canvas.drawArc(mRightBottomRectF, 360 + rectPercent * 360, rectPercent * 360, false, mBottomPaintArc);

        // 画 左下角 圆角
        canvas.drawArc(mLeftBottomRectF, 90, rectPercent * 360, false, mBottomPaintArc);
        // 画 左下角 圆角
        canvas.drawArc(mLeftBottomRectF, 90 + rectPercent * 360, rectPercent * 360, false, mLeftPaintArc);

        // 上横线
        canvas.drawLine(mGrayFloat[0], mGrayFloat[1], mGrayFloat[2], mGrayFloat[3], mTopPaint);
        // 下横线
        canvas.drawLine(mGrayFloat[4], mGrayFloat[5], mGrayFloat[6], mGrayFloat[7], mBottomPaint);
        // 左竖线
        canvas.drawLine(mGrayFloat[8], mGrayFloat[9], mGrayFloat[10], mGrayFloat[11], mLeftPaint);
        // 右竖线
        canvas.drawLine(mGrayFloat[12], mGrayFloat[13], mGrayFloat[14], mGrayFloat[15], mRightPaint);

        canvas.drawBitmap(mBitmap, mMatrix, mPaint);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mSensorManager.unregisterListener(this);
        if (mBitmap != null) {
            mBitmap.recycle();
            mBitmap = null;
        }
    }
}

