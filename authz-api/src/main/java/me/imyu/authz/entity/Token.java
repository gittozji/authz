package me.imyu.authz.entity;

import java.sql.Timestamp;

/**
 * Created by imyu on 2018-02-08.
 */
public class Token {
    String accessToken;
    String refreshToken;
    Timestamp expireAt;
    Timestamp refreshExpireAt;

    public Token() {
    }

    public Token(String accessToken, String refreshToken, Timestamp expireAt, Timestamp refreshExpireAt) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expireAt = expireAt;
        this.refreshExpireAt = refreshExpireAt;
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
