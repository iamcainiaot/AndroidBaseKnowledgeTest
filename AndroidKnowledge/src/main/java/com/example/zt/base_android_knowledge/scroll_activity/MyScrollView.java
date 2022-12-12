package com.example.zt.base_android_knowledge.scroll_activity;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.recyclerview.widget.RecyclerView;

public class MyScrollView extends LinearLayout implements NestedScrollingParent2, NestedScrollingChild2 {
    public static final String TAG = "MyScrollView";
    /**
     * 当作父parent的时候的helper
     */
    private NestedScrollingParentHelper mNestedScrollingParentHelper;
    /**
     * 当作子view的时候的helper
     */
    private NestedScrollingChildHelper mNestedScrollingChildHelper;

    private View mTargetView;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onNestedFling(@NonNull View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(target, velocityX, velocityY, consumed);
    }

    /* NestedScrollingParent2 */

    /**
     * 即将开始嵌套滑动，此时嵌套滑动尚未开始，由子控件的 startNestedScroll 方法调用
     *
     * @param child  嵌套滑动对应的父类的子类(因为嵌套滑动对于的父控件不一定是一级就能找到的，可能挑了两级父控件的父控件，child的辈分>=target)
     * @param target 具体嵌套滑动的那个子类
     * @param axes   嵌套滑动支持的滚动方向
     * @param type   嵌套滑动的类型，有两种ViewCompat.TYPE_NON_TOUCH fling效果,ViewCompat.TYPE_TOUCH 手势滑动
     * @return true 表示此父类开始接受嵌套滑动，只有true时候，才会执行下面的 onNestedScrollAccepted 等操作
     */
    @Override
    public boolean onStartNestedScroll(@NonNull View child, @NonNull View target, int axes, int type) {
        mTargetView = target;
        Log.d(TAG, "Parent onStartNestedScroll  child" + child);
        return true;
    }

    /**
     * 当onStartNestedScroll返回为true时，也就是父控件接受嵌套滑动时，该方法才会调用
     *
     * @param child
     * @param target
     * @param axes
     * @param type
     */
    @Override
    public void onNestedScrollAccepted(@NonNull View child, @NonNull View target, int axes, int type) {
        Log.d(TAG, "Parent onNestedScrollAccepted type " + type);

    }

    /**
     * 停止滑动
     *
     * @param target
     * @param type   滑动类型，ViewCompat.TYPE_NON_TOUCH fling效果,ViewCompat.TYPE_TOUCH 手势滑动
     */
    @Override
    public void onStopNestedScroll(@NonNull View target, int type) {
        Log.d(TAG, "Parent onStopNestedScroll  type " + type);

    }

    /**
     * 在子控件开始滑动之前，会先调用父控件的此方法，由父控件先消耗一部分滑动距离，并且将消耗的距离存在consumed中，传递给子控件
     * 在嵌套滑动的子View未滑动之前
     * ，判断父view是否优先与子view处理(也就是父view可以先消耗，然后给子view消耗）
     *
     * @param target   具体嵌套滑动的那个子类
     * @param dx       水平方向嵌套滑动的子View想要变化的距离
     * @param dy       垂直方向嵌套滑动的子View想要变化的距离 dy<0向下滑动 dy>0 向上滑动
     * @param consumed 这个参数要我们在实现这个函数的时候指定，回头告诉子View当前父View消耗的距离
     * consumed[0] 水平消耗的距离，consumed[1] 垂直消耗的距离 好让子view做出相应的调整
     * @param type     滑动类型，ViewCompat.TYPE_NON_TOUCH fling效果,ViewCompat.TYPE_TOUCH 手势滑动
     */
    private int mHeight = 0;

    @Override
    public void onNestedPreScroll(@NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        mHeight = Math.max(mHeight + dy, 0);
        Log.d(TAG, "Parent mHeight  : " + mHeight);
        if (dy > 0) {
            if (mHeight > 150) {
                // 大于150时，就不给滑动父布局了
                consumed[1] = 0;
                stopNestedScroll();
                return;
            }
            // 向上滑动
            // 这时候父布局先滑动，即先消耗部分距离
            int oldScroll = getScrollY();
            scrollBy(0, dy);
            int newScroll = getScrollY();
            Log.d(TAG, "Parent onNestedPreScroll  newScroll: " + newScroll + "  oldScroll : " + oldScroll);
            consumed[1] = newScroll - oldScroll;
            if (mTargetView instanceof RecyclerView && !mTargetView.canScrollVertically(dy) && !canScrollVertically(dy)) {
                // 此时不给滑动了，消耗掉所有距离，不让子view去滑动
                consumed[1] = dy;
                ((RecyclerView) mTargetView).stopScroll();
                Log.d(TAG, " 向上滑：不给滑动拉");
            }
        } else {
            // recyclerView不能向下滑动时，此时滑动外层view
            if (!mTargetView.canScrollVertically(dy)) {
                // 向下滑动，此时整体
                int oldScroll = getScrollY();
                scrollBy(0, dy);
                int newScroll = getScrollY();
                Log.d(TAG, "Parent onNestedPreScroll  newScroll: " + newScroll + "  oldScroll : " + oldScroll);
                consumed[1] = newScroll - oldScroll;
            }
            if (mTargetView instanceof RecyclerView && !mTargetView.canScrollVertically(dy) && !canScrollVertically(dy)) {
                // 此时不给滑动了，消耗掉所有距离，不让子view去滑动
                // consumed[1] = dy;
                // ((RecyclerView) mTargetView).stopScroll();
                Log.d(TAG, " 向下滑 不给滑动拉");
            }
        }

    }

    /**
     * 在 onNestedPreScroll 中，父控件消耗一部分距离之后，剩余的再次给子控件，
     * 子控件消耗之后，如果还有剩余，则把剩余的再次还给父控件
     *
     * @param target       具体嵌套滑动的那个子类
     * @param dxConsumed   水平方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dyConsumed   垂直方向嵌套滑动的子控件滑动的距离(消耗的距离)
     * @param dxUnconsumed 水平方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     * @param dyUnconsumed 垂直方向嵌套滑动的子控件未滑动的距离(未消耗的距离)
     * @param type         滑动类型，ViewCompat.TYPE_NON_TOUCH fling效果,ViewCompat.TYPE_TOUCH 手势滑动
     */
    @Override
    public void onNestedScroll(@NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        Log.d(TAG, "Parent onNestedScroll dxConsumed : " + dxConsumed + " 消耗掉的距离 dyConsumed : " + dyConsumed
                + "  dxUnconsumed : " + dxUnconsumed + "  dyUnconsumed : " + dyUnconsumed + "  type : " + type);
    }

    /* NestedScrollingParent2 */


    /* NestedScrollingChild2 */

    /**
     * 开始滑动前调用，在惯性滑动和触摸滑动前都会进行调用，此方法一般在 onInterceptTouchEvent或者onTouch中，通知父类方法开始滑动
     * 会调用父类方法的 onStartNestedScroll onNestedScrollAccepted 两个方法
     *
     * @param axes 滑动方向
     * @param type 开始滑动的类型 the type of input which cause this scroll event
     * @return 有父视图并且开始滑动，则返回true 实际上就是看parent的 onStartNestedScroll 方法
     */
    @Override
    public boolean startNestedScroll(int axes, int type) {
        Log.d(TAG, "Child startNestedScroll type : " + type);
        return false;
    }

    /**
     * 子控件停止滑动，例如手指抬起，惯性滑动结束
     *
     * @param type 停止滑动的类型 TYPE_TOUCH，TYPE_NON_TOUCH
     */
    @Override
    public void stopNestedScroll(int type) {
        Log.d(TAG, "Child stopNestedScroll ");

    }

    /**
     * 判断是否有父View 支持嵌套滑动
     */
    @Override
    public boolean hasNestedScrollingParent(int type) {
        Log.d(TAG, "Child hasNestedScrollingParent ");
        return true;
    }

    /**
     * 在dispatchNestedPreScroll 之后进行调用
     * 当滑动的距离父控件消耗后，父控件将剩余的距离再次交个子控件，
     * 子控件再次消耗部分距离后，又继续将剩余的距离分发给父控件,由父控件判断是否消耗剩下的距离。
     * 如果四个消耗的距离都是0，则表示没有神可以消耗的了，会直接返回false，否则会调用父控件的
     * onNestedScroll 方法，父控件继续消耗剩余的距离
     * 会调用父控件的
     *
     * @param dxConsumed     水平方向嵌套滑动的子控件滑动的距离(消耗的距离)    dx<0 向右滑动 dx>0 向左滑动 （保持和 RecycleView 一致）
     * @param dyConsumed     垂直方向嵌套滑动的子控件滑动的距离(消耗的距离)    dy<0 向下滑动 dy>0 向上滑动 （保持和 RecycleView 一致）
     * @param dxUnconsumed   水平方向嵌套滑动的子控件未滑动的距离(未消耗的距离)dx<0 向右滑动 dx>0 向左滑动 （保持和 RecycleView 一致）
     * @param dyUnconsumed   垂直方向嵌套滑动的子控件未滑动的距离(未消耗的距离)dy<0 向下滑动 dy>0 向上滑动 （保持和 RecycleView 一致）
     * @param offsetInWindow 子控件在当前window的偏移量
     * @return 如果返回true, 表示父控件又继续消耗了
     */
    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, @Nullable int[] offsetInWindow, int type) {
        Log.d(TAG, "Child dispatchNestedScroll ");

        return false;
    }

    /**
     * 子控件在开始滑动前，通知父控件开始滑动，同时由父控件先消耗滑动时间
     * 在子View的onInterceptTouchEvent或者onTouch中，调用该方法通知父View滑动的距离
     * 最终会调用父view的 onNestedPreScroll 方法
     *
     * @param dx             水平方向嵌套滑动的子控件想要变化的距离 dx<0 向右滑动 dx>0 向左滑动 （保持和 RecycleView 一致）
     * @param dy             垂直方向嵌套滑动的子控件想要变化的距离 dy<0 向下滑动 dy>0 向上滑动 （保持和 RecycleView 一致）
     * @param consumed       父控件消耗的距离，父控件消耗完成之后，剩余的才会给子控件，子控件需要使用consumed来进行实际滑动距离的处理
     * @param offsetInWindow 子控件在当前window的偏移量
     * @param type           滑动类型，ViewCompat.TYPE_NON_TOUCH fling效果,ViewCompat.TYPE_TOUCH 手势滑动
     * @return true    表示父控件进行了滑动消耗，需要处理 consumed 的值，false表示父控件不对滑动距离进行消耗，可以不考虑consumed数据的处理，此时consumed中两个数据都应该为0
     */
    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, @Nullable int[] consumed, @Nullable int[] offsetInWindow, int type) {
        Log.d(TAG, "Child dispatchNestedPreScroll ");
        if (mTargetView instanceof RecyclerView) {
            ((RecyclerView) mTargetView).stopScroll();
        }
        return true;
    }
    /* NestedScrollingChild2 */

    @Override
    public void scrollTo(int x, int y) {
        // 说明可以滑动，否则不给滑动
        if (y < 0) {
            y = 0;
        }
        super.scrollTo(x, y);
    }
}