package com.qzb.common.api;

/**
 * Created by QinZB on 2017/9/3.
 */

public class ApiConstants {

    private static final String BAIDU_HOST = "http://www.baidu.com/";
    private static final String JFINAL_HOST = "http://192.168.3.22:10086/";


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
            case HostType.TYPE_JFINAL:
                host = JFINAL_HOST;
                break;
            default:
                host = "";
                break;
        }
        return host;
    }
}