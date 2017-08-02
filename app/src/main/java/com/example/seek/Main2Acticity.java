package com.example.seek;

import android.app.AliasActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by 小亚 on 2017/7/19.
 */

public class Main2Acticity extends AliasActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.main2activity);
        String title=getIntent().getStringExtra("title");
        String data=getIntent().getStringExtra("data");
        String pic=getIntent().getStringExtra("pic");
        TextView textView1=(TextView)findViewById(R.id.textView2);
        TextView textView2=(TextView)findViewById(R.id.textView3);
        ImageView imageView=(ImageView)findViewById(R.id.imageView2);
        textView1.setText("title:"+title);
        textView2.setText("data:"+data);
        setImage(pic,Main2Acticity.this,imageView);
    }
    public static void setImage(String url , Context context, ImageView imageView) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
        DisplayImageOptions diosplay = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new RoundedBitmapDisplayer(90))
                .build();
        imageLoader.displayImage(url, imageView, diosplay);

   }
}
