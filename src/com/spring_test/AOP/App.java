package com.spring_test.AOP;

import com.spring_test.bean.Person;
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
        String path =
                Paths.get(com.spring_test.AOP.App.class.getPackage().getName().replace(".", "/"), "Spring-AOP.xml")
                        .toString();
        ApplicationContext appContext = new ClassPathXmlApplicationContext(path);

        // Person cust = (Person) appContext.getBean("customerServiceProxy");
        Person cust = (Person) appContext.getBean("person-aop");

        System.out.println("*************************");
        cust.getName();
        System.out.println("*************************");
        cust.getAddress();
        System.out.println("*************************");

        // Address address = (Address) appContext.getBean("customerServiceProxy");
        // System.out.println(address.toString());
        try
        {
            cust.printThrowException();
        }
        catch (Exception e)
        {

        }

    }
}
