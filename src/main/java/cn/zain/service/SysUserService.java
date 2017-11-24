package cn.zain.service;

import cn.zain.model.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Zain
 */
public interface SysUserService {
    /**
     * 根据用户名查询系统用户信息
     *
     * @param username String
     * @return SysUser
     */
    SysUser selectByUsername(String username);

    /**
     * 功能说明 ： 添加用户
     *
     * @param sysUser SysUser
     */
    void save(SysUser sysUser);

    /**
     * 功能说明：分页查询有效记录
     * @param isValid
     * @param pageNumber 开始
     * @param pageSize
     * @param sortType
     * @param properties
     * @return
     */
    Page<SysUser> findValidSysUserListByPage(String isValid,int pageNumber, int pageSize,String sortType, String... properties);
}
