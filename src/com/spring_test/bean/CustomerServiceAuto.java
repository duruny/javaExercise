package com.spring_test.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zjp
 * @since 2017-04-09.
 */
@Component
public class CustomerServiceAuto
{
    @Autowired
    CustomerDAO customerDAO;

    @Override
    public String toString() {
        return "CustomerServiceAuto [customerDAO=" + customerDAO + "]";
    }
}
