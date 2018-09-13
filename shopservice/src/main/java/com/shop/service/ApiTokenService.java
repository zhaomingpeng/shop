package com.shop.service;

import com.shop.dao.ApiTokenDao;
import com.shop.entity.ShopToken;
import com.shop.entity.ShopUser;
import com.shop.utils.CharUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaomingpeng on 2018-09-11
 */
@Service
public class ApiTokenService extends BaseService<ShopToken> {

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;
    @Autowired
    private ApiTokenDao apiTokenDao;

    public Map<String, Object> createToken(Long userId) {
        String token = CharUtil.getRandomString(32);
        Date date = new Date();
        Date expireTime = new Date(date.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        ShopToken shopToken = apiTokenDao.queryByUserId(userId);
        if (null == shopToken) {
            shopToken = new ShopToken();
            shopToken.setUserId(userId);
            shopToken.setToken(token);
            shopToken.setUpdateTime(date);
            shopToken.setExpireTime(expireTime);
            //保存token
            saveShopToken(shopToken);
        } else {
            shopToken.setToken(token);
            shopToken.setUpdateTime(date);
            shopToken.setExpireTime(expireTime);
            //更新token
            updateShopToken(shopToken);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", EXPIRE);
        return map;
    }

    public ShopToken queryByUserId(Object id) {
        return queryById(id);
    }


    public Integer saveShopToken(ShopToken model) {
        return saveInt(model);
    }

    public boolean updateShopToken(ShopToken model) {
        return update(model);
    }
}
