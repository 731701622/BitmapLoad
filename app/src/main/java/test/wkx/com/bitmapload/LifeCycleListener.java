package test.wkx.com.bitmapload;

public interface LifeCycleListener
{
    //用于监听生命周期的接口，分别为开始，停止和销毁
    void onStart();
    void onStop();
    void onDestroy();
}
