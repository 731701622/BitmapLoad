package test.wkx.com.bitmapload;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;


import java.io.File;

import test.wkx.com.bitmapload.Utils.MyBitmapUtils;

public class ImageAdapter extends BaseAdapter
{
    MyBitmapUtils bitmapUtils = new MyBitmapUtils();
    // 初始化一些网络图片
    String[] urls = {"http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/3e1acdd6ecdf4dc2aa9abc45be2443db.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/cff4bd31c3934c8388cd5b47d3d34e29.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/4fd9f3557acd4fb28b28af7a89a2ff27.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/7ead2966291e45c4aef8a198f127bd4a.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/245c7655f4de4536a539a559c9434ce4.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/51b047314ca74259839c4e6e666e9c71.jpg",
            "http://bmob-cdn-1178.b0.upaiyun.com/2016/05/10/1a11e2a135bf4bc29fd60831c64f558c.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760758_3497.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760758_6667.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760757_3588.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760756_3304.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760726_5120.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760726_8364.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760725_4031.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760724_9463.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760724_2371.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760707_4653.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760706_6864.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760706_9279.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760704_2341.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760704_5707.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760685_5091.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760685_4444.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760684_8827.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760683_3691.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760683_7315.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760663_7318.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760662_3454.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760662_5113.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760661_3305.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760661_7416.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760589_2946.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760589_1100.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760588_8297.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760587_2575.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760587_8906.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760550_2875.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760550_9517.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760549_7093.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760549_1352.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760548_2780.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760531_1776.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760531_1380.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760530_4944.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760530_5750.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760529_3289.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760500_7871.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760499_5081.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760498_7007.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760478_3128.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760478_6766.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760477_1358.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760477_3540.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760476_1240.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760446_7993.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760446_3641.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760445_3283.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760444_8623.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760444_6822.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760422_2224.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760421_2824.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760420_2660.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760420_7188.jpg",
            "https://img-my.csdn.net/uploads/201508/05/1438760419_4123.jpg",
    };


    LayoutInflater layoutInflater;
    Context context;
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
        ViewHolder holder = null;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_list, null);
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        bitmapUtils.disPlay(holder.imageView, urls[position]);
        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
    }
}



