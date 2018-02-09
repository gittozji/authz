package me.imyu.authz.web;

import me.imyu.authz.web.secure.MyAuthorizingRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * Created by imyu on 2018-02-08.
 */
@SpringBootApplication
@MapperScan("me.imyu.authz.web.dao")
public class AuthzApplication implements EmbeddedServletContainerCustomizer {
    public static void main(String[] args) {
        SpringApplication.run(AuthzApplication.class, args);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(9191);
    }

    @Bean
    public SecurityManager securityManager(Realm myAuthorizingRealm) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(myAuthorizingRealm);
        return securityManager;
    }

}
