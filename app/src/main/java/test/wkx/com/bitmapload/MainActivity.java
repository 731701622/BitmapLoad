package test.wkx.com.bitmapload;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private ImageView imageView1;


    // 初始化一些网络图片
    String[] urls = { "http://pic14.nipic.com/20110607/6776092_111031284000_2.jpg",
            "http://cdn.duitang.com/uploads/item/201507/13/20150713235634_UKdLB.jpeg",
            "http://att2.citysbs.com/taizhou/2011/08/27/101937_kuumaaio_40ee6a85b8df443965c4ca5e6f5d80fa.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// 加载网络图片
        RequestManager requestManager = new RequestManager();
        requestManager.bindFragment(this);
        imageView1=(ImageView) findViewById(R.id.imageview1);

    }

}

