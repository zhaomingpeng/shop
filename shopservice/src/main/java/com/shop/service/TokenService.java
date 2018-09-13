package com.shop.service;

import com.shop.dao.ApiTokenDao;
import com.shop.entity.ShopToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaomingpeng on 2018-09-04
 */
@Service
public class TokenService {

    @Autowired
    private ApiTokenDao apiTokenDao;

    public ShopToken queryByToken(String token) {
        return apiTokenDao.queryByToken(token);
    }
}
