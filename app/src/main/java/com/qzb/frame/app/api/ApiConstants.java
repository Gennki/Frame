package com.qzb.frame.app.api;

/**
 * Created by QinZB on 2017/9/3.
 */

public class ApiConstants {

    private static final String BAIDU_HOST = "http://www.baidu.com/";
    private static final String TENCENT_CLOUDE = "http://139.199.14.212:4000/";


    /**
     * 获取对应的host
     *
     * @param hostType host类型
     * @return host
     */
    public static String getHost(int hostType) {
        String host;
        switch (hostType) {
            case HostType.TYPE_BAIDU:
                host = BAIDU_HOST;
                break;
            case HostType.TYPE_TENCENT:
                host = TENCENT_CLOUDE;
                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}
