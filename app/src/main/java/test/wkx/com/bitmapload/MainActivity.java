package test.wkx.com.bitmapload;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;


import test.wkx.com.bitmapload.LifeListener.RequestManager;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// 加载网络图片;
        listView = (ListView)findViewById(R.id.list); //将适配器导入Listview
        ImageAdapter adapter = new ImageAdapter(this);
        listView.setAdapter(adapter);
        RequestManager requestManager = new RequestManager();
        requestManager.bindFragment(this);
        Log.d("logd", "UI");


    }

}

