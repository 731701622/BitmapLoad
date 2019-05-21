package test.wkx.com.bitmapload;

import android.support.annotation.NonNull;

public class ActivityFragmentLifeCycle
{
    private LifeCycleListener lifecycleListener;

    public void addListener(@NonNull LifeCycleListener listener) {
        lifecycleListener = listener;
    }

    void onStart() {
        lifecycleListener.onStart();

    }

    void onStop() {
        lifecycleListener.onStop();

    }

    void onDestroy() {
        lifecycleListener.onDestroy();
    }

}
