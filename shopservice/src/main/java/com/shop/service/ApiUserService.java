package com.shop.service;


import com.shop.dao.ApiShopUserDao;
import com.shop.entity.ShopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhaomingpeng on 2018-09-04
 */
@Service
public class ApiUserService extends BaseService<ShopUser>{

    @Autowired
    private ApiShopUserDao shopUserDao;

    public ShopUser queryObject(Long userId){
        return this.queryById(userId);
    }

    public ShopUser queryByOpenId(String openId){
        return shopUserDao.queryByOpenId(openId);
    }

    public Integer saveShopUser(ShopUser model) {
        return saveInt(model);
    }

    public boolean updateShopUser(ShopUser shopUser){
        return update(shopUser);
    }
}
