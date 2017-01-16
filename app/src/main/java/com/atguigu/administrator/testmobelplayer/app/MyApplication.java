package com.atguigu.administrator.testmobelplayer.app;

import android.app.Application;

import org.xutils.x;

/**
 * Created by XueRU on 2017/1/11.
 * 作用：代表整个软件
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);//是否输出Debug日志
    }

}
