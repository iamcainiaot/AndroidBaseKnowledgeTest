package com.example.taozhu5.androidbaseknowledgetest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.taozhu5.androidbaseknowledgetest.activity_launch_mode.LaunchModeFirstActivity;
import com.example.taozhu5.androidbaseknowledgetest.base.BaseMvpActivity;
import com.example.taozhu5.androidbaseknowledgetest.base.MyLogUtil;

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
        rvContainer.setAdapter(mRecyclerViewAdapter);
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
            MyLogUtil.d(TAG, "onCreateViewHolder：" + i);
            return new ItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recycler
                    , viewGroup, false));
        }

        @Override
        public int getItemViewType(int position) {
            if (list.get(position) / 4 == 1) {
                return 1;
            } else if (list.get(position) / 4 == 2) {
                return 2;
            } else if (list.get(position) / 4 == 3) {
                return 3;
            }
            return 4;
        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int i) {
            MyLogUtil.d(TAG, "onBindViewHolder：" + i);
            holder.bindData(i);
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
                MyLogUtil.d(TAG, "bindData：" + position);
                tvList.setText(String.valueOf(list.get(position)));
            }
        }
    }
}