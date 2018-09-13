package com.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by zhaomingpeng on 2018-09-11
 */
@Configuration
public class EnvConfig {
    @Autowired
    private Environment env;

    public String getStrProperty(String param){
        return env.getProperty(param,String.class);
    }

    public int getIntProperty(String param){
        return env.getProperty(param,Integer.class);
    }
}
