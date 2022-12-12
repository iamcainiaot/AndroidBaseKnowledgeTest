package com.example.zt.base_android_knowledge.file;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.provider.MediaStore;
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

    /**
     * 内部存储器内容观察者
     */
    private MediaContentObserver mInternalObserver;

    /**
     * 外部存储器内容观察者
     */
    private MediaContentObserver mExternalObserver;
    /**
     * 运行在 UI 线程的 Handler, 用于运行监听器回调
     */
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    @Override
    public void initView() {

        // 创建内容观察者
        mInternalObserver = new MediaContentObserver(MediaStore.Images.Media.INTERNAL_CONTENT_URI, mUiHandler);
        mExternalObserver = new MediaContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, mUiHandler);

        // 注册内容观察者
        getContentResolver().registerContentObserver(
                MediaStore.Images.Media.INTERNAL_CONTENT_URI,
                notifyForDescendants(),
                mInternalObserver
        );
        getContentResolver().registerContentObserver(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                notifyForDescendants(),
                mExternalObserver
        );
    }

    /**
     * android Q ContentObserver 不回调 onChange
     * 我们在注册 ContentObserver 时，会传两个重要的参数，Uri 和 notifyForDescendants，
     * 其中 Uri 就是系统发生变化的文件对应的 Uri，比如想监听系统图片变化，就使用 MediaStore.Images.Media.EXTERNAL_CONTENT_URI，
     * 第二个参数比较重要，大概意思就是是否要精确匹配 Uri，如果 false 代表要精确匹配，true 就不要
     *
     * @return
     */
    private boolean notifyForDescendants() {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.P;
    }

    @Override
    public void initEvent() {

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "zzzz onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * 媒体内容观察者(观察媒体数据库的改变)
     */
    private class MediaContentObserver extends ContentObserver {

        private Uri mContentUri;

        public MediaContentObserver(Uri contentUri, Handler handler) {
            super(handler);
            mContentUri = contentUri;
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            Log.d(TAG, "selfChange : " + selfChange);
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            super.onChange(selfChange, uri);
            Log.d(TAG, "selfChange : " + selfChange + "   uri : " + uri);
        }
    }
}
