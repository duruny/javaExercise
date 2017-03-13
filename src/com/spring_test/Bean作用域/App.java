package com.spring_test.Bean作用域;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring_test.bean.CustomerService;

import java.nio.file.Paths;

/**
 * @author jianpeng.zhang
 * @since 2017/2/27.
 */
public class App
{
    public static void main( String[] args )
    {

        String path = Paths.get(App.class.getPackage().getName().replace(".", "/"), "Spring-Customer.xml").toString();
        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        CustomerService custA = (CustomerService)context.getBean("customerService");
        custA.setMessage("Message by custA");
        System.out.println("Message : " + custA.getMessage());

        //retrieve it again
        CustomerService custB = (CustomerService)context.getBean("customerService");
        System.out.println("Message : " + custB.getMessage());
    }
}
