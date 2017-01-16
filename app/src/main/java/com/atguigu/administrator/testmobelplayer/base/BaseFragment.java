package com.atguigu.administrator.testmobelplayer.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by XueRU on 2017/1/6.
 */

public abstract class BaseFragment extends Fragment {

    public Context mContent;

    /**
     * 当系统创建前BaseFragment类的时候回调该方法
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContent = getActivity();
    }

    /**
     * 当系统要创建Fragment视图的时候回调该方法
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 抽象方法  让孩子实现
     * @return
     */
    public abstract View initView();


    /**
     * 当activity创建成功的时候回调该方法
     * 初始化数据
     * 网络请求
     * 绑定数据
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 当子类需要：重写该方法
     * 联网请求
     * 绑定数据
     */
    public void initData(){
    }

    /**
     *
     * @param hidden  false:当前类显示
     *                 true：当前类隐藏
     */
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(! hidden){
            onRefreshData();
        }

    }

    /**
     * 当子类要刷新数据的时候重写该方法
     */
    public void onRefreshData() {
    }
}
