package com.spring_test.AOP;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author zjp
 * @since 2017-04-09.
 */
public class HijackThrowException implements ThrowsAdvice
{
    public void afterThrowing(IllegalArgumentException e) throws Throwable
    {
        System.out.println("HijackThrowException : Throw exception hijacked!");
    }
}
