package com.demoAop.aspects;

import com.demoAop.entities.Account;
import org.aspectj.apache.bcel.util.ClassPath;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class LoginAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String loginTime = "";

    @Pointcut("execution(* com.demoAop.service.LoginService.authenticateAccount(..))")
    private void checkAuthenticate() {
    }

    @Before("checkAuthenticate()")
    private void logLogin(JoinPoint joinPoint) {
        loginTime = LocalDateTime.now().toString();
        logger.info("Time login : " + loginTime);
    }

    @After("checkAuthenticate()")
    private void saveLogIntoFile(JoinPoint joinPoint) throws IOException, ClassNotFoundException {
        File f = new ClassPathResource("log.txt").getFile();
        ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(f));
        Account account = (Account) joinPoint.getArgs()[0];
        outputStream.writeObject(account);
        outputStream.writeObject(loginTime);
        outputStream.close();


        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(f));
        Account a = ((Account)inputStream.readObject());
        System.out.println(a.toString());
    }
}
