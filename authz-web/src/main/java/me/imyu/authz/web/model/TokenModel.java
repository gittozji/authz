package me.imyu.authz.web.model;

import me.imyu.authz.web.util.CodeGenerator;

import java.sql.Timestamp;

/**
 * Created by imyu on 2018-02-08.
 */
public class TokenModel extends Id {
    Long userId;
    String username;
    String accessToken;
    String refreshToken;
    Timestamp createAt;
    Timestamp expireAt;
    Timestamp refreshExpireAt;

    public void init() {
        this.accessToken = CodeGenerator.get();
        this.refreshToken = CodeGenerator.get();
        this.createAt = new Timestamp(System.currentTimeMillis());
    }

    public TokenModel() {
    }

    public TokenModel(Long userId, String username, String accessToken, String refreshToken, Timestamp createAt, Timestamp expireAt, Timestamp refreshExpireAt) {
        this.userId = userId;
        this.username = username;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.createAt = createAt;
        this.expireAt = expireAt;
        this.refreshExpireAt = refreshExpireAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Timestamp expireAt) {
        this.expireAt = expireAt;
    }

    public Timestamp getRefreshExpireAt() {
        return refreshExpireAt;
    }

    public void setRefreshExpireAt(Timestamp refreshExpireAt) {
        this.refreshExpireAt = refreshExpireAt;
    }
}
