package com.example.seek;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import java.util.List;

/**
 * Created by 小亚 on 2017/7/19.
 */

public class MyBase extends BaseAdapter{
    private List<BweiBean.ListBean> list;
    private Context context;

    public MyBase(List<BweiBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
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
    ViewHolder viewHolder;
        if (view==null){
            viewHolder=new ViewHolder();
            view=View.inflate(context, R.layout.item,null);
            viewHolder.image_view=view.findViewById(R.id.imageView);
            viewHolder.text_view1=view.findViewById(R.id.textView);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.text_view1.setText("title:"+list.get(i).title+"\n"+"data"+list.get(i).date);
        setImage(list.get(i).pic,context,viewHolder.image_view);
        return view;
    }
    public static void setImage(String url , Context context,ImageView imageView){
                ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).build();
                ImageLoader imageLoader = ImageLoader.getInstance();
                imageLoader.init(config);
                DisplayImageOptions diosplay =new DisplayImageOptions.Builder()
                        .showImageOnLoading(R.mipmap.ic_launcher)
                        .showImageForEmptyUri(R.mipmap.ic_launcher)
                        .showImageOnFail(R.mipmap.ic_launcher)
                        .cacheInMemory(true)
                        .cacheOnDisk(true)
                        .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                        .bitmapConfig(Bitmap.Config.RGB_565)
                        .build();
                imageLoader.displayImage(url,imageView,diosplay);
            }
    class  ViewHolder{
        ImageView image_view;
        TextView text_view1;
    }
}
