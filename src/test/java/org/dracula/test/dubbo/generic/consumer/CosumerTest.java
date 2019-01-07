package org.dracula.test.dubbo.generic.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.dracula.test.dubbo.generic.TestInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dk
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CosumerTest.TmpConfig.class)
public class CosumerTest {

    /**
     * 使用的是泛化实现
     */
    @Reference(group = "test-generic")
    private TestInterface testInterfaceByGeneric;

    @Test
    public void testByGeneric(){
        System.out.println(testInterfaceByGeneric.sayHell("gxk"));
    }

    /**
     * 使用的是泛化实现
     */
    @Reference(group = "test-jdk-d-p")
    private TestInterface testInterfaceByJdkDP;

    @Test
    public void testByJdkDP(){
        System.out.println(testInterfaceByJdkDP.sayHell("gxk"));
    }

    /**
     * @author dk
     */
    @Configuration
    @DubboComponentScan
    public static class TmpConfig{

        @Bean
        public ApplicationConfig applicationConfig(){
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("test-consumer");
            return applicationConfig;
        }

        @Bean
        public RegistryConfig registryConfig(){
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress("multicast://224.5.6.7:1234");
            return registryConfig;
        }

    }

}
