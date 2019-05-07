package com.wxc.dangxia.commons.shiro.realm;

import com.wxc.dangxia.entity.Employee;
import com.wxc.dangxia.service.login.ILoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义Realm
 *
 * @author Star.Wu
 * @date 2019/05/07
 */
public class DangXiaRealm extends AuthorizingRealm {

    //注入登录业务
    @Autowired
    private ILoginService loginService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        //从数据库或者缓存中获取角色数据
        Set<String> roles = loginService.getRolesByUserName(userName);
        //从数据库或者缓存获取权限数据
        Set<String> permissions = loginService.getPermissionsByUserName(userName);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 模拟数据库获得角色权限
     * @param userName
     * @return
     */
    private Set<String> getPermissionsByUserBane(String userName) {
        Set<String> sets = new HashSet<>();
        sets.add("user:delete");
        sets.add("user:add");
        return sets;
    }


    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.从主体传过来的认证信息中获得用户名
        String userName = (String) authenticationToken.getPrincipal();
        //2.通过用户名到数据库中获取凭证
        Employee employee = loginService.getEmployeeByName(userName);
        //判断账号是否存在
        if (employee==null){
            throw new UnknownAccountException("账号不存在");
        }
        //判断账号是否启用
        if (employee.getStatus()!=0){
            throw new DisabledAccountException("账号未启用");
        }
        //判断密码是否为空
        if (employee.getEmpPassword()==null){
            throw new IncorrectCredentialsException("密码错误");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,employee.getEmpPassword(), ByteSource.Util.bytes(employee.getEmpSalt()),getName());
        return authenticationInfo;
    }

}

