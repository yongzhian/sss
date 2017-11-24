package cn.zain.jpa.dao.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Copyright (c) 2017 www.yongzhian.cn. All Rights Reserved.
 *
 * @author Zain
 */
public class TemplateDaoImpl<T extends Serializable> implements TemplateDao<T> {

    private static final Logger logger = LoggerFactory.getLogger(TemplateDaoImpl.class);

    @PersistenceContext
    protected EntityManager em;


    /**
     * 实体类类型(由构造方法自动赋值)
     */
    private Class<T> entityClass;

    public TemplateDaoImpl() {
        this.entityClass = null;
        Class c = getClass();
        Type t = c.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.entityClass = (Class<T>) p[0];
            logger.debug("init class success,entityClass:" + this.entityClass);
        }
    }

    @Override
    public void delete(T entity) {
        this.em.remove(this.em.merge(entity)); //先转换为受控态再删除,否则会出异常
    }

    @Override
    public void deleteAll(List<T> entities) {
        if (null != entities) {
            for (int i = 0; i < entities.size(); i++) {
                this.em.remove(entities.get(i));
                if (i % 10 == 0) {//10个一批次删除
                    this.em.flush();
                }
            }
        }
    }

    @Override
    public T find(Long id) {
        T t = null;
        try {
            t = this.em.find(entityClass, id);
        } catch (Exception e) {
            t = null;
        }
        return t;
    }

    @Transactional
    @Override
    public void save(T entity) {
        this.em.persist(entity);
    }
}
