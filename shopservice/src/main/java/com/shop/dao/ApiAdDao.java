package com.shop.dao;

import com.shop.entity.ShopAd;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

/**
 * Created by zhaomingpeng on 2018-09-07
 */
@SqlResource("api.ad")
public interface ApiAdDao extends BaseMapper<ShopAd> {

    List<ShopAd> queryAdsByPosition(@Param("positionId") Integer positionId);
}
