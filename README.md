# 安卓作业

##封装图片加载框架BitmapLoad  

三级缓存实质是内存-文件-网络三层cache机制，大致就是当根据url向网络拉取图片的时候，先从内存中找，如果内存中没有，再从缓存文件中查找，如果缓存文件中也没有，再从网络上通过http请求拉取图片。  
这里没有使用SoftReference，而是使用LruCache进行图片的缓存，原因LruCache可以把最近最少使用的对象在缓存值达到预设定值之前从内存中移除  
监听activity的生命周期，类似模仿的glide的监听模式：创建了一个没有页面的Fragment，通过Fragment的生命周期来设置生命周期  
至于listview的重复问题，每次getview能给对象一个标识，在异步加载完成时比较标识与当前的item的标识是否是一致的，一致的则显示，否则不做处理  

这里说一波这几天踩的坑：  
1.用HttpURLConnection的时候一直无法连接网络，反复检查自己的确声明了权限，后来查了才发现还要再manifest中加android:usesCleartextTraffic="true"，因为Android的系统上面默认所有Http的请求都被阻止。  
2.三级缓存时，在电脑的模拟器上始终抛出java.io.FileNotFoundException异常，无法找到存储的文件，然后再次确定声明了权限，还是不行，然后在代码里加了无数判断，此处前后尝试使用SD卡getAbsolutePath和直接使用手机存储包目录，在使用mkdir创建父级目录成功的情况下，createNewFile仍然报错，最后很久很久在模拟器里给app手动声明访问sd卡权限，才好的。模拟器中默认关闭了APP的存储空间权限，即使manifest中正常注册权限，该APP仍让无法读写文件。