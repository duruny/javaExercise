package com.spring_test.Spring属性注入之p模式;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.file.Paths;

/**
 * @author zjp
 * @since 2017-02-26.
 */
public class App
{
    public static void main(String[] args)
    {
        String path = Paths.get(App.class.getPackage().getName().replace(".", "/"), "Spring-Common.xml").toString();
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        HelloWorld world = (HelloWorld) context.getBean("helloWorld");
        world.printHelloWorld();
    }
}
