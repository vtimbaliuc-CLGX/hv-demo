package com.demo.api.tools;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SourceSwitcher {

    @Before("execution(* com.demo.api.repository.*.*(..))")
    public void checkStuff(){
        System.out.println("Bleh");
        //Generate mocks
        //return
    }
}
