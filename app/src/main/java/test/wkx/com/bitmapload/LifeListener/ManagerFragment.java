package test.wkx.com.bitmapload.LifeListener;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.support.annotation.NonNull;


public class ManagerFragment extends Fragment
{

    //此类用于获取生命周期
    private ActivityFragmentLifeCycle lifecycle;
    public ManagerFragment() {
        this(new ActivityFragmentLifeCycle());
    }

    @SuppressLint("ValidFragment")
    public ManagerFragment(@NonNull ActivityFragmentLifeCycle lifeCycle) {
        this.lifecycle = lifeCycle;
    }

    @NonNull
    ActivityFragmentLifeCycle getLifeCycle() {
        return lifecycle;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onStart() {
        super.onStart();
        lifecycle.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        lifecycle.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycle.onDestroy();
    }

}
