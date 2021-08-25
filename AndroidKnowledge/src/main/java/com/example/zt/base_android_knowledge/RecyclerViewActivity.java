package com.example.zt.base_android_knowledge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.activity_launch_mode.LaunchModeFirstActivity;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;
import com.example.zt.base_android_knowledge.base.MyLogUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taozhu5
 * @date 2019/8/16 16:05
 * @description RecyclerView缓存机制（自定义缓存，有难度，尚未实现）
 */
public class RecyclerViewActivity extends BaseMvpActivity {
    private static final String TAG = "RecyclerViewActivity";

    /**
     * 启动此页面
     *
     * @param context 上下文
     */
    public static void start(Context context) {
        Intent intent = new Intent(context, RecyclerViewActivity.class);
        context.startActivity(intent);
    }

    private Context mContext;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    public int layoutId() {
        return R.layout.activity_recycler_view;
    }

    @Override
    public void initData() {
        // do nothing
    }

    @Override
    public void initView() {
        mContext = this;
        RecyclerView rvContainer = $(R.id.rv_container);
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (i < 100) {
            list.add(i);
            i++;
        }

        if (mRecyclerViewAdapter == null) {
            mRecyclerViewAdapter = new RecyclerViewAdapter(list);
        }
        rvContainer.addItemDecoration(new SimplePaddingDecoration(this));
        rvContainer.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rvContainer.setAdapter(mRecyclerViewAdapter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            rvContainer.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
                        MyLogUtil.d(TAG, "View " + v + " scrollX " + scrollX + "scrollY " + scrollY +
                                "oldScrollX " + oldScrollX + " oldScrollY " + oldScrollY);
                    }
            );
            rvContainer.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    // 静止状态 0   手动拖着滑  1   滑动状态  2
                    MyLogUtil.d(TAG, "newState  " + newState);

                    rvContainer.getChildCount();
                    int getBottom = rvContainer.getBottom();
                    int getTop = rvContainer.getTop();
                    int getLeft = rvContainer.getLeft();
                    int getRight = rvContainer.getRight();
                    MyLogUtil.d(TAG, "getTop  " + getTop + "   getLeft " + getLeft);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary)); //设置状态栏颜色（底色），
                        getWindow().getDecorView()
                                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//实现状态栏图标和文字颜色为黑色,看其他文章，说只有黑色和白色
                    }

                }

                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    MyLogUtil.d(TAG, "dx  " + dx + "   dy " + dy);

                    MyLogUtil.d(TAG, "rv.computeVerticalScrollOffset()  " + rvContainer.computeVerticalScrollOffset());
                    super.onScrolled(rvContainer, dx, dy);
                }
            });
        }

        LaunchModeFirstActivity launchModeFirstActivity;
        Object launchModeSecondActivityConstructor;

        // 通过反射创建对象

        try {
            launchModeFirstActivity = LaunchModeFirstActivity.class.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        // 通过 Constructor 创建对象
        try {
            Constructor constructor = LaunchModeFirstActivity.class.getConstructor();
            try {
                launchModeSecondActivityConstructor = constructor.newInstance();
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initEvent() {

    }

    /**
     * 分割线
     */
    class SimplePaddingDecoration extends RecyclerView.ItemDecoration {

        private int dividerHeight;


        public SimplePaddingDecoration(Context context) {
            dividerHeight = context.getResources().getDimensionPixelSize(R.dimen.dimen_2);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.bottom = dividerHeight;//类似加了一个bottom padding
        }
    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemHolder> {
        private List<Integer> list;

        RecyclerViewAdapter(List<Integer> list) {
            this.list = list;
        }

        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            // MyLogUtil.d(TAG, "onCreateViewHolder：" + i);
            return new ItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recycler
                    , viewGroup, false));
        }

        @Override
        public int getItemViewType(int position) {
            return list.get(position) / 4;
        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int i) {
            // MyLogUtil.d(TAG, "onBindViewHolder：" + i);
            holder.bindData(i);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int position, @NonNull List<Object> payloads) {
            if (payloads.isEmpty()) {
                // payloads 为 空，说明是更新整个 ViewHolder
                onBindViewHolder(holder, position);
            } else {
                // payloads 不为空，这只更新需要更新的 View 即可。
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ItemHolder extends RecyclerView.ViewHolder {
            private TextView tvList;

            ItemHolder(@NonNull View itemView) {
                super(itemView);
                tvList = itemView.findViewById(R.id.tv_list);
            }

            void bindData(final int position) {
                // MyLogUtil.d(TAG, "bindData：" + position);
                tvList.setText(String.valueOf(list.get(position)));
            }
        }
    }
}