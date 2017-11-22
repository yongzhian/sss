package cn.zain;

import cn.zain.model.entity.SysUser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
