package com.spring_test.JavaConfig注解之import;

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
        CustomerBo customerBo = (CustomerBo) context.getBean("customer");
        SchedulerBo schedulerBo = (SchedulerBo) context.getBean("scheduler");
        customerBo.printMsg("Hello 11");
        schedulerBo.printMsg("Hello 22");
    }
}
