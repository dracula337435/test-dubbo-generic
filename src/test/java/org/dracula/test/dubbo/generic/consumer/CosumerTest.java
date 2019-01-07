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

    @Reference
    private TestInterface testInterface;

    @Test
    public void test(){
        System.out.println(testInterface.sayHell("gxk"));
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
            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
            return registryConfig;
        }

    }

}
