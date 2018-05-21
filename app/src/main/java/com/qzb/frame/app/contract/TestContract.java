package com.qzb.frame.app.contract;

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
    }

    interface View extends BaseView {
        void getBaiduData(String htmlContents);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getBaiduData();
    }
}
