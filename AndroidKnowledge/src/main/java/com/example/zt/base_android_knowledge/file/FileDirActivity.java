package com.example.zt.base_android_knowledge.file;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zt.android.knowledge.R;
import com.example.zt.base_android_knowledge.android_activity_for_result.ActivityManagerActivity11;
import com.example.zt.base_android_knowledge.base.BaseMvpActivity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zhutao
 * @time 2022/5/31 15:09
 * @describe 文件相关
 */
public class FileDirActivity extends BaseMvpActivity {
    /**
     * 启动此页面
     *
     * @param context 上下文
     */
    public static void start(Context context) {
        Intent intent = new Intent(context, FileDirActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int layoutId() {
        return R.layout.activity_file_dir;
    }

    @Override
    public void initData() {

        Log.d(TAG, "zt 1111 Environment.getDataDirectory() : " + Environment.getExternalStorageDirectory());
        Log.d(TAG, "zt 11111 getFilesDir() : " + getCacheDir().getAbsolutePath());


        Log.d(TAG, "zt Environment.getDataDirectory() : " + Environment.getDataDirectory().getAbsolutePath());
        Log.d(TAG, "zt getFilesDir() : " + getExternalFilesDir(null));
        Log.d(TAG, "zt getCacheDir() : " + getExternalCacheDir());
        Log.d(TAG, "zt getCacheDir()11 : " + getExternalCacheDir());
        Log.d(TAG, "zt getCacheDir()122 : " + getExternalCacheDirs());

        long dataTake = System.currentTimeMillis();
        String jpegName = getExternalFilesDir(null) + File.separator + "pic_" + dataTake + ".txt";
        try {
            FileOutputStream fout = new FileOutputStream(jpegName);
            BufferedOutputStream bos = new BufferedOutputStream(fout);
            byte[] bytes = new byte[1024];
            bos.write(bytes);
            bos.flush();
            bos.close();
            Log.d(TAG, "zt 写入成功  jpegName ： " + jpegName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void initEvent() {

    }
}
