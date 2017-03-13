package com.spring_test.Spring集合;


import com.spring_test.bean.CustomerCollection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.nio.file.Paths;

/**
 * @author jianpeng.zhang
 * @since 2017/2/27.
 */
public class App
{

    public static void main(String[] args)
    {
        String path =
                Paths.get(App.class.getPackage().getName().replace(".", "/"), "applicationContext.xml").toString();
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        CustomerCollection customerBean = (CustomerCollection) context.getBean("CustomerBean");
        System.out.println(customerBean);
    }
}
