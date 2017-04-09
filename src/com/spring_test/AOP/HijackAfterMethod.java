package com.spring_test.AOP;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author zjp
 * @since 2017-04-09.
 */
public class HijackAfterMethod implements AfterReturningAdvice
{
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable
    {
        System.out.println("HijackAfterMethod : After method hijacked!");
    }
}
