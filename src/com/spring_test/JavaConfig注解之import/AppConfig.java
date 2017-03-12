package com.spring_test.JavaConfig注解之import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zjp
 * @since 2017-02-26.
 */
@Configuration
@Import({CustomerConfig.class, SchedulerConfig.class})
public class AppConfig
{

}
