package org.dracula.test.dubbo.generic.provider;

import com.alibaba.dubbo.config.spring.ServiceBean;
import org.dracula.test.dubbo.generic.TestInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

/**
 * @author dk
 */
@Configuration
public class MyServiceConfiguration {

    /**
     *
     * @param testInterface
     * @return
     */
    @Bean
    public ServiceBean serviceBean(TestInterfaceImpl testInterface){
        ServiceBean serviceBean = new ServiceBean();
        serviceBean.setInterface(TestInterface.class);
        serviceBean.setRef(testInterface);
        //为了试验说明问题
        serviceBean.setGroup("test-generic");
        return serviceBean;
    }

    /**
     *
     * @param myInvocationHandler
     * @return
     */
    @Bean
    public ServiceBean serviceBeanByJdkDP(MyInvocationHandler myInvocationHandler){
        ServiceBean serviceBean = new ServiceBean();
        serviceBean.setInterface(TestInterface.class);
        serviceBean.setRef(Proxy.newProxyInstance(TestInterface.class.getClassLoader(), new Class[]{TestInterface.class}, myInvocationHandler));
        //为了试验说明问题
        serviceBean.setGroup("test-jdk-d-p");
        return serviceBean;
    }

}
