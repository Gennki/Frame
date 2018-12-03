package com.qzb.frame.app.contract;

import com.google.gson.JsonObject;
import com.qzb.common.base.BaseModel;
import com.qzb.common.base.BasePresenter;
import com.qzb.common.base.BaseView;

import io.reactivex.Observable;

/**
 * Created by QinZB on 2017/9/5.
 */

public interface TestContract {
    interface Model extends BaseModel {
        Observable<String> getBaiduData();

        Observable<JsonObject> login();
    }

    interface View extends BaseView {
        void getBaiduData(String htmlContents);
        void loginSuccess(String loginInfo);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getBaiduData();
        public abstract void login();
    }
}
