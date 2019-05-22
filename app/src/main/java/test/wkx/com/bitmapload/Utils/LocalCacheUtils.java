package test.wkx.com.bitmapload.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import test.wkx.com.bitmapload.MD5Encoder;

public class LocalCacheUtils
{
    private static final String TAG = "MainActivity";
    public static final String CACHE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath()+"/imagememory/";
    private  MemoryCacheUtils memoryCacheUtils ;
    public LocalCacheUtils(MemoryCacheUtils memoryCacheUtils) {
        this.memoryCacheUtils = memoryCacheUtils ;
    }

    /**
     * 从本地读取图片
     *
     * @param url
     */
    public Bitmap getBitmapFromLocal(String url)
    {
        try
        {
           File cacheFile = new File(CACHE_PATH,MD5Encoder.encode(url)+".JPEG");
            if(cacheFile.exists()) {
                try
                {
                    Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(cacheFile));
                    memoryCacheUtils.setBitmapToMemory(url,bitmap);
                    return bitmap;
                }catch (FileNotFoundException e) {
                e.printStackTrace();
                    Log.d(TAG, "文件未找到");
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.d(TAG, "读取失败");
        }
        return null;
    }

    /**
     * 从网络获取图片后,保存至本地缓存
     *
     * @param url
     * @param bitmap
     */
    public void setBitmapToLocal(String url, Bitmap bitmap) {
        File dir = new File(CACHE_PATH);
        if(!dir.exists() || !dir.isDirectory()) {
        dir.mkdirs() ; // 创建文件夹
    }
        try {
            //MD5加密存储
            File cacheFile = new File(dir,MD5Encoder.encode(url)+".JPEG");
            if(!cacheFile.exists()){
                //先得到文件的上级目录，并创建上级目录，在创建文件
                cacheFile.getParentFile().mkdir();
                try {
                    //创建文件
                    cacheFile.createNewFile();
                } catch (IOException e) {
                    Log.d(TAG, "创建文件失败");
                    e.printStackTrace();
                }
            }
            FileOutputStream outputStream = new FileOutputStream(cacheFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new BufferedOutputStream(outputStream));
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "存储失败");
        }

    }
}

