package com.qzb.frame.app.model;

import com.qzb.common.api.Api;
import com.qzb.common.api.HostType;
import com.qzb.frame.app.contract.TestContract;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by QinZB on 2017/9/5.
 */

public class TestModel implements TestContract.Model {
    @Override
    public Observable<String> getBaiduData() {

        return Api.getDefault(HostType.TYPE_BAIDU)//
                .getBaiduContent(Api.getCacheControl())// 设置缓存,ApiService中如果不添加Header这可以不设置缓存
                .map(new Function<ResponseBody, String>() {
                    @Override
                    public String apply(@NonNull ResponseBody responseBody) throws Exception {
                        return responseBody.string();
                    }
                }).subscribeOn(Schedulers.io())//
                .observeOn(AndroidSchedulers.mainThread());

    }
}
