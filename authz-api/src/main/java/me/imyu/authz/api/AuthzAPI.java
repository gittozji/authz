package me.imyu.authz.api;

import me.imyu.authz.AuthzException;
import me.imyu.authz.entity.Token;

/**
 * Created by imyu on 2018-02-08.
 */
public interface AuthzAPI {
    /**
     * 提供登录接口，授予token
     * @param username
     * @param password
     * @return
     * @throws AuthzException 用户名或密码错误将抛出异常
     */
    Token getToken(String username, String password) throws AuthzException;

    /**
     * 判断是否有权限
     * @param accessToken
     * @param permission
     * @return 当且仅当有权限返回true
     */
    boolean isPermitted(String accessToken, String permission);

    /**
     * 判断是否有权限
     * @param accessToken
     * @param permission
     * @throws AuthzException 没有权限抛出异常
     */
    void checkPermission(String accessToken, String permission) throws AuthzException;
}
