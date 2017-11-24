package cn.zain.jpa.dao;

import cn.zain.jpa.dao.base.TemplateDao;
import cn.zain.jpa.model.SysUser;

public interface SysUserDao extends TemplateDao{

    /**
     * 功能说明：根据用户名查找用户信息
     *
     * @param username
     * @return
     */
    SysUser selectByUsername(String username);
}
