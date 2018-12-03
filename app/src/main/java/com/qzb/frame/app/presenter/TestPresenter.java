package com.qzb.frame.app.presenter;

import com.google.gson.JsonObject;
import com.qzb.frame.app.contract.TestContract;
import com.qzb.frame.app.utils.ErrorUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by QinZB on 2017/9/5.
 */

public class TestPresenter extends TestContract.Presenter {
    @Override
    public void getBaiduData() {
        mRxManage.add(mModel.getBaiduData().subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) {
                mView.getBaiduData(s);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
                mView.showErrorTip("服务器繁忙请稍后再试");
            }
        }));


    }

    @Override
    public void login() {
        mRxManage.add(mModel.login().subscribe(new Consumer<JsonObject>() {
            @Override
            public void accept(JsonObject jsonObject) throws Exception {
                mView.loginSuccess(jsonObject.toString());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.loginSuccess(ErrorUtils.getErrorMessage(throwable));
            }
        }));
    }
}
