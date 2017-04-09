package com.spring_test.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zjp
 * @since 2017-04-09.
 */
@Component("customerBean")
public class Custom
{
    @Value("#{addressBean}")
    private Address address;

    @Value("#{addressBean.country}")
    private String country;

    @Value("#{addressBean.getFullAddress('yiibai')}")
    private String fullAddress;

    //getter and setter methods


    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getFullAddress()
    {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress)
    {
        this.fullAddress = fullAddress;
    }

    @Override
    public String toString()
    {
        return "Customer [address=" + address + "\n, country=" + country + "\n, fullAddress=" + fullAddress + "]";
    }

}
