package me.imyu.authz.web.api.impl;

import me.imyu.authz.AuthzException;
import me.imyu.authz.api.AuthzAPI;
import me.imyu.authz.entity.Token;
import me.imyu.authz.web.model.TokenModel;
import me.imyu.authz.web.service.TokenService;
import me.imyu.authz.web.service.UserService;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by imyu on 2018-02-08.
 */
@Service
public class AuthzAPIImpl implements AuthzAPI {
    @Autowired
    UserService userService;
    @Autowired
    TokenService tokenService;
    @Autowired
    SecurityManager securityManager;
    @Override
    public Token getToken(String username, String password) throws AuthzException {

        Assert.notNull(username, "用户名不能为空");
        Assert.notNull(password, "密码不能为空");

        if (!userService.check(username, password)) {
            throw new AuthzException("用户名或密码错误");
        }

        tokenService.clearToken(username);

        TokenModel tokenModel = tokenService.getToken(username, password);

        return new Token(tokenModel.getAccessToken(), tokenModel.getRefreshToken(), tokenModel.getExpireAt(), tokenModel.getRefreshExpireAt());
    }

    @Override
    public boolean isPermitted(String accessToken, String permission) {
        try {
            checkPermission(accessToken, permission);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void checkPermission(String accessToken, String permission) throws AuthzException {
        String username = tokenService.getUsernameByAccessToken(accessToken);
        PrincipalCollection principals = new SimplePrincipalCollection(username, "MyAuthorizingRealm");
        boolean boo = securityManager.isPermitted(principals, permission);
        if (!boo) {
            throw new AuthzException("没有该权限");
        }
    }
}
