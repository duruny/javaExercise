package com.spring_test.松耦合;

/**
 * @author zjp
 * @since 2017-02-25.
 */
public class OutputHelper
{
    IOutputGenerator outputGenerator;

    public void generateOutput(){
        outputGenerator.generateOutput();
    }

    public void setOutputGenerator(IOutputGenerator outputGenerator){
        this.outputGenerator = outputGenerator;
    }
}
