package com.spring_test.AOP;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author zjp
 * @since 2017-04-09.
 */
public class HijackBeforeMethod implements MethodBeforeAdvice
{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable
    {
        System.out.println("HijackBeforeMethod : Before method hijacked!");
    }
}