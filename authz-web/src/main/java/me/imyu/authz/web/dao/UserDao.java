package me.imyu.authz.web.dao;

import me.imyu.authz.web.model.User;

/**
 * Created by imyu on 2018-02-08.
 */
public interface UserDao {
    User selectByUsername(String username);
}
