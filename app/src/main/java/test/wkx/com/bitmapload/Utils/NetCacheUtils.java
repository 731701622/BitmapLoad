package test.wkx.com.bitmapload.Utils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import test.wkx.com.bitmapload.MainActivity;

public class NetCacheUtils
{
    private static final String TAG = "MainActivity";
    private LocalCacheUtils mLocalCacheUtils;
    private MemoryCacheUtils mMemoryCacheUtils;

    public NetCacheUtils(LocalCacheUtils localCacheUtils, MemoryCacheUtils memoryCacheUtils) {
        mLocalCacheUtils = localCacheUtils;
        mMemoryCacheUtils = memoryCacheUtils;
    }

    /**
     * 从网络下载图片
     * @param ivPic 显示图片的imageview
     * @param url 下载图片的网络地址
     */
    public void getBitmapFromNet(ImageView ivPic, String url) {
        new BitmapTask().execute(ivPic, url);//启动AsyncTask

    }

    class BitmapTask extends AsyncTask<Object, Void, Bitmap>
    {

        private ImageView ivPic;
        private String url;

        /**
         * 后台耗时操作,存在于子线程中
         * @param params
         * @return
         */
        @SuppressLint("WrongThread")
        @Override
        protected Bitmap doInBackground(Object[] params) {
            ivPic = (ImageView) params[0];
            url = (String) params[1];
            ivPic.setTag(url);  //与url 绑定一起
            return downLoadBitmap(url);
        }

        /**
         * 更新进度,在主线程中
         * @param values
         */
        @Override
        protected void onProgressUpdate(Void[] values) {
            super.onProgressUpdate(values);
        }

        /**
         * 耗时方法结束后执行该方法,主线程中
         * @param result
         */
        @Override
        protected void onPostExecute(Bitmap result) {
            String url  = (String) ivPic.getTag();
            if (this.url .equals(url)) {
            if (result != null) {
                ivPic.setImageBitmap(result);
                System.out.println("从网络缓存图片.");
                //从网络获取图片后,保存至本地缓存
                mLocalCacheUtils.setBitmapToLocal(url, result);
                //保存至内存中
                mMemoryCacheUtils.setBitmapToMemory(url, result);
            }
            }
        }
    }

    /**
     * 网络下载图片
     * @param url
     * @return
     */
    private Bitmap downLoadBitmap(String url) {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                //图片压缩
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize=2;//宽高压缩为原来的1/2
                options.inPreferredConfig=Bitmap.Config.ARGB_4444;
                Bitmap bitmap = BitmapFactory.decodeStream(conn.getInputStream(),null,options);
                return bitmap;
            }
        } catch (MalformedURLException e) {
            Log.d(TAG, "协议未找到 ");
            e.printStackTrace();
        } catch (IOException e) {
            Log.d(TAG, "网址有误 ");
            e.printStackTrace();

        } finally {
            conn.disconnect();
        }

        return null;
    }


}


