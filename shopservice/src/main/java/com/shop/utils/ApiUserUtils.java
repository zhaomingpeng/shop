package com.shop.utils;

import com.shop.config.EnvConfig;

/**
 * Created by zhaomingpeng on 2018-09-11
 */
public class ApiUserUtils {

    //替换字符串
    public static String getWebAccess(String CODE, EnvConfig envConfig) {
        return String.format(envConfig.getStrProperty("wx.webAccessTokenhttps"),
                envConfig.getStrProperty("wx.appId"),
                envConfig.getStrProperty("wx.secret"),
                CODE);
    }

}
