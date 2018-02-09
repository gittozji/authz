package me.imyu.authz.web.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by imyu on 2018-02-08.
 */
public class Role extends Id {
    String code;
    String name;
    String description;

    public Role() {
    }

    public Role(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static  Set<String> list2Set(List<Role> list) {
        Set<String> set = new HashSet<String>();
        for (Role role : list) {
            set.add(role.getCode());
        }
        return set;
    }
}
