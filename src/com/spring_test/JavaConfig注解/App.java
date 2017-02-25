package com.spring_test.JavaConfig注解;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zjp
 * @since 2017-02-26.
 */
public class App
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHelloWorld("Spring Java Config");
    }
}
