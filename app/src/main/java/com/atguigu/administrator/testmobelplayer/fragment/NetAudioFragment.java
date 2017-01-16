package com.atguigu.administrator.testmobelplayer.fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.atguigu.administrator.testmobelplayer.R;
import com.atguigu.administrator.testmobelplayer.adapter.NetAudioFragmentAdapter;
import com.atguigu.administrator.testmobelplayer.base.BaseFragment;
import com.atguigu.administrator.testmobelplayer.bean.NetAudioBean;
import com.atguigu.administrator.testmobelplayer.utils.CacheUtils;
import com.atguigu.administrator.testmobelplayer.utils.Constant;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by XueRU on 2017/1/6.
 * 网络音频
 */

public class NetAudioFragment extends BaseFragment {

    private static final String TAG = NetAudioFragment.class.getSimpleName();
    @Bind(R.id.listview)
    ListView listview;
    @Bind(R.id.progressbar)
    ProgressBar progressbar;
    @Bind(R.id.tv_nomedia)
    TextView tvNomedia;
    private NetAudioFragmentAdapter myAdapter;
    private List<NetAudioBean.ListBean> datas;


    @Override
    public View initView() {
        Log.e("TAG","网络音频ui初始化了");
        View view = View.inflate(mContext, R.layout.fragment_net_audio, null);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void initData() {
        super.initData();
        Log.e("TAG","网络音频数据初始化了");

        String saveJson = CacheUtils.getString(mContext, Constant.NET_AUDIO_URL);
        if(!TextUtils.isEmpty(saveJson)){
            processData(saveJson);
        }

        getDataFromNet();


    }

    private void getDataFromNet() {
        RequestParams reques = new RequestParams(Constant.NET_AUDIO_URL);
        x.http().get(reques, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                CacheUtils.putString(mContext,Constant.NET_AUDIO_URL,result);
                LogUtil.e("onSuccess==" + result);
                processData(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("onError==" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("onCancelled==" + cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("onFinished==");
            }
        });

    }
    /**
     * 使用Gson解析json数据
     * @param json
     * @return
     */
    private NetAudioBean paraseJson(String json) {
        return new Gson().fromJson(json,NetAudioBean.class);
    }


    private void processData(String result) {
        NetAudioBean netAudioBean = paraseJson(result);
        LogUtil.e(netAudioBean.getList().get(0).getText()+"-----------");

        datas = netAudioBean.getList();

        if(datas != null && datas.size() >0){
            //有视频
            tvNomedia.setVisibility(View.GONE);
            //设置适配器
            myAdapter = new NetAudioFragmentAdapter(mContext,datas);
            listview.setAdapter(myAdapter);
        }else{
            //没有视频
            tvNomedia.setVisibility(View.VISIBLE);
        }

        progressbar.setVisibility(View.GONE);

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void onRefreshData() {
        super.onRefreshData();

    }
}
