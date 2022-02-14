package com.example.zt.base_android_knowledge;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;
import com.example.zt.base_android_knowledge.base.MyLogUtil;

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

    RecyclerView mRvContainer;

    @Override
    public void initView() {
        mContext = this;
        mRvContainer = $(R.id.rv_container);
        int i = 0;
        List<String> list = new ArrayList<>();
        while (i < 20) {
            if (i > 16) {
                list.add("长长长长长长长长！！");
            } else {
                list.add("短短短");
            }
            i++;
        }

        if (mRecyclerViewAdapter == null) {
            mRecyclerViewAdapter = new RecyclerViewAdapter(list, mContext);
        }
        mRvContainer.addItemDecoration(new SimplePaddingDecoration(this));
        mRvContainer.setLayoutManager(new HeightAdaptationLinearLayoutManager(this, RecyclerView.HORIZONTAL, false, mRvContainer));
        mRvContainer.setAdapter(mRecyclerViewAdapter);
        mRvContainer.postDelayed(() -> mRvContainer.scrollToPosition(1), 1000);
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
        private List<String> list;
        private Context context;

        RecyclerViewAdapter(List<String> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @NonNull
        @Override
        public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            MyLogUtil.d(TAG, "onCreateViewHolder：" + i);
            // if (i == 0) {
            return new ItemHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler
                    , viewGroup, false));
            // } else {
            //     return new ItemHolder(LayoutInflater.from(context).inflate(R.layout.item_recycler_2
            //             , viewGroup, false));
            // }
        }

        // @Override
        //public int getItemViewType(int position) {
        // return (position & 1) == 1 ? 1 : 0;
        //}

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int i) {
            MyLogUtil.d(TAG, "onBindViewHolder：" + i);
            holder.bindData(i);
        }

        // @Override
        // public void onBindViewHolder(@NonNull ItemHolder holder, int position, @NonNull List<Object> payloads) {
        //     if (payloads.isEmpty()) {
        //         // payloads 为 空，说明是更新整个 ViewHolder
        //         onBindViewHolder(holder, position);
        //     } else {
        //         // payloads 不为空，这只更新需要更新的 View 即可。
        //     }
        // }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ItemHolder extends RecyclerView.ViewHolder {
            private TextView tvList;

            ItemHolder(@NonNull View itemView) {
                super(itemView);
                tvList = itemView.findViewById(R.id.tv_type_name);
            }

            void bindData(final int position) {
                tvList.setText(String.valueOf(list.get(position)));

            }
        }
    }

}