package com.shop.service;

import com.shop.dao.ApiGoodsDao;
import com.shop.entity.ShopGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhaomingpeng on 2018-09-08
 */
@Service
public class ApiGoodsService extends BaseService<ShopGoods>{

    @Autowired
    private ApiGoodsDao apiGoodsDao;

    /**
     * 通过类型查询商品
     * @param type
     * @return
     */
    public List<ShopGoods> queryGoodsByGoodType(Integer type){
        return apiGoodsDao.queryGoodsByGoodType(type);
    }

}
