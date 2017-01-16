package com.atguigu.administrator.testmobelplayer.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.administrator.testmobelplayer.base.BaseFragment;


/**
 * Created by XueRU on 2017/1/6.
 * 网络音频
 */

public class NetAudioFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        Log.e("TAG","网络音频ui初始化了");
        textView = new TextView(mContent);
        textView.setTextColor(Color.RED);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.e("TAG","网络音频数据初始化了");
        textView.setText("网络音频");
    }

    @Override
    public void onRefreshData() {
        super.onRefreshData();
        textView.setText("网络音频刷新了");
    }
}
