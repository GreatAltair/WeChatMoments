package com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liuyuhao.wechatmoments.Data.model.BaseTweetModel;
import com.example.liuyuhao.wechatmoments.Data.model.Comment;
import com.example.liuyuhao.wechatmoments.R;

import java.util.List;

public class BaseCell extends LinearLayout implements Cell{
    ListView comments;
    public BaseCell(Context context, BaseTweetModel model){
        super(context, null);
        LayoutInflater mInflater = LayoutInflater.from(context);
        View myView = mInflater.inflate(R.layout.tweet_base, null);
        myView.setBackgroundColor(Color.parseColor("#ffffffff"));
        addView(myView);
        drawView(myView, model);
    }

    private void drawView(View myView, BaseTweetModel model) {
        TextView publisher = (TextView)myView.findViewById(R.id.tv_publisher);
        publisher.setText(model.getLikename());

        TextView content = (TextView)myView.findViewById(R.id.tv_content);
        content.setText(model.getContent());

        comments = (ListView)myView.findViewById(R.id.lv_comments);
        comments.setLayoutParams(new LayoutParams(comments.getLayoutParams().width, 60 * model.getComments().size()));
        comments.setDividerHeight(0);
        CommentsAdapter adapter = new CommentsAdapter(model.getComments());
        comments.setAdapter(adapter);
    }

    class CommentsAdapter extends BaseAdapter{
        List<Comment> data;
        public CommentsAdapter(List<Comment> data){
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
            ViewHolder holder = null;
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.comment_item, null);
                holder = new ViewHolder();
                holder.from = (TextView)view.findViewById(R.id.comment_from);
                holder.replyStr = (TextView)view.findViewById(R.id.comment_replystr);
                holder.reply = (TextView)view.findViewById(R.id.comment_reply);
                holder.content = (TextView)view.findViewById(R.id.comment_content);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.from.setText(data.get(i).getFrom());
            holder.from.setLayoutParams(new LayoutParams(holder.from.getLayoutParams().width, 60));
            String to = data.get(i).getTo();
            if(to == null || to.equals("")){
                holder.replyStr.setText("");
                holder.reply.setText("");
            }else {
                holder.replyStr.setText("回复");
                holder.reply.setText(to);
            }
            holder.content.setText("："+data.get(i).getCommentBody());
            return view;
        }
        class ViewHolder {
            TextView from;
            TextView replyStr;
            TextView reply;
            TextView content;
        }
    }
}
