package com.example.liuyuhao.wechatmoments.Presentation.Main.Fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.liuyuhao.wechatmoments.Data.model.BaseModel;
import com.example.liuyuhao.wechatmoments.Data.model.BaseTweetModel;
import com.example.liuyuhao.wechatmoments.Data.model.ImgListTweetModel;
import com.example.liuyuhao.wechatmoments.Data.model.TopModel;
import com.example.liuyuhao.wechatmoments.Domain.TweetDataHelper;
import com.example.liuyuhao.wechatmoments.Presentation.Main.MainActivity;
import com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell.BaseCell;
import com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell.Cell;
import com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell.ImgListCell;
import com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell.TopCell;
import com.example.liuyuhao.wechatmoments.R;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

public class ListFragment extends Fragment {

    public static final String COMFIRM = "选择相册";
    public static final String CANCEL = "取消";

    ListView lv_tweets;
    LinkedList<BaseModel> models, cache;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        lv_tweets = (ListView) v.findViewById(R.id.lv_tweets);
        TweetDataHelper helper = new TweetDataHelper();

        cache = helper.getTweets();
        models = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            models.add(cache.get(i));
        }

//        profileImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setPositiveButton(COMFIRM, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Intent intent = new Intent();
//                    }
//                }).setNegativeButton(CANCEL,null).show();
//            }
//        });

        final TweetAdapter adapter = new TweetAdapter(models);
        lv_tweets.setAdapter(adapter);
        lv_tweets.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                switch (i) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (absListView.getLastVisiblePosition() == (absListView.getCount() - 1)) {
                            int nowLength = models.size();
                            for(int j = nowLength; j < nowLength + 5; j++){
                                if(j < cache.size()) models.add(cache.get(j));
                                else break;
                            }
                            adapter.notifyDataSetChanged();
                        }
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });

        lv_tweets.setOnTouchListener(new View.OnTouchListener() {
            float y;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        y = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
//                        profileImage.setTranslationY((view.getY() + (motionEvent.getY() - y)));
//                        likename.setTranslationY((view.getY() + (motionEvent.getY() - y)));
                        break;
                    case MotionEvent.ACTION_UP:
                        y = 0.0f;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                }
                return false;
            }
        });
        return v;
    }

    class TweetAdapter extends BaseAdapter{
        LinkedList<BaseModel> data;
        public TweetAdapter(LinkedList<BaseModel> data){
            super();
            this.data = data;
        }
        @Override
        public int getCount() {
            return data.size();
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            Cell cell = null;
            if(data.get(i) instanceof ImgListTweetModel){
                cell = new ImgListCell(getContext(), (ImgListTweetModel) data.get(i));
                return (ImgListCell)cell;
            }
            else if(data.get(i) instanceof BaseTweetModel){
                cell = new BaseCell(getContext(), (BaseTweetModel) data.get(i));
                return (BaseCell)cell;
            }
            else if(data.get(i) instanceof TopModel){
                cell = new TopCell(getContext(), (TopModel) data.get(i));
                return (TopCell)cell;
            }
            return new View(getContext());
        }
    }
}
