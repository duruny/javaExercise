package com.spring_test.bean;

/**
 * @author zjp
 * @since 2017-04-09.
 */
public interface CustomerBo
{
    void addCustomer();

    String addCustomerReturnValue();

    void addCustomerThrowException() throws Exception;

    void addCustomerAround(String name);
}
