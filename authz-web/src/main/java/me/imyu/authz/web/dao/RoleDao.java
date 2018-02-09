package me.imyu.authz.web.dao;

import me.imyu.authz.web.model.Resource;
import me.imyu.authz.web.model.Role;

import java.util.List;

/**
 * 负责角色以及关联资源数据的持久层接口定义
 * Created by imyu on 2018-02-08.
 */
public interface RoleDao {
    List<Role> selectByUserId(Long userId);
    List<Resource> selectResourceByUserId(Long userId);
}
