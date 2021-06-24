package com.example.zt.base_android_knowledge.design_patterns.builder;

import android.app.AlertDialog;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author taozhu5
 * @date 2019/8/21 11:20
 * @description 描述
 */
public class AlertDialogBuilder extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createDialog();
    }

    /**
     * 创建一个Dialog，，，Builder模式
     */
    public void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("你好！")
                .setTitle("ss")
                .create();
    }
}