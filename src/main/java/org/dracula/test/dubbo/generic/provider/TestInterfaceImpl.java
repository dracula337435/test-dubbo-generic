package org.dracula.test.dubbo.generic.provider;

import com.alibaba.dubbo.config.annotation.Service;
import org.dracula.test.dubbo.generic.TestInterface;

/**
 * @author dk
 */
@Service
public class TestInterfaceImpl implements TestInterface {

    @Override
    public String sayHell(String name) {
        return "hello "+name;
    }
}
