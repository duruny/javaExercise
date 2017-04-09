package com.spring_test.EL;

import com.spring_test.bean.Custom;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.file.Paths;

/**
 * @author zjp
 * @since 2017-04-09.
 */
public class App
{
    public static void main(String[] args)
    {
        String path = Paths.get(com.spring_test.EL.App.class.getPackage().getName().replace(".", "/"),
                                "Spring-EL.xml").toString();
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        Custom obj = (Custom) context.getBean("customerBean");
        System.out.println(obj);
    }

}
