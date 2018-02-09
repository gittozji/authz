package me.imyu.authz.web.service;

import me.imyu.authz.AuthzException;
import me.imyu.authz.web.model.TokenModel;

/**
 * Created by imyu on 2018-02-08.
 */
public interface TokenService {
    TokenModel getToken(String username, String password);
    void clearToken(String username);
    String getUsernameByAccessToken(String accessToken) throws AuthzException;
}
