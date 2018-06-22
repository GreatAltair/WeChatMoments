package com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.liuyuhao.wechatmoments.Data.model.BaseModel;
import com.example.liuyuhao.wechatmoments.R;

public class TopCell extends LinearLayout implements Cell{
    public TopCell(Context context,BaseModel model){
        super(context);
        View v = LayoutInflater.from(context).inflate(R.layout.top_view,null);
        this.addView(v);
    }
}
