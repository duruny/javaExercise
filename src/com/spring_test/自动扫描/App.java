package com.spring_test.自动扫描;

import com.spring_test.bean.CustomerServiceAuto;
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
        String path = Paths.get(com.spring_test.自动扫描.App.class.getPackage().getName().replace(".", "/"),
                                "Spring-AutoScan.xml").toString();
        ApplicationContext context = new ClassPathXmlApplicationContext(path);

        CustomerServiceAuto cust = (CustomerServiceAuto)context.getBean("customerServiceAuto");
        System.out.println(cust);
    }
}
