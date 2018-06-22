package com.example.liuyuhao.wechatmoments.Presentation.Main;

import android.content.DialogInterface;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liuyuhao.wechatmoments.R;

public class MainActivity extends AppCompatActivity {


    RelativeLayout mainLinear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().hide();

        /**
         * views initialize and bind listeners
         */
        //to enable mainScreen can be dropped down
//        mainLinear = (RelativeLayout)findViewById(R.id.linear_main);
//        mainLinear.setOnTouchListener(new View.OnTouchListener() {
//            private float y = 0.0f;
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        y = motionEvent.getY();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        view.setTranslationY((view.getY() + (motionEvent.getY() - y))/3);
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        y = 0.0f;
////                        view.setTranslationY(y);
//                        ResetAnimation animation = new ResetAnimation(view);
//                        animation.setDuration(1000);
//                        view.startAnimation(animation);
//                        break;
//                    case MotionEvent.ACTION_CANCEL:
//                        break;
//                }
//                return true;
//            }
//        });
        //to bind an OnClickListener to the profile image and the background image

    }

    class ResetAnimation extends Animation{
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
}
