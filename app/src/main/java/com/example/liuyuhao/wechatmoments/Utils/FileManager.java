package com.example.liuyuhao.wechatmoments.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class FileManager {
    HashMap<String, String> cacheForm;
    public FileManager(){
        cacheForm = new HashMap<>();
    }
    public String getCachePath(){
        StringBuilder path = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
        path.append("/Moments");
        openOrCreateDir(path.toString());
        path.append("/Cache");
        openOrCreateDir(path.toString());
        return path.toString();
    }

    private void openOrCreateDir(String path){
        File index = new File(path.toString());
        if(!index.exists()){
            index.mkdir();
        }
    }

    public void saveFileToCache(String name, Bitmap b){
        cacheForm.put(name, name.hashCode()+"");
        String path = getCachePath() + "/" + name.hashCode();
        try {
            File file = new File(path);
            file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);
            b.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bitmap getImage(String name){
        String path = getCachePath() + "/" + name.hashCode();
        Bitmap b = BitmapFactory.decodeFile(path);
        return b;
    }
}
