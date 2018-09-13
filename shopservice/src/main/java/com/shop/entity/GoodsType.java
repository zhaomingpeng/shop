package com.shop.entity;

/**
 * Created by zhaomingpeng on 2018-09-08
 */
public enum GoodsType {

    GROUP(2,"团购");

    private Integer id;
    private String des;

    GoodsType(Integer id,String des){
        this.id = id;
        this.des = des;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
