package cn.zain.service.impl;

import cn.zain.dao.SysUserDao;
import cn.zain.model.entity.SysUser;
import cn.zain.service.SysUserService;
import cn.zain.util.JpaTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author Zain
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    //采用MapperScannerConfigurer自动装配
    @Autowired
    private SysUserDao sysUserDao;


    @Override
    public SysUser selectByUsername(String username) {
        return sysUserDao.selectByUsername(username);
    }

    @Override
    public void save(SysUser sysUser) {
        sysUserDao.save(sysUser);
    }

    @Override
    public Page<SysUser> findValidSysUserListByPage(String isValid, int pageNumber, int pageSize, String sortType, String... properties) {
        return sysUserDao.findValidSysUserListByPage(isValid, JpaTool.buildPageRequest(pageNumber, pageSize, sortType, properties));
    }


}
