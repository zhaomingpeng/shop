package com.shop.service;

import com.shop.utils.ApiRRException;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by zhaomingpeng on 2018-05-07
 */
public class BaseService<T> {
    @Autowired
    protected SQLManager sqlManager;

    /**
     * 根据id查询对象，如果主键ID不存在
     * @param id
     * @return
     */
    public T queryById(Object id) {
        T t = sqlManager.single(getCurrentEntityClassz(), id);
        //queryEntityAfter((Object) t);
        return t;
    }

    /**
     * 新增一条数据
     * @param model 实体类
     * @return
     */
    public boolean save(T model) {
        return sqlManager.insert(model,true) > 0;
    }

    /**
     * 新增一条记录返回主键
     * @param model
     * @return
     */
    public int saveInt(T model){
        int i = sqlManager.insertTemplate(model,true);
        if(!(i>0)){
            throw new ApiRRException("save error");
        }
        return i;
    }

    public void batchInsert(Class T,List<?> list){
        sqlManager.insertBatch(T,list);
    }

    /**
     * 删除主键数据
     * @param id
     * @return
     */
    public int deleteById(Long id){
        return sqlManager.deleteById(getCurrentEntityClassz(),id);
    }

    /**
     * 更新，只更新不为空的字段
     * @param model
     * @return
     */
    public boolean updateTemplate(T model) {
        return sqlManager.updateTemplateById(model)>0;
    }

    /**
     * 更新所有字段
     * @param model
     * @return
     */
    public boolean update(T model) {
        return sqlManager.updateById(model) > 0;
    }



    /**
     * 获取当前注入泛型T的类型
     * @return 具体类型
     */
    @SuppressWarnings("unchecked")
    private Class<T> getCurrentEntityClassz() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
