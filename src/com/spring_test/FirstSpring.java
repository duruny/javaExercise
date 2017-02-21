package com.spring_test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zjp
 * @since 2017-02-21.
 */
public class FirstSpring
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();
    }
}

class HelloWorld
{
    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    public void printHello()
    {
        System.out.println("Spring 3 : Hello ! " + name);
    }
}
