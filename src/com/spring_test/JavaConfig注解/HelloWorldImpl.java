package com.spring_test.JavaConfig注解;

/**
 * @author zjp
 * @since 2017-02-26.
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public void printHelloWorld(String msg) {

        System.out.println("Hello : " + msg);
    }

}
