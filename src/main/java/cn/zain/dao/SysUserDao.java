package cn.zain.dao;

import cn.zain.model.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Zain
 */
public interface SysUserDao extends JpaRepository<SysUser, Long> {
    /**
     * 功能说明：根据用户名查找用户信息
     *
     * @param username String
     * @return SysUser
     */
    @Query("select a from SysUser a where a.username = ?1")
    SysUser selectByUsername(String username);

    /**
     * 功能说明：分页查询id大于指定值的记录
     *
     * @param isValid       String
     * @param pageable Pageable
     * @return Page<SysUser>
     */
    @Query("select a from SysUser a where a.isValid = ?1")
    Page<SysUser> findValidSysUserListByPage(String isValid, Pageable pageable);
}