package com.icbc.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroDemo {
    private static final Logger log = LoggerFactory.getLogger(ShiroDemo.class);
    public static void main(String[] args){
        log.info("Starting my shiro server.");
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("root", "test");
        try {
            /*
               4. 登录，即验证身份
               调用subject.login方法进行登录，其会自动委托给SecurityManager.login方法进行登录
             */
            subject.login(token);
            log.info("用户登录成功");
        } catch (AuthenticationException e) {
            /*
            如果身份验证失败请捕获AuthenticationException或其子类，常见的如： DisabledAccountException（禁用的帐号）、
            LockedAccountException（锁定的帐号）、UnknownAccountException（错误的帐号）、
            ExcessiveAttemptsException（登录失败次数过多）、IncorrectCredentialsException （错误的凭证）、
            ExpiredCredentialsException（过期的凭证）等，具体请查看其继承关系；对于页面的错误消息展示，
            最好使用如“用户名/密码错误”而不是“用户名错误”/“密码错误”，防止一些恶意用户非法扫描帐号库
             */
            log.error("身份验证失败:{}", e.getLocalizedMessage());
        }


        //6. 退出
        subject.logout();
    }
}
