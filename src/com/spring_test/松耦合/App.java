package com.spring_test.松耦合;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.file.Paths;

/**
 * @author zjp
 * @since 2017-02-25.
 */
public class App
{
    public static void main(String[] args)
    {
        String path = Paths.get(App.class.getPackage().getName().replace(".", "/"), "Spring-Common.xml").toString();

        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        OutputHelper helper = (OutputHelper) context.getBean("OutPutHelper");
        helper.generateOutput();
    }
}
