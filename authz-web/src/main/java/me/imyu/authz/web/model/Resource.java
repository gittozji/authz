package me.imyu.authz.web.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by imyu on 2018-02-08.
 */
public class Resource {
    String code;
    String name;
    String description;

    public Resource() {
    }

    public Resource(String code, String name, String description) {
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

    public static Set<String> list2Set(List<Resource> list) {
        Set<String> set = new HashSet<String>();
        for (Resource resource : list) {
            set.add(resource.getCode());
        }
        return set;
    }
}
