package com.shop.entity;

import java.io.Serializable;

/**
 * Created by zhaomingpeng on 2018-09-07
 */
public class ShopAdPosition implements Serializable {

    private static final long serialVersionUID = 1940044761153000708L;
    //主键
    private Integer id;
    //位置名称
    private String name;
    //宽度
    private Integer width;
    //高度
    private Integer height;
    //描述
    private String addesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getAddesc() {
        return addesc;
    }

    public void setAddesc(String addesc) {
        this.addesc = addesc;
    }
}
