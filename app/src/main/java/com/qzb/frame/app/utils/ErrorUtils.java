package com.qzb.frame.app.utils;

import org.json.JSONObject;

import retrofit2.adapter.rxjava2.HttpException;


public class ErrorUtils {
    public static String getErrorMessage(Throwable throwable) {
        String errorString = "网络不稳定,请稍后再试";
        try {
            if (throwable instanceof HttpException) {
                String jsonStr = ((HttpException) throwable).response().errorBody().string();
                JSONObject jsonObject = new JSONObject(jsonStr);
                errorString = jsonObject.getString("msg");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return errorString;
    }
}
