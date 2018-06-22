package com.example.liuyuhao.wechatmoments.Presentation.Views.TweetCell;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.liuyuhao.wechatmoments.Data.Callback;
import com.example.liuyuhao.wechatmoments.Domain.ImageLoader;
import com.example.liuyuhao.wechatmoments.Data.model.ImgListTweetModel;
import com.example.liuyuhao.wechatmoments.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImgListCell extends BaseCell implements Cell{
    public static final int COLUMS = 3;
    private static final int GRIDVIEW_WIDTH = 720;
    private static final int NETWORK_ERROR = 9999;
    private int columsCount = 0;

    private ImageLoader loader = ImageLoader.getInstance();

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what == NETWORK_ERROR) Toast.makeText(getContext(), "网络连接错误", Toast.LENGTH_SHORT).show();
        }
    };

    public ImgListCell(Context context, ImgListTweetModel model) {
        super(context, model);
        this.setOrientation(VERTICAL);

        columsCount = getColmusOfGridView(model.getImgUrls().size());

        LinearLayout expandArea = (LinearLayout) this.getChildAt(0).findViewById(R.id.expand_area);

        GridView gridView = new GridView(getContext());
        gridView.setVerticalSpacing(10);

        //计算行数
        int lineCount = model.getImgUrls().size() / columsCount;
        if(lineCount * columsCount < model.getImgUrls().size()) lineCount ++;
        gridView.setLayoutParams(new LayoutParams(GRIDVIEW_WIDTH,  (GRIDVIEW_WIDTH/columsCount * lineCount)));
        gridView.setNumColumns(columsCount);

//        gridView.setAdapter(new ImageAdapter(getContext(), model.getImgUrls()));
        List<HashMap<String, String>> data = new ArrayList<>();
        for(int i = 0; i < model.getImgUrls().size(); i++){
            HashMap<String, String> map = new HashMap<>();
            map.put("image", model.getImgUrls().get(i));
            data.add(map);
        }
        MyAdapter adapter = new MyAdapter(getContext(), data, R.layout.image_grid_item, new String[] {},new int[] {});
//        gridView.setAdapter(adapter);
        gridView.setAdapter(new ImageAdapter(getContext(), model.getImgUrls()));
        expandArea.addView(gridView);
    }

    /**
     * get the colmus of gridview
     */
    private int getColmusOfGridView(int count){
        if(count <= COLUMS) return count;
        else if(count == 4) return 2;
        else return 3;
    }
    class ImageAdapter extends BaseAdapter{
        List<String> urls;
        public ImageAdapter(Context context, List<String> urls){
            this.urls = urls;
        }
        @Override
        public int getCount() {
            return urls.size();
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
            ViewHolder vh;
            if(view == null){
                view = LayoutInflater.from(getContext()).inflate(R.layout.image_grid_item, null);
                vh = new ViewHolder();
                vh.img = (ImageView)view.findViewById(R.id.image_grid_img);
                view.setTag(vh);

            }

            vh = (ViewHolder) view.getTag();

            LayoutParams params = new LayoutParams(GRIDVIEW_WIDTH / columsCount - 10, GRIDVIEW_WIDTH/columsCount - 10);
            vh.img.setLayoutParams(params);
            vh.img.setBackgroundColor(Color.parseColor("#dddddd"));
            loadImage(vh.img, urls.get(i));

            return view;
        }
        class ViewHolder {
            ImageView img;
        }
    }

    class MyAdapter extends SimpleAdapter{
        List<HashMap<String, String>> data;
        public MyAdapter(Context context, List<HashMap<String, String>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            this.data = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);
            ImageView img = (ImageView)v.findViewById(R.id.image_grid_img);
            if(img.getTag() == null || (int)img.getTag() != 1){
                LayoutParams params = new LayoutParams(GRIDVIEW_WIDTH / columsCount - 10, GRIDVIEW_WIDTH/columsCount - 10);
                img.setLayoutParams(params);
                img.setBackgroundColor(Color.parseColor("#dddddd"));

                img.setTag(1);
                loadImage(img, data.get(position).get("image"));
//                img.setImageResource(R.drawable.test);
            }
            return v;
        }
    }
    private void loadImage(final ImageView img, String urlStr){
        loader.getImage(urlStr, new Callback<Drawable>() {
            @Override
            public void onSuccess(final Drawable data) {
                ((Activity)getContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        img.setImageDrawable(data);
                    }
                });
            }
            @Override
            public void onError(String error) {

            }
        });
    }
}
