package com.example.liuyuhao.wechatmoments.Data;

import android.graphics.drawable.Drawable;
import android.util.LruCache;

public class ImageStorage {
    LruCache<String, Drawable> cache = new LruCache<>((int) ((Runtime.getRuntime().maxMemory())/8));
    private static ImageStorage storage;

    public static ImageStorage getInstance(){
        if(storage == null) storage = new ImageStorage();
        return storage;
    }

    public void put(String urlStr, Drawable drawable){
        cache.put(urlStr, drawable);
    }

    public Drawable get(String urlStr){
        return cache.get(urlStr);
    }
}
