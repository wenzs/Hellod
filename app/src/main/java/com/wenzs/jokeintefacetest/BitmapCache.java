package com.wenzs.jokeintefacetest;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Administrator on 2016/6/19.
 */
public class BitmapCache implements ImageLoader.ImageCache{
    private LruCache<String,Bitmap> lrucache;
    public BitmapCache(){
        System.out.println("第二处");
        lrucache=new LruCache<String,Bitmap>(10*1024*1024){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes()*bitmap.getHeight();
            }
        };
    }
    @Override
    public Bitmap getBitmap(String url) {
        return lrucache.get(url);

    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        lrucache.put(url,bitmap);

    }
}
