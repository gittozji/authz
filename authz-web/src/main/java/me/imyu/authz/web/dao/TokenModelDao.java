package me.imyu.authz.web.dao;

import me.imyu.authz.web.model.TokenModel;

/**
 * Created by imyu on 2018-02-08.
 */
public interface TokenModelDao {
    void insert(TokenModel tokenModel);
    void deleteByUsername(String username);
    TokenModel selectByAccessToken(String accessToken);
}
