package me.imyu.authz.web.secure;

import me.imyu.authz.web.model.Resource;
import me.imyu.authz.web.model.Role;
import me.imyu.authz.web.model.User;
import me.imyu.authz.web.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by imyu on 2018-02-08.
 */
@Component
public class MyAuthorizingRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String username = (String) principals.getPrimaryPrincipal();
        User user = userService.findUserByUsername(username);

        Set<String> roles = Role.list2Set(userService.findRoleByUserId(user.getId()));
        info.setRoles(roles);
        Set<String> permissions = Resource.list2Set(userService.findResourceByUserId(user.getId()));
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 认证服务先不使用
        return null;
    }
}
