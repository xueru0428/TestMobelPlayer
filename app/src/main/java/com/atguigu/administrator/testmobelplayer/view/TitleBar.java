package com.atguigu.administrator.testmobelplayer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.administrator.testmobelplayer.R;

/**
 * Created by XueRU on 2017/1/16.
 */

public class TitleBar extends LinearLayout implements View.OnClickListener {
    private final Context mContent;
    private TextView tv_search;
    private RelativeLayout rl_game;
    private ImageView iv_record;
    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContent = context;
    }

    /**
     * 当布局加载完成后回调该方法
     * 得到孩子的实例
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tv_search = (TextView) getChildAt(1);
        rl_game = (RelativeLayout) getChildAt(2);
        iv_record = (ImageView) getChildAt(3);

        tv_search.setOnClickListener(this);
        rl_game.setOnClickListener(this);
        iv_record.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_search:
                Toast.makeText(mContent, "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_game:
                Toast.makeText(mContent, "游戏", Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_record:
                Toast.makeText(mContent, "记录", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
