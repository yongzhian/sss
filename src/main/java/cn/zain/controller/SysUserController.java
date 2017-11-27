package cn.zain.controller;

import cn.zain.model.entity.SysUser;
import cn.zain.service.StatisticsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (c) 2016 www.yongzhian.cn. All Rights Reserved.
 *
 * @author Zain
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController extends AbstractController{

    @RequestMapping(value = "/get.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> get() {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("method", "get");
//        Server server = new Server();
        return returnMap;

    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login() {
        logger.debug("用户登录...");
        Map<String, Object> returnMap = new HashMap<>();

        if(authCheck()){
            returnMap.put("result", 0);
        }else{
            returnMap.put("result", -1);
            returnMap.put("error_msg", "认证失败!");
        }
        return returnMap;
    }

    @RequestMapping(value = "/grid.do", method = RequestMethod.GET)
    public String grid() {
        logger.debug("用户分页查询...");
        Page<SysUser> sysUserPage = sysUserService.findValidSysUserListByPage("T",0,2,"DESC","id");
        request.setAttribute("sysUserPage",sysUserPage);
        return "pages/grid";
    }

    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> add(@ModelAttribute()SysUser sysUser) {
        logger.debug("用户添加...");
        sysUser.setCreateTime(new Date());
        sysUserService.save(sysUser);
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("result", 0);
        return returnMap;
    }
}
