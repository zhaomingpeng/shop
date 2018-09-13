package com.shop.service;

import com.shop.dao.ApiAdDao;
import com.shop.entity.ShopAd;
import com.shop.entity.ShopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhaomingpeng on 2018-09-07
 */
@Service
public class ApiAdService extends BaseService<ShopAd>{

    @Autowired
    private ApiAdDao apiAdDao;

    public List<ShopAd> queryAdsByPosition(Integer positionId){
        return apiAdDao.queryAdsByPosition(positionId);
    }
}
