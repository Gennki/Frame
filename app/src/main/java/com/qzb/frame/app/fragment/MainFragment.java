package com.qzb.frame.app.fragment;

import android.widget.TextView;

import com.qzb.common.base.BaseFragment;
import com.qzb.frame.R;
import com.qzb.frame.app.contract.TestContract;
import com.qzb.frame.app.model.TestModel;
import com.qzb.frame.app.presenter.TestPresenter;

public class MainFragment extends BaseFragment implements TestContract.View {

    private TestPresenter testPresenter;
    private TextView contentTV;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_main;
    }

    @Override
    public void initPresenter() {
        testPresenter = (TestPresenter) getPresenter(TestPresenter.class, TestModel.class);
    }

    @Override
    protected void initView() {
        contentTV = rootView.findViewById(R.id.fm_tv_content);
        testPresenter.login();
    }

    @Override
    public void getBaiduData(String htmlContents) {
        contentTV.setText(htmlContents);
    }

    @Override
    public void loginSuccess(String loginInfo) {
        contentTV.setText(loginInfo);
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }
}
