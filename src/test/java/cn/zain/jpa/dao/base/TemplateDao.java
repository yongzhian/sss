package cn.zain.jpa.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * Copyright (c) 2017 www.yongzhian.cn. All Rights Reserved.
 * @author Zain
 */
public interface TemplateDao<T extends Serializable> {

    /**
     * 功能说明：删除指定的实体
     *
     * @param entity T
     */
    void delete(T entity);

    /**
     * 功能说明：删除所有实体
     *
     * @param entities List<T>
     */
    void deleteAll(List<T> entities);

    /**
     * 功能说明：根据ID查询实体
     *
     * @param id Long
     * @return  T
     */
    T find(Long id);

    /**
     * 功能说明：存储实体到数据库
     *
     * @param entity T
     */
    void save(T entity);
}
