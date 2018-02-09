package me.imyu.authz.web.service.impl;

import me.imyu.authz.AuthzException;
import me.imyu.authz.web.dao.TokenModelDao;
import me.imyu.authz.web.model.TokenModel;
import me.imyu.authz.web.model.User;
import me.imyu.authz.web.service.TokenService;
import me.imyu.authz.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Created by imyu on 2018-02-08.
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    UserService userService;
    @Autowired
    TokenModelDao tokenModelDao;
    @Value("${token.time}")
    String tokenTime;
    @Value("${refresh.token.time}")
    String refreshTokenTime;
    @Override
    public TokenModel getToken(String username, String password) {
        TokenModel tokenModel = new TokenModel();
        tokenModel.init();
        tokenModel.setUserId(userService.findUserByUsername(username).getId());
        tokenModel.setUsername(userService.findUserByUsername(username).getUsername());
        tokenModel.setExpireAt(new Timestamp(System.currentTimeMillis() + Long.valueOf(tokenTime)));
        tokenModel.setRefreshExpireAt(new Timestamp(System.currentTimeMillis() + Long.valueOf(refreshTokenTime)));
        tokenModelDao.insert(tokenModel);
        return tokenModel;
    }

    @Override
    public void clearToken(String username) {
        tokenModelDao.deleteByUsername(username);
    }

    @Override
    public String getUsernameByAccessToken(String accessToken) throws AuthzException {
        TokenModel tokenModel = tokenModelDao.selectByAccessToken(accessToken);
        if (tokenModel == null) {
            throw new AuthzException("无效的access_token");
        }
        if (System.currentTimeMillis() > tokenModel.getExpireAt().getTime()) {
            throw new AuthzException("access_token已过期");
        }
        return tokenModel.getUsername();
    }
}