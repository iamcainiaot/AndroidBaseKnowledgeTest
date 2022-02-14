package com.example.zt.base_android_knowledge;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author zhutao
 * @time 2021/12/7 14:02
 * @describe 计算RecycleView的高度，可用于解决问题的场景：
 * eg：recyclerView的布局设置高度为wrap_content，item布局设置也为wrap_content，当我们需要处理一个横向的RecyclerView的时候，
 * 会出现前面的几个item的高度比最后几个item的高度要低， 这种情况下会出现最后几个item展示不全的问题
 * 原因：RecyclerView在绘制的时候，由于展示出来的只有一部分，所以只自适应了屏幕外面的高度，这时候需要提前预知到所有item的高度 ，
 * 然后取最高的那个，设置为recyclerView的高度即可
 */
public class HeightAdaptationLinearLayoutManager extends LinearLayoutManager {

    private static final String TAG = "diyLinearLayoutManager";
    private RecyclerView mRecyclerView;
    private boolean mIsScroll;

    public HeightAdaptationLinearLayoutManager(Context context) {
        super(context);
    }

    public HeightAdaptationLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public HeightAdaptationLinearLayoutManager(Context context, int orientation, boolean reverseLayout,
                                               RecyclerView recyclerView) {
        super(context, orientation, reverseLayout);
        mRecyclerView = recyclerView;
    }

    public HeightAdaptationLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void scrollToPosition(int position) {
        Log.d(TAG, "scrollToPosition position : " + position);
        mIsScroll = true;
        super.scrollToPosition(position);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        Log.d(TAG, "smoothScrollToPosition position : " + position);
        super.smoothScrollToPosition(recyclerView, state, position);
    }

    @Override
    public void onMeasure(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int widthSpec, int heightSpec) {
        if (mIsScroll) {
            mIsScroll = false;
            return;
        }

        if (state.getItemCount() <= 0) {
            recycler.clear();
            super.onMeasure(recycler, state, widthSpec, heightSpec);
            return;
        }
        if (mRecyclerView == null || mRecyclerView.getAdapter() == null) {
            Log.e(TAG, " mRecyclerView == null ?   did you forget to init mRecyclerView ?" +
                    " or  recyclerView.getAdapter() == null  the recyclerView has not set adapter");
            return;
        }
        int itemCount = mRecyclerView.getAdapter().getItemCount();
        int maxHeight = 0;
        int totalWidth = 0;
        // 存在 IndexOutOfBoundsException 异常
        try {
            int i = 0;
            while (i < itemCount) {
                View view = recycler.getViewForPosition(i);
                // 主动测量子item
                measureChild(view, widthSpec, heightSpec);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                if (marginLayoutParams == null) {
                    Log.e(TAG, "marginLayoutParams == null");
                    return;
                }
                totalWidth += view.getMeasuredWidth();
                // maxHeight = 上方margin + 下方margin + view自身的高度
                maxHeight = Math.max(maxHeight, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + view.getMeasuredHeight());
                Log.d(TAG, " topMargin = " + marginLayoutParams.topMargin +
                        "    bottomMargin = " + marginLayoutParams.bottomMargin +
                        "   view.getMeasuredHeight() = " + view.getMeasuredHeight() +
                        "   maxHeight = " + maxHeight +
                        "   totalWidth = " + totalWidth
                );
                setMeasuredDimension(totalWidth, maxHeight);
                i++;
            }
        } catch (Exception e) {
            Log.e(TAG, "throw IndexOutOfBoundsException from recycler.getViewForPosition " + e.toString());
            return;
        }
        mRecyclerView.setMinimumHeight(maxHeight);
    }
}