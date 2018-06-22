package com.example.liuyuhao.wechatmoments.Data;

import android.graphics.drawable.Drawable;
import android.util.LruCache;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageLoader {
    LruCache<String, Drawable> cache;
    public ImageLoader(){
        cache = new LruCache<>((int)(Runtime.getRuntime().maxMemory())/8);
    }
    public void getImage(final String urlStr, final Callback<Drawable> callback){
        Drawable d = cache.get(urlStr);
        if (d!= null) {
            callback.onSuccess(d);
        }else {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    downloadImage(urlStr);
                    callback.onSuccess(cache.get(urlStr));
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
            cache.put(urlStr, d);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
