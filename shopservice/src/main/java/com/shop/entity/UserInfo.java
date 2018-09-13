package com.shop.entity;

import java.io.Serializable;

/**
 * Created by zhaomingpeng on 2018-09-11
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 4610368101941636062L;

    private String avatarUrl;
    //
    private String city;
    //
    private Integer gender;
    //
    private String nickName;
    //
    private String province;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
