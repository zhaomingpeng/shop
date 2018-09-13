package com.shop.dao;

import com.shop.entity.ShopUser;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

/**
 * Created by zhaomingpeng on 2018-09-11
 */
@SqlResource("api.shopuser")
public interface ApiShopUserDao extends BaseMapper<ShopUser>{

    public ShopUser queryByOpenId(@Param("openId") String openId);
}
