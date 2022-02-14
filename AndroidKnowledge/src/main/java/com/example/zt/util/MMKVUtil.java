package com.example.zt.util;

import com.tencent.mmkv.MMKV;

import java.util.Set;

/**
 * 本地缓存帮助类
 * https://github.com/Tencent/MMKV
 * 新建缓存可以使用，旧数据使用的缓存暂时不需要改为MMKVUtil缓存
 * 如果需要修改，则要特别注意旧数据使用的业务逻辑，不能导致旧的业务逻辑不可用
 */
public class MMKVUtil {

    public static void setStringValue(String key, String value) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            kv.encode(key, value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getStringValue(String key) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeString(key);
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }



    public static String getStringValue(String key, String defaultValue) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeString(key, defaultValue);
        }catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }


    public static void setLongValue(String key, long value) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            kv.encode(key, value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long getLongValue(String key) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeLong(key);
        }catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static long getLongValue(String key, long defaultValue) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeLong(key, defaultValue);
        }catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static void setIntValue(String key, int value) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            kv.encode(key, value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getIntValue(String key) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeInt(key);
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getIntValue(String key, int defaultValue) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeInt(key, defaultValue);
        }catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static void setDoubleValue(String key, double value) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            kv.encode(key, value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double getDoubleValue(String key) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeDouble(key);
        }catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public static double getDoubleValue(String key, double defaultValue) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeDouble(key, defaultValue);
        }catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static void setFloatValue(String key, float value) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            kv.encode(key, value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static float getFloatValue(String key) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeFloat(key);
        }catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public static float getFloatValue(String key, float defaultValue) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeFloat(key, defaultValue);
        }catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static void setBooleanValue(String key, boolean value) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            kv.encode(key, value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean getBooleanValue(String key) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeBool(key);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean getBooleanValue(String key, boolean defValue) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeBool(key, defValue);
        }catch (Exception e) {
            e.printStackTrace();
            return defValue;
        }
    }

    public static void setSetValue(String key, Set<String> value) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            kv.encode(key, value);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Set<String> getSetValue(String key) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeStringSet(key);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Set<String> getSetValue(String key, Set<String> defaultValue) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.decodeStringSet(key, defaultValue);
        }catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static void clearAll() {
        try {
            MMKV kv = MMKV.defaultMMKV();
            kv.clearAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeKeyForValue(String key) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            kv.removeValueForKey(key);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean containsKey(String key) {
        try {
            MMKV kv = MMKV.defaultMMKV();
            return kv.containsKey(key);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
