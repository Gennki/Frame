package com.qzb.common.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by QinZB on 2017/9/3.
 */

public interface ApiService {
    @GET(" ")
    Observable<ResponseBody> getBaiduContent(@Header("Cache-Control") String cacheControl);

    @GET("blog/Test")
    Observable<ResponseBody> getJFinalData(@Header("Cache-Control") String cacheControl);
}
