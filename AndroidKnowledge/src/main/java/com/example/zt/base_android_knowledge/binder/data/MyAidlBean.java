package com.example.zt.base_android_knowledge.binder.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author zhutao
 * @time 2022/2/14 14:13
 * @describe AIDL数据类
 */
public class MyAidlBean implements Parcelable {
    String name;
    String age;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public MyAidlBean(String name, String age) {
        this.name = name;
        this.age = age;
    }

    protected MyAidlBean(Parcel in) {
        name = in.readString();
        age = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MyAidlBean> CREATOR = new Creator<MyAidlBean>() {
        @Override
        public MyAidlBean createFromParcel(Parcel in) {
            return new MyAidlBean(in);
        }

        @Override
        public MyAidlBean[] newArray(int size) {
            return new MyAidlBean[size];
        }
    };

    @Override
    public String toString() {
        return "MyAidlBean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
