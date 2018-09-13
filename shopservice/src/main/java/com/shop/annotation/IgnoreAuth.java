package com.shop.annotation;

import java.lang.annotation.*;

/**
 * Created by zhaomingpeng on 2018-09-04
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}
