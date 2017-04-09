package com.spring_test.bean;

/**
 * @author jianpeng.zhang
 * @since 2017/2/27.
 */
public class Person
{
    private String name;
    private String address;
    private int age;

    public String getName()
    {
        System.out.println(name);
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        System.out.println(address);
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void printThrowException() {
        throw new IllegalArgumentException();
    }


    @Override
    public String toString()
    {

        return "Person [address=" + address + ",  age = " + age + ", name = " + name + "]";
    }
}
