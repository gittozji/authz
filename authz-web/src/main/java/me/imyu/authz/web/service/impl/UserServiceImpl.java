package me.imyu.authz.web.service.impl;

import me.imyu.authz.web.dao.RoleDao;
import me.imyu.authz.web.dao.UserDao;
import me.imyu.authz.web.model.Resource;
import me.imyu.authz.web.model.Role;
import me.imyu.authz.web.model.User;
import me.imyu.authz.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by imyu on 2018-02-08.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Override
    public boolean check(String username, String password) {
        User user = userDao.selectByUsername(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public List<Role> findRoleByUserId(Long userId) {
        return roleDao.selectByUserId(userId);
    }

    @Override
    public List<Resource> findResourceByUserId(Long userId) {
        return roleDao.selectResourceByUserId(userId);
    }
}
