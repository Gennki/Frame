package com.qzb.common.base;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.qzb.common.baserx.RxManager;
import com.qzb.common.util.ToastUtil;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity {
    public List<BasePresenter> mPresenters;
    public Context mContext;
    public RxManager mRxManager;
    private boolean isConfigChange = false;
    protected final String TAG = getClass().getSimpleName();
    protected boolean isFinished = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isFinished = false;
        isConfigChange = false;
        mRxManager = new RxManager();
        mPresenters = new ArrayList<>();
        doBeforeSetcontentView();
        setContentView(getLayoutId());
        mContext = this;
        this.initPresenter();
        this.initView();
    }

    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {
        // 把actvity放到application栈中管理
        AppManager.getAppManager().addActivity(this);
        // 无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 无状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 创建Presenter
     */
    protected BasePresenter getPresenter(Class presenterClass, Class modelClass) {
        try {
            BasePresenter presenter = (BasePresenter) presenterClass.newInstance();
            presenter.setVM(this, modelClass.newInstance());
            presenter.mContext = this;
            mPresenters.add(presenter);
            return presenter;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*********************子类实现*****************************/
    //获取布局文件
    public abstract int getLayoutId();

    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();

    //初始化view
    public abstract void initView();


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        isConfigChange = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (BasePresenter presenter : mPresenters) {
            presenter.onDestroy();
        }
        if (mRxManager != null) {
            mRxManager.clear();
        }
        if (!isConfigChange) {
            AppManager.getAppManager().finishActivity(this);
        }
    }

    /*--------------------------------Handler---------------------------------*/
    public Handler mHandler = new MyHandler(this);

    /**
     * 避免Handler引起的内存泄露
     * 使用显性的引用，1.静态内部类。 2. 外部类
     * 使用弱引用 2. WeakReference
     */
    public static class MyHandler extends Handler {
        private final WeakReference<BaseActivity> mActivity;

        public MyHandler(BaseActivity activity) {

            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            BaseActivity baseActy = mActivity.get();
            if (baseActy == null) {
                return;
            }
//			if (!BaseActy.this.isFinishing()){
//			}
            if (!baseActy.isFinished()) {
                baseActy.handleMessaged(msg);
            } else {
                removeMessages(msg.what);
            }
        }
    }

    public void handleMessaged(Message msg) {
    }

    public boolean isFinished() {
        return isFinished;
    }


    private long preTime = 0;

    protected void closeApp() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - preTime > 2000) {
            ToastUtil.showShort(mContext, "双击退出程序");
            preTime = currentTime;
        } else {
            System.exit(0);
        }
    }
}
