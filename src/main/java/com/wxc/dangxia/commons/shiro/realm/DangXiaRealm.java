package com.wxc.dangxia.commons.shiro.realm;

import com.wxc.dangxia.entity.Employee;
import com.wxc.dangxia.service.system.ILoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义Realm
 *
 * @author Star.Wu
 * @date 2019/05/07
 */
public class DangXiaRealm extends AuthorizingRealm {
    @Autowired
    private ILoginService loginService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
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
        String userName = authenticationToken.getPrincipal().toString();
        //2.通过用户名到数据库中获取凭证
        Employee employee = loginService.getEmployeeByUserName(userName);
        //判断账号是否存在
        if (employee==null){
            throw new UnknownAccountException("账号不存在");
        }
        //判断账号是否启用
        if (employee.getEmpStatus()!=1){
            throw new DisabledAccountException("账号未启用");
        }
        //判断密码是否为空
        if (employee.getEmpPassword()==null){
            throw new IncorrectCredentialsException("密码不能为空");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(employee,employee.getEmpPassword(),getName());
        return authenticationInfo;
    }

}

