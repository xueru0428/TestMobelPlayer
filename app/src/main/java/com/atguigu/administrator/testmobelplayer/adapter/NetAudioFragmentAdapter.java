package com.atguigu.administrator.testmobelplayer.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.administrator.testmobelplayer.R;
import com.atguigu.administrator.testmobelplayer.base.BaseViewHolder;
import com.atguigu.administrator.testmobelplayer.bean.NetAudioBean;
import com.atguigu.administrator.testmobelplayer.utils.Utils;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

import static android.content.ContentValues.TAG;

/**
 * Created by XueRU on 2017/1/16.
 */

public class NetAudioFragmentAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<NetAudioBean.ListBean> datas;

    public NetAudioFragmentAdapter(Context mContext, List<NetAudioBean.ListBean> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    /**
     * 视频
     */
    private static final int TYPE_VIDEO = 0;

    /**
     * 图片
     */
    private static final int TYPE_IMAGE = 1;

    /**
     * 文字
     */
    private static final int TYPE_TEXT = 2;

    /**
     * GIF图片
     */
    private static final int TYPE_GIF = 3;


    /**
     * 软件推广
     */
    private static final int TYPE_AD = 4;


    @Override
    public int getCount() {
        return datas.size();

    }


    //返回总类型数据
    @Override
    public int getViewTypeCount() {
        return 5;
    }

    /**
     * 当前item是什么类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int itemViewType = -1;
        //根据位置，从列表中得到一个数据对象
        NetAudioBean.ListBean listBean = datas.get(position);
        String type = listBean.getType();//得到类型
        Log.e(TAG, "type===" + type);
        if ("video".equals(type)) {
            itemViewType = TYPE_VIDEO;
        } else if ("image".equals(type)) {
            itemViewType = TYPE_IMAGE;
        } else if ("text".equals(type)) {
            itemViewType = TYPE_TEXT;
        } else if ("gif".equals(type)) {
            itemViewType = TYPE_GIF;
        } else {
            itemViewType = TYPE_AD;//广播
        }
        return itemViewType;
    }


    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = initView(convertView, getItemViewType(position), datas.get(position));
        return convertView;
    }

    private View initView(View convertView, int itemViewType, NetAudioBean.ListBean mediaItem) {
       /* switch (itemViewType) {
            case TYPE_VIDEO://视频

                VideoHoder videoHoder;
                if (convertView == null) {
                    convertView = View.inflate(mContext, R.layout.all_video_item, null);
                    videoHoder = new VideoHoder(convertView);
                    convertView.setTag(videoHoder);
                } else {
                    videoHoder = (VideoHoder) convertView.getTag();
                }

                //设置数据
                videoHoder.setData(mediaItem);

                break;
            case TYPE_IMAGE://图片
                ImageHolder imageHolder;
                if (convertView == null) {
                    convertView = View.inflate(mContext, R.layout.all_image_item, null);
                    imageHolder = new ImageHolder(convertView);
                    convertView.setTag(imageHolder);
                } else {
                    imageHolder = (ImageHolder) convertView.getTag();
                }
                //设置数据
                imageHolder.setData(mediaItem);
                break;
            case TYPE_TEXT://文字

                TextHolder textHolder;
                if (convertView == null) {
                    convertView = View.inflate(mContext, R.layout.all_text_item, null);
                    textHolder = new TextHolder(convertView);

                    convertView.setTag(textHolder);
                } else {
                    textHolder = (TextHolder) convertView.getTag();
                }

                textHolder.setData(mediaItem);

                break;
            case TYPE_GIF://gif

                GifHolder gifHolder;
                if (convertView == null) {
                    convertView = View.inflate(mContext, R.layout.all_gif_item, null);
                    gifHolder = new GifHolder(convertView);

                    convertView.setTag(gifHolder);
                } else {
                    gifHolder = (GifHolder) convertView.getTag();
                }

                gifHolder.setData(mediaItem);

                break;
            case TYPE_AD://软件广告

                ADHolder adHolder;
                if (convertView == null) {
                    convertView = View.inflate(mContext, R.layout.all_ad_item, null);
                    adHolder = new ADHolder(convertView);
                    convertView.setTag(adHolder);
                } else {
                    adHolder = (ADHolder) convertView.getTag();
                }

                break;
        }*/
        return convertView;
    }

    class VideoHoder extends BaseViewHolder {

        Utils utils;
        TextView tvContext;
        JCVideoPlayerStandard jcvVideoplayer;
        TextView tvPlayNums;
        TextView tvVideoDuration;
        ImageView ivCommant;
        TextView tvCommantContext;

        VideoHoder(View convertView) {
            super(convertView);
            //中间公共部分 -所有的都有
            tvContext = (TextView) convertView.findViewById(R.id.tv_context);
            utils = new Utils();
            tvPlayNums = (TextView) convertView.findViewById(R.id.tv_play_nums);
            tvVideoDuration = (TextView) convertView.findViewById(R.id.tv_video_duration);
            ivCommant = (ImageView) convertView.findViewById(R.id.iv_commant);
            tvCommantContext = (TextView) convertView.findViewById(R.id.tv_commant_context);
            jcvVideoplayer = (JCVideoPlayerStandard) convertView.findViewById(R.id.jcv_videoplayer);
        }




    }
}
