package com.example.zt.util;

import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zhutao
 * @time 2022/2/14 10:47
 * @describe 工具类
 */
public class CommonUtil {
    /**
     * 获取当前进程名
     *
     * @return 进程名
     */
    @Nullable
    public static String getProcessName() {
        BufferedReader reader = null;
        try {
            File file = new File("/proc/" + android.os.Process.myPid() + "/cmdline");
            reader = new BufferedReader(new FileReader(file));
            return reader.readLine().trim();
        } catch (IOException e) {
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
