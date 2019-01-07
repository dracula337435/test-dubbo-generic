package org.dracula.test.dubbo.generic.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author dk
 */
@Component
public class MyInvocationHandler implements InvocationHandler {

    private static Logger logger = LoggerFactory.getLogger(MyInvocationHandler.class);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("收到请求，方法：" + method);
        logger.info("参数：" + Arrays.stream(args).map(Object::toString).collect(Collectors.joining(",")));
        return null;
    }

}
