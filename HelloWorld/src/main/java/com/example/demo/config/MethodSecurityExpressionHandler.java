package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

/**
 * Created by Administrator on 2/7/2018.
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityExpressionHandler extends GlobalMethodSecurityConfiguration {

    @Override
    protected org.springframework.security.access.expression.method.MethodSecurityExpressionHandler createExpressionHandler() {
        return new OAuth2MethodSecurityExpressionHandler();
    }

}
