package test.wkx.com.bitmapload;

import android.app.Activity;

;
import android.app.FragmentManager;
import android.util.Log;

public class RequestManager implements LifeCycleListener
{
    private static final String TAG = RequestManager.class.getSimpleName();

    /**
     * 当然这里可能还有FragmentActivity，Fragment等参数，再此只给出一种方式，其他同理
     * @param activity 传入的上下文
     */
    public void bindFragment(Activity activity) {
        FragmentManager managerFragment = activity.getFragmentManager();
        fragmentGet(managerFragment, isActivityVisible(activity));
    }

    private void fragmentGet(FragmentManager fragmentManager, boolean activityVisible) {
        ManagerFragment current = new ManagerFragment();
        fragmentManager.beginTransaction().add(current,"managerlife").commitAllowingStateLoss();
        current.getLifeCycle().addListener(this);
    }

    private boolean isActivityVisible(Activity activity) {
        return !activity.isFinishing();
    }

    @Override
    public void onStart() {
        //do you buzz
        Log.i(TAG, "onStart: ");
    }

    /**
     * 当出现该函数时，可以暂停Glide网络图片的请求
     */
    @Override
    public void onStop() {
        //do you buzz
        Log.i(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        //do you buzz
        Log.i(TAG, "onDestroy: ");
    }

}
