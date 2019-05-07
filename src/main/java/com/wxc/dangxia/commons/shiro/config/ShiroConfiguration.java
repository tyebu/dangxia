package com.wxc.dangxia.commons.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.wxc.dangxia.commons.shiro.realm.DangXiaRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
/**
 * shiro配置类
 *
 * @author Star.Wu
 * @date 2019/05/07
 */
@Configuration
public class ShiroConfiguration {

    /**
     * 定义自己的加密方式
     * @return 加密实例
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("MD5");
        credentialsMatcher.setHashIterations(101);
        return credentialsMatcher;
    }

    /**
     * 将自己的realm加入容器
     * @param hashedCredentialsMatcher 自己的加密方式
     * @return 自己的realm容器
     */
    @Bean
    public DangXiaRealm dangXiaRealm(HashedCredentialsMatcher hashedCredentialsMatcher){
        DangXiaRealm dangXiaRealm = new DangXiaRealm();
        //设置加密方式
        dangXiaRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return dangXiaRealm;
    }


    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    /**
     * 权限配置 主要 配置realm的管理认证
     * @param dangXiaRealm 自己的realm容器
     * @return 安全管理器
     */
    @Bean
    public SecurityManager securityManager(DangXiaRealm dangXiaRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(dangXiaRealm);
        return securityManager;
    }

    /**
     * filter工厂 设置过滤条件 和跳转条件
     * @param securityManager 安全管理器
     * @return 过滤结果
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        System.out.println("----要拦截了哦-------");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<String, String>();
        //登出
        map.put("/login/logout","logout");

        //放行登录请求
        map.put("/login/isLogin","anon");
        map.put("/user/**","anon");
        map.put("/phone/**","anon");
        map.put("/review/**","anon");
        map.put("/mobilereview/**","anon");
        //放行静态资源
        map.put("/css/**","anon");
        map.put("/fonts/**","anon");
        map.put("/images/**","anon");
        map.put("/js/**","anon");
        map.put("/lib/**","anon");

        //对所有用户认证
        map.put("/**","authc");
        //map.put("/**","anon");
        //登录
        shiroFilterFactoryBean.setLoginUrl("/login/toLogin");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/login/toError");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 加入注解的使用，不加入这个注解不生效
     * @param securityManager 安全管理器
     * @return 结果
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
