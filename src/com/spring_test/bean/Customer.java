package com.spring_test.bean;

/**
 * @author jianpeng.zhang
 * @since 2017/2/27.
 */
public class Customer
{
    private Person person;

    public Customer(Person person)
    {
        this.person = person;
    }

    public void setPerson(Person person)
    {
        this.person = person;
    }

    @Override
    public String toString()
    {
        return "Customer [person=" + person + "]";
    }
}
