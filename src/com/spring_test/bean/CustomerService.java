package com.spring_test.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author jianpeng.zhang
 * @since 2017/2/27.
 */
@Service
@Scope(value = "prototype")
public class CustomerService

{
    String message;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}