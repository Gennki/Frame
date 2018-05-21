package com.qzb.frame.app.presenter;

import com.qzb.frame.app.contract.TestContract;

import io.reactivex.functions.Consumer;

/**
 * Created by QinZB on 2017/9/5.
 */

public class TestPresenter extends TestContract.Presenter {
    @Override
    public void getBaiduData() {
        mRxManage.add(mModel.getBaiduData().subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                mView.getBaiduData(s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.showErrorTip("服务器繁忙请稍后再试");
            }
        }));


    }
}
