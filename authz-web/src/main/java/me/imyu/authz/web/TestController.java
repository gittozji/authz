package me.imyu.authz.web;

import me.imyu.authz.AuthzException;
import me.imyu.authz.api.AuthzAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by imyu on 2018-02-08.
 */
@RestController
public class TestController {
    @Autowired
    AuthzAPI authzAPI;

    @RequestMapping("/login")
    public Object login(String username, String password) {
        return authzAPI.getToken(username, password).getAccessToken();
    }

    @RequestMapping("/isPermitted")
    public Object isPermitted(String accessToken, String permission) {
        return authzAPI.isPermitted(accessToken, permission);
    }

    @RequestMapping("/checkPermission")
    public Object checkPermisstion(String accessToken, String permission) {
        try {
            authzAPI.checkPermission(accessToken, permission);
        } catch (AuthzException e) {
            return e.getMessage();
        } catch (Exception e) {
            return "系统服务异常";
        }
        return "拥有权限";
    }

}
