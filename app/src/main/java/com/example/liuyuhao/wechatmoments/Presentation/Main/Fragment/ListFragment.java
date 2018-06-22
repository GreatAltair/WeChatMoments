package com.example.liuyuhao.wechatmoments.Presentation.Main.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.liuyuhao.wechatmoments.Data.Callback;
import com.example.liuyuhao.wechatmoments.Data.model.BaseModel;
import com.example.liuyuhao.wechatmoments.Data.model.BaseTweetModel;
import com.example.liuyuhao.wechatmoments.Data.model.ImgListTweetModel;
import com.example.liuyuhao.wechatmoments.Data.model.TopModel;
import com.example.liuyuhao.wechatmoments.Domain.TweetDataLoader;
import com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell.BaseCell;
import com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell.Cell;
import com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell.ImgListCell;
import com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell.TopCell;
import com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell.TweetListView;
import com.example.liuyuhao.wechatmoments.R;

import java.util.LinkedList;

public class ListFragment extends Fragment {

    public static final String COMFIRM = "选择相册";
    public static final String CANCEL = "取消";

    TweetListView lv_tweets;
    LinkedList<BaseModel> models, cache;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        lv_tweets = (TweetListView) v.findViewById(R.id.lv_tweets);

        initData();
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

        final TweetAdapter adapter = new TweetAdapter();
        lv_tweets.setAdapter(adapter);
        lv_tweets.setDividerHeight(0);
        lv_tweets.setDrapRefresh(new Callback() {
            @Override
            public void onSuccess(Object data) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "refreshing", Toast.LENGTH_SHORT).show();
                        models = new LinkedList<>();
                        cache = new LinkedList<>();
                        cache.add(new TopModel());
                        adapter.notifyDataSetChanged();
                        initData();
                        adapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onError(String error) {

            }
        });
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


        return v;
    }

    private void initData() {
        TweetDataLoader helper = new TweetDataLoader();
        cache = helper.getTweets();
        models = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            models.add(cache.get(i));
        }

    }

    class TweetAdapter extends BaseAdapter{

        public TweetAdapter(){
            super();
        }
        @Override
        public int getCount() {
            return models.size();
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
            if(models.get(i) instanceof ImgListTweetModel){
                cell = new ImgListCell(getContext(), (ImgListTweetModel) models.get(i));
                return (ImgListCell)cell;
            }
            else if(models.get(i) instanceof BaseTweetModel){
                cell = new BaseCell(getContext(), (BaseTweetModel) models.get(i));
                return (BaseCell)cell;
            }
            else if(models.get(i) instanceof TopModel){
                cell = new TopCell(getContext(), (TopModel) models.get(i));
                return (TopCell)cell;
            }
            return new View(getContext());
        }
    }
}
