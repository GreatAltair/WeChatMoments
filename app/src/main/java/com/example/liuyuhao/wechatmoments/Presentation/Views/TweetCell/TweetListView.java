package com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ListView;
import android.widget.Toast;

import com.example.liuyuhao.wechatmoments.Data.Callback;

public class TweetListView extends ListView {
    private static final float FLEX_RATE = 0.4f;

    private Callback<Boolean> listener;

    public TweetListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setOnTouchListener(new View.OnTouchListener() {
            float y;
            int offset = -100000;
            @Override
            public boolean onTouch(final View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        y = motionEvent.getY();
                        offset = getScrollDistanceY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if(offset == -100000) {
                            y = motionEvent.getY();
                            offset = getScrollDistanceY();
                        }
                        int distance = (int) ((view.getY() + (motionEvent.getY() - y)) - offset);
                        if(distance >= 0)
                            setTranslationY( (distance * FLEX_RATE));
                        break;
                    case MotionEvent.ACTION_UP:
                        if((view.getY() + (motionEvent.getY() - y)) - offset >300.0f){
                            RefreshThread t = new RefreshThread(new Runnable() {
                                @Override
                                public void run() {
                                    if(listener != null) listener.onSuccess(true);
                                    ((Activity)getContext()).runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            ResetAnimation animation = new ResetAnimation(view);
                                            animation.setDuration(600);
                                            view.startAnimation(animation);
                                        }
                                    });
                                }
                            });
                            t.start();
                        }else {
                            ResetAnimation animation = new ResetAnimation(view);
                            animation.setDuration(600);
                            view.startAnimation(animation);
                        }

                        y = 0.0f;
                        offset = -100000;
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                        case MotionEvent.ACTION_POINTER_DOWN:
                }
                return false;
            }
        });
    }

    public int getScrollDistanceY() {
        View c = getChildAt(0);
        if (c == null) {
            return 0;
        }
        int firstVisiblePosition = getFirstVisiblePosition();
        int top = c.getTop();
        return -top + firstVisiblePosition * c.getHeight() ;
    }

    class ResetAnimation extends Animation {
        View view ;
        public ResetAnimation(View view){
            this.view = view;
        }
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            view.setTranslationY(view.getTranslationY() * (1 - interpolatedTime/1.0f));
        }
    }

    public void setDrapRefresh(Callback callback){
        this.listener = callback;
    }

    class RefreshThread extends Thread{
        public RefreshThread(Runnable r){
            super(r);
        }
    }
}
