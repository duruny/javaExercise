package com.spring_test.Spring属性注入之p模式;

/**
 * @author zjp
 * @since 2017-02-26.
 */
public class HelloWorld
{
    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    public void printHelloWorld() {
        System.out.println("Hello : " + name);
    }
}
