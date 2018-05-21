package com.qzb.frame.app.acty;

import android.util.Log;
import android.widget.TextView;

import com.qzb.common.base.BaseActivity;
import com.qzb.frame.R;
import com.qzb.frame.app.contract.TestContract;
import com.qzb.frame.app.model.TestModel;
import com.qzb.frame.app.presenter.TestPresenter;

public class MainActivity extends BaseActivity<TestPresenter, TestModel> implements TestContract.View {


    private TextView contentTV;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        contentTV = findViewById(R.id.am_tv_content);
        mPresenter.getBaiduData();
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {
        Log.e(TAG, "showErrorTip: ===>" + msg);
    }

    @Override
    public void getBaiduData(String htmlContents) {
        contentTV.setText(htmlContents);
        Log.e(TAG, htmlContents);
    }

}
