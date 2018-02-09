package me.imyu.authz.web.util;

import java.util.UUID;

/**
 * Created by imyu on 2018-02-08.
 */
public class CodeGenerator {
    public static String get() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
