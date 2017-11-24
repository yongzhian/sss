package cn.zain.jpa;

import cn.zain.jpa.dao.SysUserDao;
import cn.zain.jpa.model.SysUser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaTest {
    private static final Logger logger = LoggerFactory.getLogger(JpaTest.class);

    @Test
    public void originalJpa() throws Exception {
        SysUser sysUser = new SysUser();
//        sysUser.setId(18L);
        sysUser.setUsername("yyy");
        sysUser.setPassword("9527");
        sysUser.setIsValid("T");
        sysUser.setCreateTime(new Date());
        sysUser.setIsLocked("F");

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("SimplePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(sysUser);
        em.getTransaction().commit();
        emf.close();
    }

    /**
     * persistence.xml不需要，自动扫描Entity包
     * @throws Exception
     */
    @Test
    public void jpaTest() throws Exception {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-jpa-cfg.xml");
        SysUserDao sysUserDao = ctx.getBean("sysUserDao", SysUserDao.class);
        SysUser sysUser = new SysUser();
        sysUser.setUsername("yyy22");
        sysUser.setPassword("9527");
        sysUser.setIsValid("T");
        sysUser.setCreateTime(new Date());
        sysUser.setIsLocked("F");
        sysUserDao.save(sysUser);
        logger.info("查询用户,{}",sysUserDao.selectByUsername("yyy"));
    }
}
