package com.example.liuyuhao.wechatmoments.Domain;

import android.graphics.drawable.Drawable;
import android.util.LruCache;

import com.example.liuyuhao.wechatmoments.Data.Callback;
import com.example.liuyuhao.wechatmoments.Data.ImageStorage;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageLoader {
    private ImageStorage storage;
    private static ImageLoader loader;
    public static ImageLoader getInstance(){
        if(loader == null) loader = new ImageLoader();
        return loader;
    }
    private ImageLoader(){
        if(storage == null) storage = ImageStorage.getInstance();
    }

    public void getImage(final String urlStr, final Callback<Drawable> callback){
        Drawable d = storage.get(urlStr);
        if (d!= null) {
            callback.onSuccess(d);
        }else {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    downloadImage(urlStr);
                    callback.onSuccess(storage.get(urlStr));
                }
            });
            t.start();
        }
    }
    private void downloadImage(String urlStr){
        URL url = null;
        try {
            url = new URL(urlStr);
            DataInputStream dataInputStream = null;
            dataInputStream = new DataInputStream(url.openStream());
            Drawable d = Drawable.createFromStream(dataInputStream,"image.jpg");
            if(storage.get(urlStr)==null) storage.put(urlStr, d);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
