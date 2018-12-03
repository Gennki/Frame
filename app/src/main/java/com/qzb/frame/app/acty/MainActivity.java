package com.qzb.frame.app.acty;

import android.util.Log;
import android.widget.TextView;

import com.qzb.common.base.BaseActivity;
import com.qzb.frame.R;
import com.qzb.frame.app.contract.TestContract;
import com.qzb.frame.app.model.TestModel;
import com.qzb.frame.app.presenter.TestPresenter;

public class MainActivity extends BaseActivity implements TestContract.View {


    private TextView contentTV;
    private TestPresenter testPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {
        testPresenter = (TestPresenter) getPresenter(TestPresenter.class, TestModel.class);
    }

    @Override
    public void initView() {
        contentTV = findViewById(R.id.am_tv_content);
        testPresenter.getBaiduData();
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

    @Override
    public void loginSuccess(String loginInfo) {

    }

}
