package cn.zain.jpa.dao;

import cn.zain.jpa.dao.base.TemplateDaoImpl;
import cn.zain.jpa.model.SysUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("sysUserDao")
public class SysUserDaoImpl extends TemplateDaoImpl implements SysUserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public SysUser selectByUsername(String username) {
        return em.createQuery("FROM SysUser where username = :username", SysUser.class)
                .setParameter("username", username).getSingleResult();
    }

}
