package test.wkx.com.bitmapload;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import java.io.File;

import test.wkx.com.bitmapload.Utils.MyBitmapUtils;

public class ImageAdapter extends BaseAdapter
{
    MyBitmapUtils bitmapUtils = new MyBitmapUtils();
    // 初始化一些网络图片
    String[] urls = { "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/3e1acdd6ecdf4dc2aa9abc45be2443db.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/cff4bd31c3934c8388cd5b47d3d34e29.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/4fd9f3557acd4fb28b28af7a89a2ff27.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/7ead2966291e45c4aef8a198f127bd4a.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/245c7655f4de4536a539a559c9434ce4.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/51b047314ca74259839c4e6e666e9c71.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/1a11e2a135bf4bc29fd60831c64f558c.jpg"};


    LayoutInflater layoutInflater;
    Context context;
    File fileDir;

    public ImageAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return urls.length;
    }

    @Override
    public Object getItem(int position) {
        return urls[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        View view = layoutInflater.inflate(R.layout.item_list, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        bitmapUtils.disPlay(imageView, urls[position]);
        return view;
    }


}



