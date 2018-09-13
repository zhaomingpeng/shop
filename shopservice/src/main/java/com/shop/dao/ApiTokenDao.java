package com.shop.dao;

import com.shop.entity.ShopToken;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

/**
 * Created by zhaomingpeng on 2018-09-04
 */
@SqlResource("api.token")
public interface ApiTokenDao extends BaseMapper<ShopToken>{

    ShopToken queryByUserId(@Param("userId") Long userId);

    ShopToken queryByToken(@Param("token") String token);
}
