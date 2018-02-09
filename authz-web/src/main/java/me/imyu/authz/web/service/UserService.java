package me.imyu.authz.web.service;

import me.imyu.authz.web.model.Resource;
import me.imyu.authz.web.model.Role;
import me.imyu.authz.web.model.User;

import java.util.List;

/**
 * Created by imyu on 2018-02-08.
 */
public interface UserService {
    boolean check(String username, String password);
    User findUserByUsername(String username);

    List<Role> findRoleByUserId(Long userId);

    List<Resource> findResourceByUserId(Long userId);
}
