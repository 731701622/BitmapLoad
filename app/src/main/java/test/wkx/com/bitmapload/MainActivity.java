package test.wkx.com.bitmapload;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


import butterknife.BindView;
import butterknife.ButterKnife;
import test.wkx.com.bitmapload.Utils.MyBitmapUtils;


public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.imageview1)
    ImageView imageview1;
    @BindView(R.id.imageview2)
    ImageView imageview2;
    @BindView(R.id.imageview3)
    ImageView imageview3;
    @BindView(R.id.imageview4)
    ImageView imageview4;
    String gifUrl = "http://ww4.sinaimg.cn/mw690/bcc93f49gw1f6r1nce77jg207x07sx6q.gif";
    MyBitmapUtils bitmapUtils;

    private String imageArr[] = {"http://pic14.nipic.com/20110607/6776092_111031284000_2.jpg",
            "http://cdn.duitang.com/uploads/item/201507/13/20150713235634_UKdLB.jpeg",
            "http://att2.citysbs.com/taizhou/2011/08/27/101937_kuumaaio_40ee6a85b8df443965c4ca5e6f5d80fa.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        bitmapUtils = new MyBitmapUtils();
        bitmapUtils.disPlay(imageview1,imageArr[0]);
        bitmapUtils.disPlay(imageview2,imageArr[1]);
        bitmapUtils.disPlay(imageview3,imageArr[2]);
        bitmapUtils.disPlay(imageview4,gifUrl);
    }
    @Override
    protected void onResume() {
        super.onResume();
        initView();
    }
}
