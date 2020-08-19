package com.demoAop.config;

import com.demoAop.aspects.LoginAspect;
import com.demoAop.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
    @Bean
    public LoginService service(){
        return new LoginService();
    }
    @Bean
    public LoginAspect aspect(){
        return new LoginAspect();
    }
}
