package com.example.taozhu5.androidbaseknowledgetest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.taozhu5.androidbaseknowledgetest.base.BaseMvpActivity;
import com.example.taozhu5.androidbaseknowledgetest.base.MyLogUtil;

import java.util.ArrayList;
import java.util.List;

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
        rvContainer.setAdapter(mRecyclerViewAdapter);
    }

    @Override
    public void initEvent() {

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