package com.qzb.frame.app.api;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by QinZB on 2017/9/3.
 */

public interface ApiService {
    @GET(" ")
    Observable<ResponseBody> getBaiduContent(@Header("Cache-Control") String cacheControl);

    @GET("/login/cellphone")
    Observable<JsonObject> login(@Query("phone") String phone, @Query("password") String password);

}
