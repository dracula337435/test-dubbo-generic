package org.dracula.test.dubbo.generic.provider;

import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author dk
 */
@Component
public class TestInterfaceImpl implements GenericService {

    private static Logger logger = LoggerFactory.getLogger(TestInterfaceImpl.class);

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] args) throws GenericException {
        logger.info("收到请求，方法：" + method);
        logger.info("参数类型：" + Arrays.stream(parameterTypes).collect(Collectors.joining(",")));
        logger.info("参数：" + Arrays.stream(args).map(Object::toString).collect(Collectors.joining(",")));
        return null;
    }

}
