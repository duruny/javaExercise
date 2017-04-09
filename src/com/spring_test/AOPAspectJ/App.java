package com.spring_test.AOPAspectJ;

import com.spring_test.bean.CustomerBo;
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
        String path = Paths.get(com.spring_test.AOPAspectJ.App.class.getPackage().getName().replace(".", "/"),
                                "applicationContext.xml").toString();
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        CustomerBo customer = (CustomerBo) context.getBean("customerBo");
        customer.addCustomerAround("yiibai");

        customer.addCustomerReturnValue();
        try
        {
            customer.addCustomerThrowException();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
