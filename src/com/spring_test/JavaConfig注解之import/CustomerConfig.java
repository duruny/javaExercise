package com.spring_test.JavaConfig注解之import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zjp
 * @since 2017-02-26.
 */
@Configuration
public class CustomerConfig
{
    @Bean(name = "customer")
    public CustomerBo customerBo()
    {
        return new CustomerBo();

    }
}
