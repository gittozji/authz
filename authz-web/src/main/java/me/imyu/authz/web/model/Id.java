package me.imyu.authz.web.model;

import java.io.Serializable;

/**
 * Created by imyu on 2018-02-08.
 */
public class Id implements Serializable {
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
