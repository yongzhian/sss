package cn.zain.service;

import cn.zain.model.entity.SysUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
public class SysUserServiceTest {
    private static Logger logger = LogManager.getLogger();

    @Resource
    private SysUserService sysUserService;
    @Test
    public void selectByUsernameTest() throws Exception {
        logger.info(sysUserService.selectByUsername("doom"));
        SysUser sysUser = new SysUser();
        sysUser.setUsername("yyy22pa");
        sysUser.setPassword("9527");
        sysUser.setIsValid("T");
        sysUser.setCreateTime(new Date());
        sysUser.setIsLocked("F");
//        sysUserService.save(sysUser);

        Page<SysUser> sysUserPage = sysUserService.findValidSysUserListByPage("T",0,2,"DESC","id");
        logger.info(sysUserService.findValidSysUserListByPage("T",3,1,"DESC","id"));
    }
}
