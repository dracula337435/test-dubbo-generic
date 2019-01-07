package org.dracula.test.dubbo.generic.provider;

import com.alibaba.dubbo.config.spring.ServiceBean;
import org.dracula.test.dubbo.generic.TestInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dk
 */
@Configuration
public class MyServiceConfiguration {

    @Bean
    public ServiceBean serviceBean(TestInterfaceImpl testInterface){
        ServiceBean serviceBean = new ServiceBean();
        serviceBean.setInterface(TestInterface.class);
        serviceBean.setRef(testInterface);
        return serviceBean;
    }

}
